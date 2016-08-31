package org.openfact.exportimport;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ExportSpi implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "export";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return ExportProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return ExportProviderFactory.class;
	}
}
