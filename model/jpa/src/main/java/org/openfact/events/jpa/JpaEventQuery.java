package org.openfact.events.jpa;

import org.openfact.events.OpenfactEvent;
import org.openfact.events.OpenfactEventQuery;
import org.openfact.events.OpenfactEventType;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class JpaEventQuery implements OpenfactEventQuery {

    private CriteriaBuilder cb;
    private CriteriaQuery<EventEntity> cq;
    private Root<EventEntity> root;
    private ArrayList<Predicate> predicates;
    private Integer firstResult;
    private Integer maxResults;

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void init() {
        this.em = em;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(EventEntity.class);
        root = cq.from(EventEntity.class);
        predicates = new ArrayList<Predicate>(4);
    }

    @Override
    public OpenfactEventQuery type(OpenfactEventType... types) {
        List<String> eventStrings = new LinkedList<String>();
        for (OpenfactEventType e : types) {
            eventStrings.add(e.toString());
        }
        predicates.add(root.get("type").in(eventStrings));
        return this;
    }

    @Override
    public OpenfactEventQuery organization(String organizationId) {
        predicates.add(cb.equal(root.get("organizationId"), organizationId));
        return this;
    }

    @Override
    public OpenfactEventQuery user(String userId) {
        predicates.add(cb.equal(root.get("userId"), userId));
        return this;
    }

    @Override
    public OpenfactEventQuery fromDate(Date fromDate) {
        predicates.add(cb.greaterThanOrEqualTo(root.<Long>get("time"), fromDate.getTime()));
        return this;
    }

    @Override
    public OpenfactEventQuery toDate(Date toDate) {
        predicates.add(cb.lessThanOrEqualTo(root.<Long>get("time"), toDate.getTime()));
        return this;
    }

    @Override
    public OpenfactEventQuery ipAddress(String ipAddress) {
        predicates.add(cb.equal(root.get("ipAddress"), ipAddress));
        return this;
    }

    @Override
    public OpenfactEventQuery firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    @Override
    public OpenfactEventQuery maxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @Override
    public List<OpenfactEvent> getResultList() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        cq.orderBy(cb.desc(root.get("time")));

        TypedQuery<EventEntity> query = em.createQuery(cq);

        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }

        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }

        List<OpenfactEvent> events = new LinkedList<OpenfactEvent>();
        for (EventEntity e : query.getResultList()) {
            events.add(JpaEventStoreProvider.convertEvent(e));
        }

        return events;
    }

}
