package org.openfact.models.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "INVOICE_LINE_TAX_TOTAL")
public class InvoiceLineTaxTotalEntity {

    @Id
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "DOCUMENT_NAME")),
            @AttributeOverride(name = "documentId", column = @Column(name = "DOCUMENT_ID")) })
    private DocumentSnapshotEntity document;

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "REASON_NAME")),
            @AttributeOverride(name = "documentId", column = @Column(name = "REASON_ID")) })
    private DocumentSnapshotEntity reason;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_LINE_ID")
    private InvoiceLineEntityDEPRECATED invoiceLine;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DocumentSnapshotEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentSnapshotEntity document) {
        this.document = document;
    }

    public DocumentSnapshotEntity getReason() {
        return reason;
    }

    public void setReason(DocumentSnapshotEntity reason) {
        this.reason = reason;
    }

    public InvoiceLineEntityDEPRECATED getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLineEntityDEPRECATED invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        InvoiceLineTaxTotalEntity other = (InvoiceLineTaxTotalEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
