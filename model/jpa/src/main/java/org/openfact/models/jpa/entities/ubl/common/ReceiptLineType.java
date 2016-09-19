//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ReceiptLineType")
@Table(name = "RECEIPTLINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ReceiptLineType {

    protected IDType ID;
    protected UUIDType uuid;
    protected NoteType note;
    protected ReceivedQuantityType receivedQuantity;
    protected ShortQuantityType shortQuantity;
    protected ShortageActionCodeType shortageActionCode;
    protected RejectedQuantityType rejectedQuantity;
    protected RejectReasonCodeType rejectReasonCode;
    protected RejectReasonType rejectReason;
    protected RejectActionCodeType rejectActionCode;
    protected OversupplyQuantityType oversupplyQuantity;
    protected ReceivedDateType receivedDate;
    protected TimingComplaintCodeType timingComplaintCode;
    protected TimingComplaintType timingComplaint;
    protected OrderLineReferenceEntity orderLineReference;
    protected List<LineReferenceEntity> despatchLineReference;
    protected List<DocumentReferenceEntity> documentReference;
    protected List<ItemType> item;
    protected List<ShipmentType> shipment;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_RECEIPTLINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_RECEIPTLINETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_RECEIPTLINETYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = ReceivedQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIVEDQUANTITY_RECEIPTLINE_0")
    public ReceivedQuantityType getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(ReceivedQuantityType value) {
        this.receivedQuantity = value;
    }

    @ManyToOne(targetEntity = ShortQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHORTQUANTITY_RECEIPTLINETYP_0")
    public ShortQuantityType getShortQuantity() {
        return shortQuantity;
    }

    public void setShortQuantity(ShortQuantityType value) {
        this.shortQuantity = value;
    }

    @ManyToOne(targetEntity = ShortageActionCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHORTAGEACTIONCODE_RECEIPTLI_0")
    public ShortageActionCodeType getShortageActionCode() {
        return shortageActionCode;
    }

    public void setShortageActionCode(ShortageActionCodeType value) {
        this.shortageActionCode = value;
    }

    @ManyToOne(targetEntity = RejectedQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REJECTEDQUANTITY_RECEIPTLINE_0")
    public RejectedQuantityType getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(RejectedQuantityType value) {
        this.rejectedQuantity = value;
    }

    @ManyToOne(targetEntity = RejectReasonCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REJECTREASONCODE_RECEIPTLINE_0")
    public RejectReasonCodeType getRejectReasonCode() {
        return rejectReasonCode;
    }

    public void setRejectReasonCode(RejectReasonCodeType value) {
        this.rejectReasonCode = value;
    }

    @ManyToOne(targetEntity = RejectReasonType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REJECTREASON_RECEIPTLINETYPE_0")
    public RejectReasonType getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(RejectReasonType value) {
        this.rejectReason = value;
    }

    @ManyToOne(targetEntity = RejectActionCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REJECTACTIONCODE_RECEIPTLINE_0")
    public RejectActionCodeType getRejectActionCode() {
        return rejectActionCode;
    }

    public void setRejectActionCode(RejectActionCodeType value) {
        this.rejectActionCode = value;
    }

    @ManyToOne(targetEntity = OversupplyQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "OVERSUPPLYQUANTITY_RECEIPTLI_0")
    public OversupplyQuantityType getOversupplyQuantity() {
        return oversupplyQuantity;
    }

    public void setOversupplyQuantity(OversupplyQuantityType value) {
        this.oversupplyQuantity = value;
    }

    @ManyToOne(targetEntity = ReceivedDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIVEDDATE_RECEIPTLINETYPE_0")
    public ReceivedDateType getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(ReceivedDateType value) {
        this.receivedDate = value;
    }

    @ManyToOne(targetEntity = TimingComplaintCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TIMINGCOMPLAINTCODE_RECEIPTL_0")
    public TimingComplaintCodeType getTimingComplaintCode() {
        return timingComplaintCode;
    }

    public void setTimingComplaintCode(TimingComplaintCodeType value) {
        this.timingComplaintCode = value;
    }

    @ManyToOne(targetEntity = TimingComplaintType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TIMINGCOMPLAINT_RECEIPTLINET_0")
    public TimingComplaintType getTimingComplaint() {
        return timingComplaint;
    }

    public void setTimingComplaint(TimingComplaintType value) {
        this.timingComplaint = value;
    }

    @ManyToOne(targetEntity = OrderLineReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERLINEREFERENCE_RECEIPTLI_0")
    public OrderLineReferenceEntity getOrderLineReference() {
        return orderLineReference;
    }

    public void setOrderLineReference(OrderLineReferenceEntity value) {
        this.orderLineReference = value;
    }

    @OneToMany(targetEntity = LineReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHLINEREFERENCE_RECEIP_0")
    public List<LineReferenceEntity> getDespatchLineReference() {
        if (despatchLineReference == null) {
            despatchLineReference = new ArrayList<LineReferenceEntity>();
        }
        return this.despatchLineReference;
    }

    public void setDespatchLineReference(List<LineReferenceEntity> despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTREFERENCE_RECEIPTLIN_0")
    public List<DocumentReferenceEntity> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
        this.documentReference = documentReference;
    }

    @OneToMany(targetEntity = ItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_RECEIPTLINETYPE_OFID")
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    public void setItem(List<ItemType> item) {
        this.item = item;
    }

    @OneToMany(targetEntity = ShipmentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHIPMENT_RECEIPTLINETYPE_OFID")
    public List<ShipmentType> getShipment() {
        if (shipment == null) {
            shipment = new ArrayList<ShipmentType>();
        }
        return this.shipment;
    }

    public void setShipment(List<ShipmentType> shipment) {
        this.shipment = shipment;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
