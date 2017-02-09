package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.UBLDocumentEntity;
import org.openfact.models.jpa.entities.UBLDocumentRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentCriteria<R, Q> {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<Q> cq;
    private final Root<R> root;
    private final ArrayList<Predicate> predicates;
    private Map<String, Boolean> orderBy;

    private final OrganizationModel organization;
    private final OpenfactSession session;

    public DocumentCriteria(OpenfactSession session, OrganizationModel organization, EntityManager em, Class<R> rClass, Class<Q> qClass) {
        this.em = em;

        this.organization = organization;
        this.session = session;

        cb = em.getCriteriaBuilder();
        cq = getCriteriaBuilder().createQuery(qClass);
        root = getCriteriaQuery().from(rClass);
        predicates = new ArrayList<>();

        orderBy = new HashMap<>();

        this.predicates.add(getCriteriaBuilder().equal(getRoot().get(JpaDocumentProvider.ORGANIZATION_ID), organization.getId()));
    }

    public DocumentCriteria currencyCode(String... currencyCode) {
        List<String> currencyCodes = Arrays.asList(currencyCode).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(getCriteriaBuilder().upper(getRoot().get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        return this;
    }

    public DocumentCriteria documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(getCriteriaBuilder().upper(getRoot().get(JpaDocumentProvider.DOCUMENT_TYPE)).in(documentTypes));
        return this;
    }

    public DocumentCriteria filterText(String filterText, String... fieldName) {
        Predicate[] orPredicates = Stream.of(fieldName)
                .map(f -> getCriteriaBuilder().like(getCriteriaBuilder().upper(getRoot().get(f)), "%" + filterText.toUpperCase() + "%"))
                .toArray(size -> new Predicate[fieldName.length]);
        predicates.add(getCriteriaBuilder().or(orPredicates));
        return this;
    }

    public DocumentCriteria addFilter(String key, String value) {
        if (key.equals(DocumentModel.DOCUMENT_ID)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_ID)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.DOCUMENT_TYPE)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.DOCUMENT_CURRENCY_CODE)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.CUSTOMER_ASSIGNED_ACCOUNT_ID)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.CUSTOMER_REGISTRATION_NAME)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.CUSTOMER_REGISTRATION_NAME)), value.toUpperCase()));
        } else {
            predicates.add(cb.equal(cb.upper(root.get(key)), value.toUpperCase()));
        }

        return this;
    }

    public DocumentCriteria addFilter(Map<String, String> filters) {
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            addFilter(entry.getKey(), entry.getValue());
        }

        return this;
    }

    public DocumentCriteria addFilter(String key, Object value, SearchCriteriaFilterOperator operator) {
        if (operator == SearchCriteriaFilterOperator.eq) {
            Path<Object> path = getRoot().get(key);
            Class<?> pathc = path.getJavaType();
            if (pathc.isAssignableFrom(String.class)) {
                predicates.add(getCriteriaBuilder().equal(path, value));
            } else if (pathc.isEnum()) {
                predicates.add(getCriteriaBuilder().equal(path, Enum.valueOf((Class) pathc, (String) value)));
            }
        } else if (operator == SearchCriteriaFilterOperator.bool_eq) {
            predicates.add(getCriteriaBuilder().equal(getRoot().<Boolean>get(key), Boolean.valueOf((Boolean) value)));
        } else if (operator == SearchCriteriaFilterOperator.gt) {
            predicates.add(getCriteriaBuilder().greaterThan(getRoot().<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.gte) {
            predicates.add(getCriteriaBuilder().greaterThanOrEqualTo(getRoot().<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.lt) {
            predicates.add(getCriteriaBuilder().lessThan(getRoot().<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.lte) {
            predicates.add(getCriteriaBuilder().lessThanOrEqualTo(getRoot().<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.neq) {
            predicates.add(getCriteriaBuilder().notEqual(getRoot().get(key), value));
        } else if (operator == SearchCriteriaFilterOperator.like) {
            predicates.add(getCriteriaBuilder().like(getCriteriaBuilder().upper(getRoot().<String>get(key)), ((String) value).toUpperCase().replace('*', '%')));
        }

        return this;
    }


    public DocumentCriteria requiredAction(RequiredAction... requiredAction) {
        List<String> rActions = Stream.of(requiredAction).map(RequiredAction::toString).collect(Collectors.toList());

        Join<UBLDocumentEntity, UBLDocumentRequiredActionEntity> requiredActions = getRoot().join(JpaDocumentProvider.REQUIRED_ACTIONS);
        predicates.add(requiredActions.get("action").in(rActions));

        return this;
    }

    public DocumentCriteria fromDate(LocalDateTime fromDate) {
        predicates.add(getCriteriaBuilder().greaterThanOrEqualTo(getRoot().<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), fromDate));
        return this;
    }

    public DocumentCriteria toDate(LocalDateTime toDate) {
        predicates.add(getCriteriaBuilder().lessThanOrEqualTo(getRoot().<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), toDate));
        return this;
    }

    public void orderBy(Map<String, Boolean> orderBy) {
        this.orderBy = orderBy;
    }

    public TypedQuery<Q> buildQuery(boolean countOnly) {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        if (orderBy.isEmpty() && !countOnly) {
            orderBy.put(JpaDocumentProvider.CREATED_TIMESTAMP, true);
        }

        List<Order> orderList = new ArrayList<>();
        for (Map.Entry<String, Boolean> order : orderBy.entrySet()) {
            if (order.getValue()) {
                orderList.add(cb.asc((root.get(order.getKey()))));
            } else {
                orderList.add(cb.desc((root.get(order.getKey()))));
            }
        }
        if (!orderList.isEmpty()) {
            cq.orderBy(orderList);
        }

        return em.createQuery(cq);
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return cb;
    }

    public CriteriaQuery<Q> getCriteriaQuery() {
        return cq;
    }

    public Root<R> getRoot() {
        return root;
    }

}