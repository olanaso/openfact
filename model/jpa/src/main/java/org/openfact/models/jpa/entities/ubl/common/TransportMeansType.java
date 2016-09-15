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

@Entity(name = "TransportMeansType")
@Table(name = "TRANSPORTMEANSTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class TransportMeansType {

    protected JourneyIDType journeyID;
    protected RegistrationNationalityIDType registrationNationalityID;
    protected List<RegistrationNationalityType> registrationNationality;
    protected DirectionCodeType directionCode;
    protected StowageType stowage;
    protected AirTransportType airTransport;
    protected RoadTransportType roadTransport;
    protected RailTransportType railTransport;
    protected MaritimeTransportType maritimeTransport;
    protected PartyType ownerParty;
    protected String id;

    @ManyToOne(targetEntity = JourneyIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "JOURNEYID_TRANSPORTMEANSTYPE_0")
    public JourneyIDType getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(JourneyIDType value) {
        this.journeyID = value;
    }

    @ManyToOne(targetEntity = RegistrationNationalityIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REGISTRATIONNATIONALITYID_TR_0")
    public RegistrationNationalityIDType getRegistrationNationalityID() {
        return registrationNationalityID;
    }

    public void setRegistrationNationalityID(RegistrationNationalityIDType value) {
        this.registrationNationalityID = value;
    }

    @OneToMany(targetEntity = RegistrationNationalityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REGISTRATIONNATIONALITY_TRAN_0")
    public List<RegistrationNationalityType> getRegistrationNationality() {
        if (registrationNationality == null) {
            registrationNationality = new ArrayList<RegistrationNationalityType>();
        }
        return this.registrationNationality;
    }

    public void setRegistrationNationality(List<RegistrationNationalityType> registrationNationality) {
        this.registrationNationality = registrationNationality;
    }

    @ManyToOne(targetEntity = DirectionCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DIRECTIONCODE_TRANSPORTMEANS_0")
    public DirectionCodeType getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(DirectionCodeType value) {
        this.directionCode = value;
    }

    @ManyToOne(targetEntity = StowageType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "STOWAGE_TRANSPORTMEANSTYPE_H_0")
    public StowageType getStowage() {
        return stowage;
    }

    public void setStowage(StowageType value) {
        this.stowage = value;
    }

    @ManyToOne(targetEntity = AirTransportType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "AIRTRANSPORT_TRANSPORTMEANST_0")
    public AirTransportType getAirTransport() {
        return airTransport;
    }

    public void setAirTransport(AirTransportType value) {
        this.airTransport = value;
    }

    @ManyToOne(targetEntity = RoadTransportType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ROADTRANSPORT_TRANSPORTMEANS_0")
    public RoadTransportType getRoadTransport() {
        return roadTransport;
    }

    public void setRoadTransport(RoadTransportType value) {
        this.roadTransport = value;
    }

    @ManyToOne(targetEntity = RailTransportType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RAILTRANSPORT_TRANSPORTMEANS_0")
    public RailTransportType getRailTransport() {
        return railTransport;
    }

    public void setRailTransport(RailTransportType value) {
        this.railTransport = value;
    }

    @ManyToOne(targetEntity = MaritimeTransportType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MARITIMETRANSPORT_TRANSPORTM_0")
    public MaritimeTransportType getMaritimeTransport() {
        return maritimeTransport;
    }

    public void setMaritimeTransport(MaritimeTransportType value) {
        this.maritimeTransport = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "OWNERPARTY_TRANSPORTMEANSTYP_0")
    public PartyType getOwnerParty() {
        return ownerParty;
    }

    public void setOwnerParty(PartyType value) {
        this.ownerParty = value;
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
