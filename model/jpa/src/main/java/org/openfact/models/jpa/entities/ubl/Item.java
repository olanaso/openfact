package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class Item {

    /**
     * Further details regarding this item (e.g., the URL of a relevant web
     * page).
     */
    private String AdditionalInformation;
    /**
     * A brand name of this item.
     */
    private String BrandName;
    /**
     * An indicator that this item was ordered from a catalogue (true) or not
     * (false).
     */
    private boolean CatalogueIndicator;
    /**
     * Text describing this item.
     */
    private String Description;
    /**
     * An indication that the transported item, as delivered, is subject to an
     * international regulation concerning the carriage of dangerous goods
     * (true) or not (false).
     */
    private boolean HazardousRiskIndicator;
    /**
     * A keyword (search string) for this item, assigned by the seller party.
     * Can also be a synonym for the name of the item.
     */
    private String Keyword;
    /**
     * A model name of this item.
     */
    private String ModelName;
    /**
     * A short name optionally given to this item, such as a name from a
     * catalogue, as distinct from a description.
     */
    private String Name;
    /**
     * The unit packaging quantity; the number of subunits making up this item.
     */
    private Quantity.Type PackQuantity;
    /**
     * The number of items in a pack of this item.
     */
    private BigDecimal PackSizeNumeric;
    private Address Origin Address;
    private Certificate m_Certificate;
    private Commodity Classification
    m_Commodity Classification;
    private Country Origin Country;
    private Dimension m_Dimension;
    private DocumentReference
    Item Specification
    DocumentReference;
    private DocumentReference
    Catalogue DocumentReference;
    private Hazardous Item
    m_Hazardous Item;
    private Item Identification
    Additional Item Identification;
    private Item Identification
    Buyers Item Identification;
    private Item Property
    Additional Item Property;
    private Party Manufacturer Party;
    private Party Information
    Content Provider Party;
    private Transaction Conditions
    m_Transaction Conditions;
    private Tax Category
    Classified Tax Category;
    private Item Identification
    Sellers Item Identification;
    private Item Identification
    Standard Item Identification;
    private Item Identification
    Catalogue Item Identification;
    private Item Identification
    Manufacturers Item Identification;
    private Item Instance
    m_Item Instance;

    public Item() {

    }

    public void finalize() throws Throwable {

    }

    public Item Identification
    getAdditional Item

    Identification(){
		return Additional Item Identification;
	}

    public Item Property
    getAdditional Item

    Property(){
		return Additional Item Property;
	}

    public String getAdditionalInformation() {
        return AdditionalInformation;
    }

    public String getBrandName() {
        return BrandName;
    }

    public Item Identification
    getBuyers Item

    Identification(){
		return Buyers Item Identification;
	}

    public DocumentReference
    getCatalogue Document

    Reference(){
		return Catalogue DocumentReference;
	}

    public Item Identification
    getCatalogue Item

    Identification(){
		return Catalogue Item Identification;
	}

    public boolean getCatalogueIndicator() {
        return CatalogueIndicator;
    }

    public Certificate getCertificate() {
        return m_Certificate;
    }

    public Tax Category
    getClassified Tax

    Category(){
		return Classified Tax Category;
	}

    public Commodity Classification

    getCommodity Classification(){
		return m_Commodity Classification;
	}

    public String getDescription() {
        return Description;
    }

    public Dimension getDimension() {
        return m_Dimension;
    }

    public Hazardous Item

    getHazardous Item(){
		return m_Hazardous Item;
	}

    public boolean getHazardousRiskIndicator() {
        return HazardousRiskIndicator;
    }

    public Party getInformation
    Content Provider

    Party(){
		return Information Content Provider Party;
	}

    public Item Instance

    getItem Instance(){
		return m_Item Instance;
	}

    public DocumentReference
    getItem Specification

    DocumentReference(){
		return Item Specification DocumentReference;
	}

    public String getKeyword() {
        return Keyword;
    }

    public Party getManufacturer

    Party(){
		return Manufacturer Party;
	}

    public Item Identification
    getManufacturers Item

    Identification(){
		return Manufacturers Item Identification;
	}

    public String getModelName() {
        return ModelName;
    }

    public String getName() {
        return Name;
    }

    public Address getOrigin

    Address(){
		return Origin Address;
	}

    public Country getOrigin

    Country(){
		return Origin Country;
	}

    public Quantity.Type getPackQuantity() {
        return PackQuantity;
    }

    public BigDecimal getPackSizeNumeric() {
        return PackSizeNumeric;
    }

    public Item Identification
    getSellers Item

    Identification(){
		return Sellers Item Identification;
	}

    public Item Identification
    getStandard Item

    Identification(){
		return Standard Item Identification;
	}

    public Transaction Conditions

    getTransaction Conditions() {
        return m_Transaction Conditions;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    Item Identification(Item Identification newVal){
		Additional Item Identification = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    Item Property(Item Property newVal){
		Additional Item Property = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setAdditionalInformation(String newVal) {
        AdditionalInformation = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBrandName(String newVal) {
        BrandName = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setBuyers

    Item Identification(Item Identification newVal){
		Buyers Item Identification = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setCatalogue

    DocumentReference(DocumentReference newVal){
		Catalogue DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setCatalogue

    Item Identification(Item Identification newVal){
		Catalogue Item Identification = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCatalogueIndicator(boolean newVal) {
        CatalogueIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCertificate(Certificate newVal) {
        m_Certificate = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setClassified

    Tax Category(Tax Category newVal){
		Classified Tax Category = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setCommodity

    Classification(Commodity Classification newVal){
		m_Commodity Classification = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDimension(Dimension newVal) {
        m_Dimension = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setHazardous

    Item(Hazardous Item newVal){
		m_Hazardous Item = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setHazardousRiskIndicator(boolean newVal) {
        HazardousRiskIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInformation
    Content Provider

    Party(Party newVal){
		Information Content Provider Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setItem

    Instance(Item Instance newVal){
		m_Item Instance = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setItem
    Specification Document

    Reference(DocumentReference newVal){
		Item Specification DocumentReference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setKeyword(String newVal) {
        Keyword = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setManufacturer

    Party(Party newVal){
		Manufacturer Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setManufacturers

    Item Identification(Item Identification newVal){
		Manufacturers Item Identification = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setModelName(String newVal) {
        ModelName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(String newVal) {
        Name = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setOrigin

    Address(Address newVal){
		Origin Address = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setOrigin

    Country(Country newVal){
		Origin Country = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPackQuantity(Quantity.Type newVal) {
        PackQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPackSizeNumeric(BigDecimal newVal) {
        PackSizeNumeric = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setSellers

    Item Identification(Item Identification newVal){
		Sellers Item Identification = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setStandard

    Item Identification(Item Identification newVal){
		Standard Item Identification = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTransaction

    Conditions(Transaction Conditions newVal){
		m_Transaction Conditions = newVal;
	}
}// end Item