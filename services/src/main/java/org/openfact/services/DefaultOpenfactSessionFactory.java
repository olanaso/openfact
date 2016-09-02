package org.openfact.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderEvent;
import org.openfact.provider.ProviderEventListener;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.ProviderManager;
import org.openfact.provider.Spi;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class DefaultOpenfactSessionFactory implements OpenfactSessionFactory {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private Set<Spi> spis = new HashSet<>();
    private Map<Class<? extends Provider>, String> provider = new HashMap<Class<? extends Provider>, String>();
    private Map<Class<? extends Provider>, Map<String, ProviderFactory>> factoriesMap = new HashMap<Class<? extends Provider>, Map<String, ProviderFactory>>();
    protected CopyOnWriteArrayList<ProviderEventListener> listeners = new CopyOnWriteArrayList<ProviderEventListener>();

    // TODO: Likely should be changed to int and use Time.currentTime() to be compatible with all our "time" reps
    protected long serverStartupTimestamp;

    @Override
    public void register(ProviderEventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregister(ProviderEventListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void publish(ProviderEvent event) {
        for (ProviderEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }

    public void init() {
        serverStartupTimestamp = System.currentTimeMillis();

        ProviderManager pm = new ProviderManager(getClass().getClassLoader(), Config.scope().getArray("providers"));

        // Load the SPI classes through the provider manager, so both Openfact internal SPI's and
        // the ones defined in deployed modules will be found.
        loadSPIs(pm, pm.loadSpis());
        for ( Map<String, ProviderFactory> factories : factoriesMap.values()) {
            for (ProviderFactory factory : factories.values()) {
                factory.postInit(this);
            }
        }
    }

    protected void loadSPIs(ProviderManager pm, List<Spi> spiList) {
        for (Spi spi : spiList) {
            spis.add(spi);

            Map<String, ProviderFactory> factories = new HashMap<String, ProviderFactory>();
            factoriesMap.put(spi.getProviderClass(), factories);

            String provider = Config.getProvider(spi.getName());
            if (provider != null) {
                this.provider.put(spi.getProviderClass(), provider);

                ProviderFactory factory = pm.load(spi, provider);
                if (factory == null) {
                    throw new RuntimeException("Failed to find provider " + provider + " for " + spi.getName());
                }

                Config.Scope scope = Config.scope(spi.getName(), provider);
                factory.init(scope);

                if (spi.isInternal() && !isInternal(factory)) {
                    logger.spiMayChange(factory.getId(), factory.getClass().getName(), spi.getName());
                }

                factories.put(factory.getId(), factory);

                logger.debugv("Loaded SPI {0} (provider = {1})", spi.getName(), provider);
            } else {
                for (ProviderFactory factory : pm.load(spi)) {
                    Config.Scope scope = Config.scope(spi.getName(), factory.getId());
                    if (scope.getBoolean("enabled", true)) {
                        factory.init(scope);

                        if (spi.isInternal() && !isInternal(factory)) {
                            logger.spiMayChange(factory.getId(), factory.getClass().getName(), spi.getName());
                        }

                        factories.put(factory.getId(), factory);
                    } else {
                        logger.debugv("SPI {0} provider {1} disabled", spi.getName(), factory.getId());
                    }
                }

                if (factories.size() == 1) {
                    provider = factories.values().iterator().next().getId();
                    this.provider.put(spi.getProviderClass(), provider);

                    logger.debugv("Loaded SPI {0} (provider = {1})", spi.getName(), provider);
                } else {
                    logger.debugv("Loaded SPI {0} (providers = {1})", spi.getName(), factories.keySet());
                }
            }
        }
    }

    public OpenfactSession create() {
        return new DefaultOpenfactSession(this);
    }

    <T extends Provider> String getDefaultProvider(Class<T> clazz) {
        return provider.get(clazz);
    }

    @Override
    public Set<Spi> getSpis() {
        return spis;
    }

    @Override
    public <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz) {
         return getProviderFactory(clazz, provider.get(clazz));
    }

    @Override
    public <T extends Provider> ProviderFactory<T> getProviderFactory(Class<T> clazz, String id) {
        Map<String, ProviderFactory> map = factoriesMap.get(clazz);
        if (map == null) {
            return null;
        }
        return map.get(id);
    }

    @Override
    public List<ProviderFactory> getProviderFactories(Class<? extends Provider> clazz) {
        List<ProviderFactory> list = new LinkedList<ProviderFactory>();
        if (factoriesMap == null) return list;
        Map<String, ProviderFactory> providerFactoryMap = factoriesMap.get(clazz);
        if (providerFactoryMap == null) return list;
        list.addAll(providerFactoryMap.values());
        return list;
    }

    <T extends Provider> Set<String> getAllProviderIds(Class<T> clazz) {
        Set<String> ids = new HashSet<String>();
        for (ProviderFactory f : factoriesMap.get(clazz).values()) {
            ids.add(f.getId());
        }
        return ids;
    }

    public void close() {
        for (Map<String, ProviderFactory> factories : factoriesMap.values()) {
            for (ProviderFactory factory : factories.values()) {
                factory.close();
            }
        }
    }

    private boolean isInternal(ProviderFactory<?> factory) {
        return factory.getClass().getPackage().getName().startsWith("org.keycloak");
    }

    /**
     * @return timestamp of Openfact server startup
     */
    @Override
    public long getServerStartupTimestamp() {
        return serverStartupTimestamp;
    }

}
