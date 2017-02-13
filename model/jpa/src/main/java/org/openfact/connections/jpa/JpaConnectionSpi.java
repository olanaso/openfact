package org.openfact.connections.jpa;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class JpaConnectionSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "connectionsJpa";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return JpaConnectionProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return JpaConnectionProviderFactory.class;
    }

}
