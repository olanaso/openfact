package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.UnitCatalogProvider;

public class JpaUnitCatalogProvider implements UnitCatalogProvider {
	protected static final Logger logger = Logger.getLogger(JpaUnitCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaUnitCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}