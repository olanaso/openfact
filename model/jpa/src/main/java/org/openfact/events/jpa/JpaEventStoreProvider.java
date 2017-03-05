package org.openfact.events.jpa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.openfact.events.OpenfactEvent;
import org.openfact.events.OpenfactEventQuery;
import org.openfact.events.OpenfactEventStoreProvider;
import org.openfact.events.OpenfactEventType;
import org.openfact.events.admin.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Stateless
public class JpaEventStoreProvider implements OpenfactEventStoreProvider {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeReference<Map<String, String>> mapType = new TypeReference<Map<String, String>>() {
    };
    private static final Logger logger = Logger.getLogger(JpaEventStoreProvider.class);

    @Inject
    private OpenfactEventQuery eventQuery;

    @Inject
    private AdminEventQuery adminEventQuery;

    @PersistenceContext
    private EntityManager em;

    static EventEntity convertEvent(OpenfactEvent event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(UUID.randomUUID().toString());
        eventEntity.setTime(event.getTime());
        eventEntity.setType(event.getType().toString());
        eventEntity.setOrganizationId(event.getOrganizationId());
        eventEntity.setUserId(event.getUserId());
        eventEntity.setIpAddress(event.getIpAddress());
        eventEntity.setError(event.getError());
        try {
            eventEntity.setDetailsJson(mapper.writeValueAsString(event.getDetails()));
        } catch (IOException ex) {
            logger.error("Failed to write log details", ex);
        }
        return eventEntity;
    }

    static OpenfactEvent convertEvent(EventEntity eventEntity) {
        OpenfactEvent event = new OpenfactEvent();
        event.setTime(eventEntity.getTime());
        event.setType(OpenfactEventType.valueOf(eventEntity.getType()));
        event.setOrganizationId(eventEntity.getOrganizationId());
        event.setUserId(eventEntity.getUserId());
        event.setIpAddress(eventEntity.getIpAddress());
        event.setError(eventEntity.getError());
        try {
            Map<String, String> details = mapper.readValue(eventEntity.getDetailsJson(), mapType);
            event.setDetails(details);
        } catch (IOException ex) {
            logger.error("Failed to read log details", ex);
        }
        return event;
    }

    static AdminEventEntity convertAdminEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        AdminEventEntity adminEventEntity = new AdminEventEntity();
        adminEventEntity.setId(UUID.randomUUID().toString());
        adminEventEntity.setTime(adminEvent.getTime());
        adminEventEntity.setOrganizationId(adminEvent.getOrganizationId());
        setAuthDetails(adminEventEntity, adminEvent.getAuthDetails());
        adminEventEntity.setOperationType(adminEvent.getOperationType().toString());

        if (adminEvent.getResourceType() != null) {
            adminEventEntity.setResourceType(adminEvent.getResourceType().toString());
        }

        adminEventEntity.setResourcePath(adminEvent.getResourcePath());
        adminEventEntity.setError(adminEvent.getError());

        if (includeRepresentation) {
            adminEventEntity.setRepresentation(adminEvent.getRepresentation());
        }
        return adminEventEntity;
    }

    static AdminEvent convertAdminEvent(AdminEventEntity adminEventEntity) {
        AdminEvent adminEvent = new AdminEvent();
        adminEvent.setTime(adminEventEntity.getTime());
        adminEvent.setOrganizationId(adminEventEntity.getOrganizationId());
        setAuthDetails(adminEvent, adminEventEntity);
        adminEvent.setOperationType(OperationType.valueOf(adminEventEntity.getOperationType()));

        if (adminEventEntity.getResourceType() != null) {
            adminEvent.setResourceType(ResourceType.valueOf(adminEventEntity.getResourceType()));
        }

        adminEvent.setResourcePath(adminEventEntity.getResourcePath());
        adminEvent.setError(adminEventEntity.getError());

        if (adminEventEntity.getRepresentation() != null) {
            adminEvent.setRepresentation(adminEventEntity.getRepresentation());
        }
        return adminEvent;
    }

    private static void setAuthDetails(AdminEventEntity adminEventEntity, AuthDetails authDetails) {
        adminEventEntity.setAuthOrganizationId(authDetails.getOrganizationId());
        adminEventEntity.setAuthUserId(authDetails.getUserId());
        adminEventEntity.setAuthIpAddress(authDetails.getIpAddress());
    }

    private static void setAuthDetails(AdminEvent adminEvent, AdminEventEntity adminEventEntity) {
        AuthDetails authDetails = new AuthDetails();
        authDetails.setOrganizationId(adminEventEntity.getAuthOrganizationId());
        authDetails.setUserId(adminEventEntity.getAuthUserId());
        authDetails.setIpAddress(adminEventEntity.getAuthIpAddress());
        adminEvent.setAuthDetails(authDetails);
    }

    @Override
    public OpenfactEventQuery createQuery() {
        return eventQuery;
    }

    @Override
    public void clear() {
        em.createQuery("delete from EventEntity").executeUpdate();
    }

    @Override
    public void clear(String organizationId) {
        em.createQuery("delete from EventEntity where organizationId = :organizationId").setParameter("organizationId", organizationId).executeUpdate();
    }

    @Override
    public void clear(String organizationId, long olderThan) {
        em.createQuery("delete from EventEntity where organizationId = :organizationId and time < :time").setParameter("organizationId", organizationId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public void onEvent(OpenfactEvent event) {
        em.persist(convertEvent(event));
    }

    @Override
    public AdminEventQuery createAdminQuery() {
        return adminEventQuery;
    }

    @Override
    public void clearAdmin() {
        em.createQuery("delete from AdminEventEntity").executeUpdate();
    }

    @Override
    public void clearAdmin(String organizationId) {
        em.createQuery("delete from AdminEventEntity where organizationId = :organizationId").setParameter("organizationId", organizationId).executeUpdate();
    }

    @Override
    public void clearAdmin(String organizationId, long olderThan) {
        em.createQuery("delete from AdminEventEntity where organizationId = :organizationId and time < :time").setParameter("organizationId", organizationId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {
        em.persist(convertAdminEvent(event, includeRepresentation));
    }

}
