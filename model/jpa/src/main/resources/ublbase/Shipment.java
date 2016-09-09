

/**
 * A class defining an identifiable collection of one or more goods items to be
 * transported between the seller party and the buyer party. This information may
 * be defined within a commercial contract. A shipment can be transported in
 * different consignments (e
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:44 a. m.
 */
public class Shipment {

	/**
	 * The total number of consignments within this shipment.
	 */
	private Quantity. Type ConsignmentQuantity;
	/**
	 * The total declared value for customs purposes of those goods in this shipment
	 * that are subject to the same customs procedure and have the same
	 * tariff/statistical heading, country information, and duty regime.
	 */
	private Amount. Type DeclaredCustomsValueAmount;
	/**
	 * The value of this shipment, declared by the shipper or his agent solely for the
	 * purpose of varying the carrier's level of liability from that provided in the
	 * contract of carriage, in case of loss or damage to goods or delayed delivery.
	 */
	private Amount. Type DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this shipment
	 * that have the same statistical heading.
	 */
	private Amount. Type DeclaredStatisticsValueAmount;
	/**
	 * Delivery instructions relating to this shipment.
	 */
	private Text. Type DeliveryInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private Amount. Type FreeOnBoardValueAmount;
	/**
	 * The total volume of the goods in this shipment, including packaging.
	 */
	private Measure. Type GrossVolumeMeasure;
	/**
	 * The total gross weight of a shipment; the weight of the goods plus packaging
	 * plus transport equipment.
	 */
	private Measure. Type GrossWeightMeasure;
	/**
	 * The handling required for this shipment, expressed as a code.
	 */
	private Code. Type HandlingCode;
	/**
	 * The handling required for this shipment, expressed as text.
	 */
	private Text. Type HandlingInstructions;
	/**
	 * An identifier for this shipment.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text pertinent to this shipment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Information;
	/**
	 * The amount covered by insurance for this shipment.
	 */
	private Amount. Type InsuranceValueAmount;
	/**
	 * The total net weight of this shipment, excluding packaging and transport
	 * equipment.
	 */
	private Measure. Type NetNetWeightMeasure;
	/**
	 * The total volume of the goods in this shipment, excluding packaging and
	 * transport equipment.
	 */
	private Measure. Type NetVolumeMeasure;
	/**
	 * The net weight of this shipment, excluding packaging.
	 */
	private Measure. Type NetWeightMeasure;
	/**
	 * A code signifying the priority or level of service required for this shipment.
	 */
	private Code. Type ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this shipment.
	 */
	private Text. Type SpecialInstructions;
	/**
	 * An indicator that the consignment has been split in transit (true) or not
	 * (false).
	 */
	private Indicator. Type SplitConsignmentIndicator;
	/**
	 * The total number of goods items in this shipment.
	 */
	private Quantity. Type TotalGoodsItemQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this shipment.
	 */
	private Quantity. Type TotalTransportHandlingUnitQuantity;
	private Address Return Address;
	private Address Origin Address;
	private Allowance Charge Freight Allowance Charge;
	private Consignment m_Consignment;
	private Country Export Country;
	private Delivery m_Delivery;
	private Goods Item m_Goods Item;
	private Location Last Exit Port Location;
	private Location First Arrival Port Location;
	private Shipment Stage m_Shipment Stage;
	private Transport Handling Unit m_Transport Handling Unit;

	public Shipment(){

	}

	public void finalize() throws Throwable {

	}
	public Consignment getConsignment(){
		return m_Consignment;
	}

	public Quantity. Type getConsignmentQuantity(){
		return ConsignmentQuantity;
	}

	public Amount. Type getDeclaredCustomsValueAmount(){
		return DeclaredCustomsValueAmount;
	}

	public Amount. Type getDeclaredForCarriageValueAmount(){
		return DeclaredForCarriageValueAmount;
	}

	public Amount. Type getDeclaredStatisticsValueAmount(){
		return DeclaredStatisticsValueAmount;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Text. Type getDeliveryInstructions(){
		return DeliveryInstructions;
	}

	public Country getExport Country(){
		return Export Country;
	}

	public Location getFirst Arrival Port Location(){
		return First Arrival Port Location;
	}

	public Amount. Type getFreeOnBoardValueAmount(){
		return FreeOnBoardValueAmount;
	}

	public Allowance Charge getFreight Allowance Charge(){
		return Freight Allowance Charge;
	}

	public Goods Item getGoods Item(){
		return m_Goods Item;
	}

	public Measure. Type getGrossVolumeMeasure(){
		return GrossVolumeMeasure;
	}

	public Measure. Type getGrossWeightMeasure(){
		return GrossWeightMeasure;
	}

	public Code. Type getHandlingCode(){
		return HandlingCode;
	}

	public Text. Type getHandlingInstructions(){
		return HandlingInstructions;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getInformation(){
		return Information;
	}

	public Amount. Type getInsuranceValueAmount(){
		return InsuranceValueAmount;
	}

	public Location getLast Exit Port Location(){
		return Last Exit Port Location;
	}

	public Measure. Type getNetNetWeightMeasure(){
		return NetNetWeightMeasure;
	}

	public Measure. Type getNetVolumeMeasure(){
		return NetVolumeMeasure;
	}

	public Measure. Type getNetWeightMeasure(){
		return NetWeightMeasure;
	}

	public Address getOrigin Address(){
		return Origin Address;
	}

	public Address getReturn Address(){
		return Return Address;
	}

	public Shipment Stage getShipment Stage(){
		return m_Shipment Stage;
	}

	public Code. Type getShippingPriorityLevelCode(){
		return ShippingPriorityLevelCode;
	}

	public Text. Type getSpecialInstructions(){
		return SpecialInstructions;
	}

	public Indicator. Type getSplitConsignmentIndicator(){
		return SplitConsignmentIndicator;
	}

	public Quantity. Type getTotalGoodsItemQuantity(){
		return TotalGoodsItemQuantity;
	}

	public Quantity. Type getTotalTransportHandlingUnitQuantity(){
		return TotalTransportHandlingUnitQuantity;
	}

	public Transport Handling Unit getTransport Handling Unit(){
		return m_Transport Handling Unit;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignment(Consignment newVal){
		m_Consignment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignmentQuantity(Quantity. Type newVal){
		ConsignmentQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredCustomsValueAmount(Amount. Type newVal){
		DeclaredCustomsValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredForCarriageValueAmount(Amount. Type newVal){
		DeclaredForCarriageValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredStatisticsValueAmount(Amount. Type newVal){
		DeclaredStatisticsValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery(Delivery newVal){
		m_Delivery = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveryInstructions(Text. Type newVal){
		DeliveryInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExport Country(Country newVal){
		Export Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirst Arrival Port Location(Location newVal){
		First Arrival Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreeOnBoardValueAmount(Amount. Type newVal){
		FreeOnBoardValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Allowance Charge(Allowance Charge newVal){
		Freight Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGoods Item(Goods Item newVal){
		m_Goods Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossVolumeMeasure(Measure. Type newVal){
		GrossVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossWeightMeasure(Measure. Type newVal){
		GrossWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingCode(Code. Type newVal){
		HandlingCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingInstructions(Text. Type newVal){
		HandlingInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformation(Text. Type newVal){
		Information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInsuranceValueAmount(Amount. Type newVal){
		InsuranceValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLast Exit Port Location(Location newVal){
		Last Exit Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetNetWeightMeasure(Measure. Type newVal){
		NetNetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetVolumeMeasure(Measure. Type newVal){
		NetVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetWeightMeasure(Measure. Type newVal){
		NetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrigin Address(Address newVal){
		Origin Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReturn Address(Address newVal){
		Return Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment Stage(Shipment Stage newVal){
		m_Shipment Stage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShippingPriorityLevelCode(Code. Type newVal){
		ShippingPriorityLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialInstructions(Text. Type newVal){
		SpecialInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSplitConsignmentIndicator(Indicator. Type newVal){
		SplitConsignmentIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalGoodsItemQuantity(Quantity. Type newVal){
		TotalGoodsItemQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalTransportHandlingUnitQuantity(Quantity. Type newVal){
		TotalTransportHandlingUnitQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Handling Unit(Transport Handling Unit newVal){
		m_Transport Handling Unit = newVal;
	}
}//end Shipment