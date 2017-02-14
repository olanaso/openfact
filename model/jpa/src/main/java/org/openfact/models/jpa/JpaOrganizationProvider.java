package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JpaOrganizationProvider extends AbstractHibernateStorage implements OrganizationProvider {

    private static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ASSIGNED_IDENTIFICATION_ID = "assignedIdentificationId";
    private static final String SUPPLIER_NAME = "supplierName";
    private static final String REGISTRATION_NAME = "registrationName";

    protected final OpenfactSession session;
    protected EntityManager em;

    public JpaOrganizationProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public MigrationModel getMigrationModel() {
        return new MigrationModelAdapter(em);
    }

    @Override
    public OrganizationModel createOrganization(String name) {
        return createOrganization(OpenfactModelUtils.generateId(), name);
    }

    @Override
    public OrganizationModel createOrganization(String id, String name) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        OrganizationEntity organization = new OrganizationEntity();
        organization.setName(name);
        organization.setId(id);
        organization.setCreatedTimestamp(LocalDateTime.now());
        organization.setEnabled(true);
        em.persist(organization);
        em.flush();

        final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationCreationEvent() {
            @Override
            public OrganizationModel getCreatedOrganization() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public OrganizationModel getOrganization(String id) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, id);
        if (organization == null) {
            return null;
        }
        OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
        return adapter;
    }

    @Override
    public OrganizationModel getOrganizationByName(String name) {
        TypedQuery<String> query = em.createNamedQuery("getOrganizationIdByName", String.class);
        query.setParameter("name", name);
        List<String> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        if (entities.size() > 1)
            throw new IllegalStateException("Should not be more than one documentLine with same name");
        String id = query.getResultList().get(0);

        return session.organizations().getOrganization(id);
    }

    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        em.refresh(organization);
        final OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
        session.documents().preRemove(adapter);

        session.jobReports().preRemove(adapter);
        session.files().preRemove(adapter);

        em.flush();

        int num = em.createNamedQuery("deleteComponentConfigByOrganization").setParameter("organization", organization).executeUpdate();
        num = em.createNamedQuery("deleteComponentByOrganization").setParameter("organization", organization).executeUpdate();

        em.remove(organization);

        em.flush();
        em.clear();

        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationRemovedEvent() {
            @Override
            public OrganizationModel getOrganization() {
                return adapter;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });

        return true;
    }

    @Override
    public boolean removeOrganization(OrganizationModel organization) {
        return removeOrganization(organization.getId());
    }

    @Override
    public List<OrganizationModel> getOrganizations() {
        return getOrganizations(-1, -1);
    }

    @Override
    public List<OrganizationModel> getOrganizations(int firstResult, int maxResults) {
        TypedQuery<String> query = em.createNamedQuery("getAllOrganizationIds", String.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }

        List<String> entities = query.getResultList();
        List<OrganizationModel> organizations = new ArrayList<>();
        for (String id : entities) {
            OrganizationModel organization = session.organizations().getOrganization(id);
            if (organization != null) {
                organizations.add(organization);
            }
        }
        return organizations;
    }

    @Override
    public int getOrganizationsCount() {
        Query query = em.createNamedQuery("getOrganizationsCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
