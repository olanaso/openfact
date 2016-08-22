package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.DocumentSavedModel;
import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationSavedModel;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.DocumentSavedEntity;
import org.openfact.models.jpa.entities.InvoiceAdditionalInformationEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.InvoiceLineEntity;
import org.openfact.models.jpa.entities.InvoiceTaxTotalEntity;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected InvoiceEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            InvoiceEntity invoice) {
        this.session = session;
        this.em = em;
        this.organization = organization;
        this.invoice = invoice;
    }

    @Override
    public InvoiceEntity getEntity() {
        return invoice;
    }

    public static InvoiceEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof InvoiceAdapter) {
            return ((InvoiceAdapter) model).getEntity();
        }
        return em.getReference(InvoiceEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return invoice.getId();
    }

    @Override
    public DocumentSavedModel getType() {
      return new DocumentSavedAdapter(session, em, invoice.getType());
    }

    @Override
    public void setType(String documentName, String documentId) {
        DocumentSavedEntity document =  invoice.getType();
        document.setName(documentName);
        document.setDocumentId(documentId);
    }

    @Override
    public LocalDate getIssueDate() {
       return invoice.getIssueDate();
    }

    @Override
    public void setIssueDate(LocalDate issueDate) {
        invoice.setIssueDate(issueDate);
    }

    @Override
    public String getCurrencyCode() {
        return invoice.getCurrencyCode();
    }

    @Override
    public void setCurrencyCode(String currencyCode) {
        invoice.setCurrencyCode(currencyCode);
    }

    @Override
    public InvoiceIdModel getInvoiceId() {
        return new InvoiceIdAdapter(session, this, em, invoice.getInvoiceId());
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
       return invoice.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        invoice.setAllowanceTotalAmount(allowanceTotalAmount);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return invoice.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        invoice.setChargeTotalAmount(chargeTotalAmount);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return invoice.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal payableAmount) {
        invoice.setPayableAmount(payableAmount);
    }

    @Override
    public CustomerModel getCustomer() {
       return new CustomerAdapter(session, this, em, invoice.getCustomer());
    }

    @Override
    public CustomerModel setCustomer(String registrationName) {
        CustomerEntity entity = new CustomerEntity();
        entity.setRegistrationName(registrationName);
        entity.setInvoice(invoice);
        em.persist(entity);
        em.flush();
        return new CustomerAdapter(session, this, em, entity);
    }

    @Override
    public Set<InvoiceAdditionalInformationModel> getAdditionalInformation() {
        return invoice.getAdditionalInformation().stream()
                .map(f -> new InvoiceAdditionalInformationAdapter(session, this, em, f))
                .collect(Collectors.toSet());       
    }

    @Override
    public InvoiceAdditionalInformationModel addAdditionalInformation(String name, String documentId, BigDecimal ammount) {
        DocumentSavedEntity document = new DocumentSavedEntity();
        document.setName(name);
        document.setDocumentId(documentId);
        
        InvoiceAdditionalInformationEntity taxTotalEntity = new InvoiceAdditionalInformationEntity();
        taxTotalEntity.setAmmount(ammount);
        taxTotalEntity.setInvoice(invoice);
        taxTotalEntity.setDocument(document);
        
        em.persist(taxTotalEntity);
        em.flush();
        
        return new InvoiceAdditionalInformationAdapter(session, this, em, taxTotalEntity);
    }

    @Override
    public Set<InvoiceTaxTotalModel> getInvoiceTaxTotal() {
        return invoice.getTaxTotals().stream()
                .map(f -> new InvoiceTaxTotalAdapter(session, this, em, f))
                .collect(Collectors.toSet());
    }

    @Override
    public InvoiceTaxTotalModel addTaxTotal(String name, String documentId, BigDecimal ammount) {
        DocumentSavedEntity document = new DocumentSavedEntity();
        document.setName(name);
        document.setDocumentId(documentId);
        
        InvoiceTaxTotalEntity taxTotalEntity = new InvoiceTaxTotalEntity();
        taxTotalEntity.setAmmount(ammount);
        taxTotalEntity.setInvoice(invoice);
        taxTotalEntity.setDocument(document);
        
        em.persist(taxTotalEntity);
        em.flush();
        
        return new InvoiceTaxTotalAdapter(session, this, em, taxTotalEntity);
    }

    @Override
    public OrganizationSavedModel getOrganizationSaved() {
        return new OrganizationSavedAdapter(session, this, em, invoice.getOrganizationSaved());
    }

    @Override
    public List<InvoiceLineModel> getInvoiceLines() {
        List<InvoiceLineModel> invoiceLines = new ArrayList<>();
        List<InvoiceLineEntity> entities = invoice.getInvoiceLines();
        entities.forEach(f -> invoiceLines.add(new InvoiceLineAdapter(session, this, em, f)));
        return invoiceLines;
    }

    @Override
    public InvoiceLineModel addInvoiceLine() {
        InvoiceLineEntity entity = new InvoiceLineEntity();
        entity.setInvoice(invoice);
        em.persist(entity);
        em.flush();
        final InvoiceLineModel adapter = new InvoiceLineAdapter(session, this, em, entity);
        return adapter;
    }

    @Override
    public boolean removeInvoiceLine(InvoiceLineModel invoiceLine) {
        if (invoiceLine == null) {
            return false;
        }

        InvoiceLineEntity invoiceLineEntity = null;
        Iterator<InvoiceLineEntity> it = invoice.getInvoiceLines().iterator();
        while (it.hasNext()) {
            InvoiceLineEntity ae = it.next();
            if (ae.equals(invoiceLine)) {
                invoiceLineEntity = ae;
                it.remove();
                break;
            }
        }
        if (invoiceLineEntity == null) {
            return false;
        }

        em.remove(invoiceLineEntity);
        em.flush();
        return true;
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceAdapter other = (InvoiceAdapter) obj;
        if (invoice == null) {
            if (other.invoice != null)
                return false;
        } else if (!invoice.equals(other.invoice))
            return false;
        return true;
    }

}
