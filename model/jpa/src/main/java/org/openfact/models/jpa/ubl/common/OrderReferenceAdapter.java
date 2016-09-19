package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.OrderReferenceType;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.OrderReferenceModel;

public class OrderReferenceAdapter implements OrderReferenceModel, JpaModel<OrderReferenceType> {

    protected static final Logger logger = Logger.getLogger(OrderReferenceAdapter.class);
    protected OrderReferenceEntity orderReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrderReferenceAdapter(OpenfactSession session, EntityManager em,
            OrderReferenceEntity orderReference) {
        this.session = session;
        this.em = em;
        this.orderReference = orderReference;
    }

    @Override
    public String getID() {
        return this.orderReference.getID();
    }

    @Override
    public void setID(String value) {
        this.orderReference.setID(value);
    }

    @Override
    public String getSalesOrderID() {
        return this.orderReference.getSalesOrderID();
    }

    @Override
    public void setSalesOrderID(String value) {
        this.orderReference.setSalesOrderID(value);
    }

    @Override
    public boolean getCopyIndicator() {
        return this.orderReference.getCopyIndicator();
    }

    @Override
    public void setCopyIndicator(boolean value) {
        this.orderReference.setCopyIndicator(value);
    }

    @Override
    public String getUUID() {
        return this.orderReference.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.orderReference.setUUID(value);
    }

    @Override
    public LocalDate getIssueDate() {
        return this.orderReference.getIssueDate();
    }

    @Override
    public void setIssueDate(LocalDate value) {
        this.orderReference.setIssueDate(value);
    }

    @Override
    public LocalTime getIssueTime() {
        return this.orderReference.getIssueTime();
    }

    @Override
    public void setIssueTime(LocalTime value) {
        this.orderReference.setIssueTime(value);
    }

    @Override
    public String getCustomerReference() {
        return this.orderReference.getCustomerReference();
    }

    @Override
    public void setCustomerReference(String value) {
        this.orderReference.setCustomerReference(value);
    }

    @Override
    public DocumentReferenceModel getDocumentReference() {
        return this.orderReference.getDocumentReference();
    }

    @Override
    public void setDocumentReference(DocumentReferenceAdapter value) {
        this.orderReference.setDocumentReference(value);
    }

    @Override
    public String getId() {
        return this.orderReference.getId();
    }

    @Override
    public void setId(String value) {
        this.orderReference.setId(value);
    }

}
