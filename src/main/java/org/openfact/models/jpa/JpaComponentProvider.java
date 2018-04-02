package org.openfact.models.jpa;

import org.keycloak.common.util.MultivaluedHashMap;
import org.openfact.keys.component.ComponentFactory;
import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.component.utils.ComponentUtil;
import org.openfact.models.CompanyModel;
import org.openfact.models.ComponentProvider;
import org.openfact.models.ModelException;
import org.openfact.models.jpa.entities.ComponentConfigEntity;
import org.openfact.models.jpa.entities.ComponentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Transactional
@ApplicationScoped
public class JpaComponentProvider implements ComponentProvider {

    /**
     * Components
     */
    public static final String COMPONENT_PROVIDER_EXISTS_DISABLED = "component.provider.exists.disabled";

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ComponentUtil componentUtil;

    @Override
    public ComponentModel addComponentModel(CompanyModel company, ComponentModel model) throws ModelException {
        model = importComponentModel(company, model);
        componentUtil.notifyCreated(company, model);
        return model;
    }

    @Override
    public ComponentModel importComponentModel(CompanyModel company, ComponentModel model) throws ModelException {
        ComponentFactory componentFactory = null;
        try {
            componentFactory = componentUtil.getComponentFactory(model);
            if (componentFactory == null && System.getProperty(COMPONENT_PROVIDER_EXISTS_DISABLED) == null) {
                throw new IllegalArgumentException("Invalid component type");
            }
            componentFactory.validateConfiguration(company, model);
        } catch (Exception e) {
            if (System.getProperty(COMPONENT_PROVIDER_EXISTS_DISABLED) == null) {
                throw e;
            }
        }

        ComponentEntity c = new ComponentEntity();
        if (model.getId() == null) {
            c.setId(UUID.randomUUID().toString());
        } else {
            c.setId(model.getId());
        }
        c.setName(model.getName());
        c.setParentId(model.getParentId());
        if (model.getParentId() == null) {
            c.setParentId(company.getId());
            model.setParentId(company.getId());
        }
        c.setProviderType(model.getProviderType());
        c.setProviderId(model.getProviderId());
        c.setSubType(model.getSubType());
        c.setCompany(CompanyAdapter.toEntity(company, em));
        em.persist(c);
        setConfig(model, c);
        model.setId(c.getId());
        return model;
    }

    protected void setConfig(ComponentModel model, ComponentEntity c) {
        for (String key : model.getConfig().keySet()) {
            List<String> vals = model.getConfig().get(key);
            if (vals == null) {
                continue;
            }
            for (String val : vals) {
                ComponentConfigEntity config = new ComponentConfigEntity();
                config.setId(UUID.randomUUID().toString());
                config.setName(key);
                config.setValue(val);
                config.setComponent(c);
                em.persist(config);
            }
        }
    }

    @Override
    public void updateComponent(CompanyModel company, ComponentModel component) throws ModelException {
        componentUtil.getComponentFactory(component).validateConfiguration(company, component);

        ComponentEntity c = em.find(ComponentEntity.class, component.getId());
        if (c == null) return;
        c.setName(component.getName());
        c.setProviderId(component.getProviderId());
        c.setProviderType(component.getProviderType());
        c.setParentId(component.getParentId());
        c.setSubType(component.getSubType());
        em.createNamedQuery("deleteComponentConfigByComponent").setParameter("component", c).executeUpdate();
        em.flush();
        setConfig(component, c);
        componentUtil.notifyUpdated(company, component);
    }

    @Override
    public void removeComponent(CompanyModel company, ComponentModel component) {
        ComponentEntity c = em.find(ComponentEntity.class, component.getId());
        if (c == null) return;
        removeComponents(company, component.getId());
        em.createNamedQuery("deleteComponentConfigByComponent").setParameter("component", c).executeUpdate();
        em.remove(c);
    }

    @Override
    public void removeComponents(CompanyModel company, String parentId) {
        TypedQuery<String> query = em.createNamedQuery("getComponentIdsByParent", String.class)
                .setParameter("company", CompanyAdapter.toEntity(company, em))
                .setParameter("parentId", parentId);

        List<String> results = query.getResultList();
        if (results.isEmpty()) return;
        em.createNamedQuery("deleteComponentConfigByParent").setParameter("parentId", parentId).executeUpdate();
        em.createNamedQuery("deleteComponentByParent").setParameter("parentId", parentId).executeUpdate();
    }

    @Override
    public List<ComponentModel> getComponents(CompanyModel company, String parentId, String providerType) {
        if (parentId == null) parentId = company.getId();

        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponentsByParentAndType", ComponentEntity.class)
                .setParameter("company", CompanyAdapter.toEntity(company, em))
                .setParameter("parentId", parentId)
                .setParameter("providerType", providerType);

        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);

        }
        return rtn;
    }

    @Override
    public List<ComponentModel> getComponents(CompanyModel company, String parentId) {
        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponentByParent", ComponentEntity.class)
                .setParameter("company", CompanyAdapter.toEntity(company, em))
                .setParameter("parentId", parentId);

        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);

        }
        return rtn;
    }

    protected ComponentModel entityToModel(ComponentEntity c) {
        ComponentModel model = new ComponentModel();
        model.setId(c.getId());
        model.setName(c.getName());
        model.setProviderType(c.getProviderType());
        model.setProviderId(c.getProviderId());
        model.setSubType(c.getSubType());
        model.setParentId(c.getParentId());
        MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

        TypedQuery<ComponentConfigEntity> configQuery = em.createNamedQuery("getComponentConfig", ComponentConfigEntity.class)
                .setParameter("component", c);

        List<ComponentConfigEntity> configResults = configQuery.getResultList();
        for (ComponentConfigEntity configEntity : configResults) {
            config.add(configEntity.getName(), configEntity.getValue());
        }
        model.setConfig(config);
        return model;
    }

    @Override
    public List<ComponentModel> getComponents(CompanyModel company) {
        TypedQuery<ComponentEntity> query = em.createNamedQuery("getComponents", ComponentEntity.class)
                .setParameter("company", CompanyAdapter.toEntity(company, em));

        List<ComponentEntity> results = query.getResultList();
        List<ComponentModel> rtn = new LinkedList<>();
        for (ComponentEntity c : results) {
            ComponentModel model = entityToModel(c);
            rtn.add(model);
        }
        return rtn;
    }

    @Override
    public ComponentModel getComponent(CompanyModel company, String id) {
        ComponentEntity c = em.find(ComponentEntity.class, id);
        if (c == null) return null;
        return entityToModel(c);
    }

}