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

@Entity(name = "ConsignmentType")
@Table(name = "CONSIGNMENTTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConsignmentType {

    protected IDType ID;
    protected List<SummaryDescriptionType> summaryDescription;
    protected TotalInvoiceAmountType totalInvoiceAmount;
    protected DeclaredCustomsValueAmountType declaredCustomsValueAmount;
    protected List<TariffDescriptionType> tariffDescription;
    protected TariffCodeType tariffCode;
    protected InsurancePremiumAmountType insurancePremiumAmount;
    protected GrossWeightMeasureType grossWeightMeasure;
    protected NetWeightMeasureType netWeightMeasure;
    protected NetNetWeightMeasureType netNetWeightMeasure;
    protected ChargeableWeightMeasureType chargeableWeightMeasure;
    protected GrossVolumeMeasureType grossVolumeMeasure;
    protected NetVolumeMeasureType netVolumeMeasure;
    protected LoadingLengthMeasureType loadingLengthMeasure;
    protected List<RemarksType> remarks;
    protected HazardousRiskIndicatorType hazardousRiskIndicator;
    protected PartyType consigneeParty;
    protected PartyType exporterParty;
    protected PartyType consignorParty;
    protected PartyType importerParty;
    protected PartyType carrierParty;
    protected PartyType freightForwarderParty;
    protected PartyType notifyParty;
    protected PartyType originalDespatchParty;
    protected PartyType finalDeliveryParty;
    protected CountryEntity originalDepartureCountry;
    protected CountryEntity finalDestinationCountry;
    protected List<CountryEntity> transitCountry;
    protected ContractEntity transportContract;
    protected TransportationServiceType originalDespatchTransportationService;
    protected TransportationServiceType finalDeliveryTransportationService;
    protected DeliveryTermsEntity deliveryTerms;
    protected PaymentTermsType paymentTerms;
    protected List<AllowanceChargeEntity> freightAllowanceCharge;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_CONSIGNMENTTYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @OneToMany(targetEntity = SummaryDescriptionType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SUMMARYDESCRIPTION_CONSIGNME_0")
    public List<SummaryDescriptionType> getSummaryDescription() {
        if (summaryDescription == null) {
            summaryDescription = new ArrayList<SummaryDescriptionType>();
        }
        return this.summaryDescription;
    }

    public void setSummaryDescription(List<SummaryDescriptionType> summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    @ManyToOne(targetEntity = TotalInvoiceAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TOTALINVOICEAMOUNT_CONSIGNME_0")
    public TotalInvoiceAmountType getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalInvoiceAmount(TotalInvoiceAmountType value) {
        this.totalInvoiceAmount = value;
    }

    @ManyToOne(targetEntity = DeclaredCustomsValueAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DECLAREDCUSTOMSVALUEAMOUNT_C_0")
    public DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount() {
        return declaredCustomsValueAmount;
    }

    public void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value) {
        this.declaredCustomsValueAmount = value;
    }

    @OneToMany(targetEntity = TariffDescriptionType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TARIFFDESCRIPTION_CONSIGNMEN_0")
    public List<TariffDescriptionType> getTariffDescription() {
        if (tariffDescription == null) {
            tariffDescription = new ArrayList<TariffDescriptionType>();
        }
        return this.tariffDescription;
    }

    public void setTariffDescription(List<TariffDescriptionType> tariffDescription) {
        this.tariffDescription = tariffDescription;
    }

    @ManyToOne(targetEntity = TariffCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TARIFFCODE_CONSIGNMENTTYPE_H_0")
    public TariffCodeType getTariffCode() {
        return tariffCode;
    }

    public void setTariffCode(TariffCodeType value) {
        this.tariffCode = value;
    }

    @ManyToOne(targetEntity = InsurancePremiumAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INSURANCEPREMIUMAMOUNT_CONSI_0")
    public InsurancePremiumAmountType getInsurancePremiumAmount() {
        return insurancePremiumAmount;
    }

    public void setInsurancePremiumAmount(InsurancePremiumAmountType value) {
        this.insurancePremiumAmount = value;
    }

    @ManyToOne(targetEntity = GrossWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "GROSSWEIGHTMEASURE_CONSIGNME_0")
    public GrossWeightMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    public void setGrossWeightMeasure(GrossWeightMeasureType value) {
        this.grossWeightMeasure = value;
    }

    @ManyToOne(targetEntity = NetWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETWEIGHTMEASURE_CONSIGNMENT_0")
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    @ManyToOne(targetEntity = NetNetWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETNETWEIGHTMEASURE_CONSIGNM_0")
    public NetNetWeightMeasureType getNetNetWeightMeasure() {
        return netNetWeightMeasure;
    }

    public void setNetNetWeightMeasure(NetNetWeightMeasureType value) {
        this.netNetWeightMeasure = value;
    }

    @ManyToOne(targetEntity = ChargeableWeightMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CHARGEABLEWEIGHTMEASURE_CONS_0")
    public ChargeableWeightMeasureType getChargeableWeightMeasure() {
        return chargeableWeightMeasure;
    }

    public void setChargeableWeightMeasure(ChargeableWeightMeasureType value) {
        this.chargeableWeightMeasure = value;
    }

    @ManyToOne(targetEntity = GrossVolumeMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "GROSSVOLUMEMEASURE_CONSIGNME_0")
    public GrossVolumeMeasureType getGrossVolumeMeasure() {
        return grossVolumeMeasure;
    }

    public void setGrossVolumeMeasure(GrossVolumeMeasureType value) {
        this.grossVolumeMeasure = value;
    }

    @ManyToOne(targetEntity = NetVolumeMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETVOLUMEMEASURE_CONSIGNMENT_0")
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    @ManyToOne(targetEntity = LoadingLengthMeasureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LOADINGLENGTHMEASURE_CONSIGN_0")
    public LoadingLengthMeasureType getLoadingLengthMeasure() {
        return loadingLengthMeasure;
    }

    public void setLoadingLengthMeasure(LoadingLengthMeasureType value) {
        this.loadingLengthMeasure = value;
    }

    @OneToMany(targetEntity = RemarksType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REMARKS_CONSIGNMENTTYPE_OFID")
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
    }

    public void setRemarks(List<RemarksType> remarks) {
        this.remarks = remarks;
    }

    @ManyToOne(targetEntity = HazardousRiskIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HAZARDOUSRISKINDICATOR_CONSI_0")
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONSIGNEEPARTY_CONSIGNMENTTY_0")
    public PartyType getConsigneeParty() {
        return consigneeParty;
    }

    public void setConsigneeParty(PartyType value) {
        this.consigneeParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXPORTERPARTY_CONSIGNMENTTYP_0")
    public PartyType getExporterParty() {
        return exporterParty;
    }

    public void setExporterParty(PartyType value) {
        this.exporterParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONSIGNORPARTY_CONSIGNMENTTY_0")
    public PartyType getConsignorParty() {
        return consignorParty;
    }

    public void setConsignorParty(PartyType value) {
        this.consignorParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "IMPORTERPARTY_CONSIGNMENTTYP_0")
    public PartyType getImporterParty() {
        return importerParty;
    }

    public void setImporterParty(PartyType value) {
        this.importerParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CARRIERPARTY_CONSIGNMENTTYPE_0")
    public PartyType getCarrierParty() {
        return carrierParty;
    }

    public void setCarrierParty(PartyType value) {
        this.carrierParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FREIGHTFORWARDERPARTY_CONSIG_0")
    public PartyType getFreightForwarderParty() {
        return freightForwarderParty;
    }

    public void setFreightForwarderParty(PartyType value) {
        this.freightForwarderParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTIFYPARTY_CONSIGNMENTTYPE__0")
    public PartyType getNotifyParty() {
        return notifyParty;
    }

    public void setNotifyParty(PartyType value) {
        this.notifyParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALDESPATCHPARTY_CONSIG_0")
    public PartyType getOriginalDespatchParty() {
        return originalDespatchParty;
    }

    public void setOriginalDespatchParty(PartyType value) {
        this.originalDespatchParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FINALDELIVERYPARTY_CONSIGNME_0")
    public PartyType getFinalDeliveryParty() {
        return finalDeliveryParty;
    }

    public void setFinalDeliveryParty(PartyType value) {
        this.finalDeliveryParty = value;
    }

    @ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALDEPARTURECOUNTRY_CON_0")
    public CountryEntity getOriginalDepartureCountry() {
        return originalDepartureCountry;
    }

    public void setOriginalDepartureCountry(CountryEntity value) {
        this.originalDepartureCountry = value;
    }

    @ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FINALDESTINATIONCOUNTRY_CONS_0")
    public CountryEntity getFinalDestinationCountry() {
        return finalDestinationCountry;
    }

    public void setFinalDestinationCountry(CountryEntity value) {
        this.finalDestinationCountry = value;
    }

    @OneToMany(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSITCOUNTRY_CONSIGNMENTTY_0")
    public List<CountryEntity> getTransitCountry() {
        if (transitCountry == null) {
            transitCountry = new ArrayList<CountryEntity>();
        }
        return this.transitCountry;
    }

    public void setTransitCountry(List<CountryEntity> transitCountry) {
        this.transitCountry = transitCountry;
    }

    @ManyToOne(targetEntity = ContractEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSPORTCONTRACT_CONSIGNMEN_0")
    public ContractEntity getTransportContract() {
        return transportContract;
    }

    public void setTransportContract(ContractEntity value) {
        this.transportContract = value;
    }

    @ManyToOne(targetEntity = TransportationServiceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALDESPATCHTRANSPORTATI_1")
    public TransportationServiceType getOriginalDespatchTransportationService() {
        return originalDespatchTransportationService;
    }

    public void setOriginalDespatchTransportationService(TransportationServiceType value) {
        this.originalDespatchTransportationService = value;
    }

    @ManyToOne(targetEntity = TransportationServiceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FINALDELIVERYTRANSPORTATIONS_1")
    public TransportationServiceType getFinalDeliveryTransportationService() {
        return finalDeliveryTransportationService;
    }

    public void setFinalDeliveryTransportationService(TransportationServiceType value) {
        this.finalDeliveryTransportationService = value;
    }

    @ManyToOne(targetEntity = DeliveryTermsEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYTERMS_CONSIGNMENTTYP_0")
    public DeliveryTermsEntity getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsEntity value) {
        this.deliveryTerms = value;
    }

    @ManyToOne(targetEntity = PaymentTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTTERMS_CONSIGNMENTTYPE_0")
    public PaymentTermsType getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(PaymentTermsType value) {
        this.paymentTerms = value;
    }

    @OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FREIGHTALLOWANCECHARGE_CONSI_0")
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
