package org.openfact.models.catalog.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class DocumentTypeCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "documentTypeCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return DocumentTypeCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return DocumentTypeCatalogProviderFactory.class;
	}

}