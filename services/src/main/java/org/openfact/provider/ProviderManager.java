package org.openfact.provider;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.openfact.services.ServicesLogger;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class ProviderManager {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private List<ProviderLoader> loaders = new LinkedList<ProviderLoader>();
    private Map<String, List<ProviderFactory>> cache = new HashMap<String, List<ProviderFactory>>();

    public ProviderManager(ClassLoader baseClassLoader, String... resources) {
        List<ProviderLoaderFactory> factories = new LinkedList<ProviderLoaderFactory>();
        for (ProviderLoaderFactory f : ServiceLoader.load(ProviderLoaderFactory.class, getClass().getClassLoader())) {
            factories.add(f);
        }

        logger.debugv("Provider loaders {0}", factories);

        loaders.add(new DefaultProviderLoader(baseClassLoader));

        if (resources != null) {
            for (String r : resources) {
                String type = r.substring(0, r.indexOf(':'));
                String resource = r.substring(r.indexOf(':') + 1, r.length());

                boolean found = false;
                for (ProviderLoaderFactory f : factories) {
                    if (f.supports(type)) {
                        loaders.add(f.create(baseClassLoader, resource));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new RuntimeException("Provider loader for " + r + " not found");
                }
            }
        }
    }

    public synchronized List<Spi> loadSpis() {
        // Use a map to prevent duplicates, since the loaders may have overlapping classpaths.
        Map<String, Spi> spiMap = new HashMap<>();
        for (ProviderLoader loader : loaders) {
            List<Spi> spis = loader.loadSpis();
            if (spis != null) {
                for (Spi spi : spis) {
                    spiMap.put(spi.getName(), spi);
                }
            }
        }
        return new LinkedList<>(spiMap.values());
    }

    public synchronized List<ProviderFactory> load(Spi spi) {
        List<ProviderFactory> factories = cache.get(spi.getName());
        if (factories == null) {
            factories = new LinkedList<ProviderFactory>();
            IdentityHashMap factoryClasses = new IdentityHashMap();
            for (ProviderLoader loader : loaders) {
                List<ProviderFactory> f = loader.load(spi);
                if (f != null) {
                    for (ProviderFactory pf: f) {
                        // make sure there are no duplicates
                        if (!factoryClasses.containsKey(pf.getClass())) {
                            factories.add(pf);
                            factoryClasses.put(pf.getClass(), pf);
                        }
                    }
                }
            }
        }
        return factories;
    }

    public synchronized ProviderFactory load(Spi spi, String providerId) {
        for (ProviderFactory f : load(spi)) {
            if (f.getId().equals(providerId)) {
                return f;
            }
        }
        return null;
    }

}
