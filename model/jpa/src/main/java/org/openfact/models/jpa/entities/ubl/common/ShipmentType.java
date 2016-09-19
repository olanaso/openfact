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

@Entity(name = "ShipmentType")
@Table(name = "SHIPMENTTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ShipmentType {

    protected IDType ID;
    protected ShippingPriorityLevelCodeType shippingPriorityLevelCode;
    protected HandlingCodeType handlingCode;
    protected HandlingInstructionsType handlingInstructions;
    protected InformationType information;
    protected GrossWeightMeasureType grossWeightMeasure;
    protected NetWeightMeasureType netWeightMeasure;
    protected NetNetWeightMeasureType netNetWeightMeasure;
    protected GrossVolumeMeasureType grossVolumeMeasure;
    protected NetVolumeMeasureType netVolumeMeasure;
    protected TotalGoodsItemQuantityType totalGoodsItemQuantity;
    protected TotalTransportHandlingUnitQuantityType totalTransportHandlingUnitQuantity;
    protected InsuranceValueAmountType insuranceValueAmount;
    protected DeclaredCustomsValueAmountType declaredCustomsValueAmount;
    protected DeclaredForCarriageValueAmountType declaredForCarriageValueAmount;
    protected DeclaredStatisticsValueAmountType declaredStatisticsValueAmount;
    protected FreeOnBoardValueAmountType freeOnBoardValueAmount;
    protected List<SpecialInstructionsType> specialInstructions;
    protected List<DeliveryInstructionsType> deliveryInstructions;
    protected SplitConsignmentIndicatorType splitConsignmentIndicator;
    protected ConsignmentType consignment;
    protected List<GoodsItemType> goodsItem;
    protected List<ShipmentStageType> shipmentStage;
    protected DeliveryEntity delivery;
    protected List<TransportHandlingUnitType> transportHandlingUnit;
    protected AddressEntity originAddress;
    protected LocationTypeCommAgg firstArrivalPortLocation;
    protected LocationTypeCommAgg lastExitPortLocation;
    protected CountryEntity exportCountry;
    protected List<AllowanceChargeEntity> freightAllowanceCharge;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_SHIPMENTTYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = ShippingPriorityLevelCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHIPPINGPRIORITYLEVELCODE_SH_0")
    public ShippingPriorityLevelCodeType getShippingPriorityLevelCode() {
        return shippingPriorityLevelCode;
    }

    public void setShippingPriorityLevelCode(ShippingPriorityLevelCodeType value) {
        this.shippingPriorityLevelCode = value;
    }

    @ManyToOne(targetEntity = HandlingCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HANDLINGCODE_SHIPMENTTYPE_HJ_0")
    public HandlingCodeType getHandlingCode() {
        return handlingCode;
    }

    public void setHandlingCode(HandlingCodeType value) {
        this.handlingCode = value;
    }

    @ManyToOne(targetEntity = HandlingInstructionsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HANDLINGINSTRUCTIONS_SHIPMEN_0")
    public HandlingInstructionsType getHandlingInstructions() {
        return handlingInstructions;
    }

    public void setHandlingInstructions(HandlingInstructionsType value) {
        this.handlingInstructions = value;
    }

    @ManyToOne(targetEntity = InformationType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INFORMATION_SHIPMENTTYPE_OFID")
    public InformationType getInformation() {
        return information;
    }

    public void setInformation(InformationType value) {
        this.information = value;
    }

    @ManyToOne(targetEntity = GrossWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "GROSSWEIGHTMEASURE_SHIPMENTT_0")
    public GrossWeightMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    public void setGrossWeightMeasure(GrossWeightMeasureType value) {
        this.grossWeightMeasure = value;
    }

    @ManyToOne(targetEntity = NetWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETWEIGHTMEASURE_SHIPMENTTYP_0")
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    @ManyToOne(targetEntity = NetNetWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETNETWEIGHTMEASURE_SHIPMENT_0")
    public NetNetWeightMeasureType getNetNetWeightMeasure() {
        return netNetWeightMeasure;
    }

    public void setNetNetWeightMeasure(NetNetWeightMeasureType value) {
        this.netNetWeightMeasure = value;
    }

    @ManyToOne(targetEntity = GrossVolumeMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "GROSSVOLUMEMEASURE_SHIPMENTT_0")
    public GrossVolumeMeasureType getGrossVolumeMeasure() {
        return grossVolumeMeasure;
    }

    public void setGrossVolumeMeasure(GrossVolumeMeasureType value) {
        this.grossVolumeMeasure = value;
    }

    @ManyToOne(targetEntity = NetVolumeMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETVOLUMEMEASURE_SHIPMENTTYP_0")
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    @ManyToOne(targetEntity = TotalGoodsItemQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TOTALGOODSITEMQUANTITY_SHIPM_0")
    public TotalGoodsItemQuantityType getTotalGoodsItemQuantity() {
        return totalGoodsItemQuantity;
    }

    public void setTotalGoodsItemQuantity(TotalGoodsItemQuantityType value) {
        this.totalGoodsItemQuantity = value;
    }

    @ManyToOne(targetEntity = TotalTransportHandlingUnitQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TOTALTRANSPORTHANDLINGUNITQU_1")
    public TotalTransportHandlingUnitQuantityType getTotalTransportHandlingUnitQuantity() {
        return totalTransportHandlingUnitQuantity;
    }

    public void setTotalTransportHandlingUnitQuantity(TotalTransportHandlingUnitQuantityType value) {
        this.totalTransportHandlingUnitQuantity = value;
    }

    @ManyToOne(targetEntity = InsuranceValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INSURANCEVALUEAMOUNT_SHIPMEN_0")
    public InsuranceValueAmountType getInsuranceValueAmount() {
        return insuranceValueAmount;
    }

    public void setInsuranceValueAmount(InsuranceValueAmountType value) {
        this.insuranceValueAmount = value;
    }

    @ManyToOne(targetEntity = DeclaredCustomsValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DECLAREDCUSTOMSVALUEAMOUNT_S_0")
    public DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount() {
        return declaredCustomsValueAmount;
    }

    public void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value) {
        this.declaredCustomsValueAmount = value;
    }

    @ManyToOne(targetEntity = DeclaredForCarriageValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DECLAREDFORCARRIAGEVALUEAMOU_3")
    public DeclaredForCarriageValueAmountType getDeclaredForCarriageValueAmount() {
        return declaredForCarriageValueAmount;
    }

    public void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountType value) {
        this.declaredForCarriageValueAmount = value;
    }

    @ManyToOne(targetEntity = DeclaredStatisticsValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DECLAREDSTATISTICSVALUEAMOUN_2")
    public DeclaredStatisticsValueAmountType getDeclaredStatisticsValueAmount() {
        return declaredStatisticsValueAmount;
    }

    public void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountType value) {
        this.declaredStatisticsValueAmount = value;
    }

    @ManyToOne(targetEntity = FreeOnBoardValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FREEONBOARDVALUEAMOUNT_SHIPM_0")
    public FreeOnBoardValueAmountType getFreeOnBoardValueAmount() {
        return freeOnBoardValueAmount;
    }

    public void setFreeOnBoardValueAmount(FreeOnBoardValueAmountType value) {
        this.freeOnBoardValueAmount = value;
    }

    @OneToMany(targetEntity = SpecialInstructionsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SPECIALINSTRUCTIONS_SHIPMENT_0")
    public List<SpecialInstructionsType> getSpecialInstructions() {
        if (specialInstructions == null) {
            specialInstructions = new ArrayList<SpecialInstructionsType>();
        }
        return this.specialInstructions;
    }

    public void setSpecialInstructions(List<SpecialInstructionsType> specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @OneToMany(targetEntity = DeliveryInstructionsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYINSTRUCTIONS_SHIPMEN_0")
    public List<DeliveryInstructionsType> getDeliveryInstructions() {
        if (deliveryInstructions == null) {
            deliveryInstructions = new ArrayList<DeliveryInstructionsType>();
        }
        return this.deliveryInstructions;
    }

    public void setDeliveryInstructions(List<DeliveryInstructionsType> deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    @ManyToOne(targetEntity = SplitConsignmentIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SPLITCONSIGNMENTINDICATOR_SH_0")
    public SplitConsignmentIndicatorType getSplitConsignmentIndicator() {
        return splitConsignmentIndicator;
    }

    public void setSplitConsignmentIndicator(SplitConsignmentIndicatorType value) {
        this.splitConsignmentIndicator = value;
    }

    @ManyToOne(targetEntity = ConsignmentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONSIGNMENT_SHIPMENTTYPE_OFID")
    public ConsignmentType getConsignment() {
        return consignment;
    }

    public void setConsignment(ConsignmentType value) {
        this.consignment = value;
    }

    @OneToMany(targetEntity = GoodsItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "GOODSITEM_SHIPMENTTYPE_OFID")
    public List<GoodsItemType> getGoodsItem() {
        if (goodsItem == null) {
            goodsItem = new ArrayList<GoodsItemType>();
        }
        return this.goodsItem;
    }

    public void setGoodsItem(List<GoodsItemType> goodsItem) {
        this.goodsItem = goodsItem;
    }

    @OneToMany(targetEntity = ShipmentStageType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHIPMENTSTAGE_SHIPMENTTYPE_H_0")
    public List<ShipmentStageType> getShipmentStage() {
        if (shipmentStage == null) {
            shipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.shipmentStage;
    }

    public void setShipmentStage(List<ShipmentStageType> shipmentStage) {
        this.shipmentStage = shipmentStage;
    }

    @ManyToOne(targetEntity = DeliveryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERY_SHIPMENTTYPE_OFID")
    public DeliveryEntity getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryEntity value) {
        this.delivery = value;
    }

    @OneToMany(targetEntity = TransportHandlingUnitType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSPORTHANDLINGUNIT_SHIPME_0")
    public List<TransportHandlingUnitType> getTransportHandlingUnit() {
        if (transportHandlingUnit == null) {
            transportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.transportHandlingUnit;
    }

    public void setTransportHandlingUnit(List<TransportHandlingUnitType> transportHandlingUnit) {
        this.transportHandlingUnit = transportHandlingUnit;
    }

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINADDRESS_SHIPMENTTYPE_H_0")
    public AddressEntity getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(AddressEntity value) {
        this.originAddress = value;
    }

    @ManyToOne(targetEntity = LocationTypeCommAgg.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FIRSTARRIVALPORTLOCATION_SHI_0")
    public LocationTypeCommAgg getFirstArrivalPortLocation() {
        return firstArrivalPortLocation;
    }

    public void setFirstArrivalPortLocation(LocationTypeCommAgg value) {
        this.firstArrivalPortLocation = value;
    }

    @ManyToOne(targetEntity = LocationTypeCommAgg.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LASTEXITPORTLOCATION_SHIPMEN_0")
    public LocationTypeCommAgg getLastExitPortLocation() {
        return lastExitPortLocation;
    }

    public void setLastExitPortLocation(LocationTypeCommAgg value) {
        this.lastExitPortLocation = value;
    }

    @ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXPORTCOUNTRY_SHIPMENTTYPE_H_0")
    public CountryEntity getExportCountry() {
        return exportCountry;
    }

    public void setExportCountry(CountryEntity value) {
        this.exportCountry = value;
    }

    @OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FREIGHTALLOWANCECHARGE_SHIPM_0")
    public List<AllowanceChargeEntity> getFreightAllowanceCharge() {
        if (freightAllowanceCharge == null) {
            freightAllowanceCharge = new ArrayList<AllowanceChargeEntity>();
        }
        return this.freightAllowanceCharge;
    }

    public void setFreightAllowanceCharge(List<AllowanceChargeEntity> freightAllowanceCharge) {
        this.freightAllowanceCharge = freightAllowanceCharge;
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
