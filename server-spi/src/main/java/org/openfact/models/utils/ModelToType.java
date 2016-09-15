package org.openfact.models.utils;

import java.time.LocalDate;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.*;
import org.openfact.models.ubl.common.*;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

public class ModelToType {

	public static InvoiceType toType(InvoiceModel model) throws DatatypeConfigurationException {
		InvoiceType type = new InvoiceType();
		type.setIssueDate(toType(model.getIssueDate()));
		if (model.getUBLExtensions() != null) {
			type.setUBLExtensions(toType(model.getUBLExtensions()));
		}
		if (model.getAccountingSupplierParty() != null) {
			type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
		}
		type.setInvoiceTypeCode(model.getInvoiceModelCode());
		type.setID(model.getID());
		if (model.getAccountingCustomerParty() != null) {
			type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
		}
		if (model.getInvoiceLine() != null) {
			for (InvoiceLineModel item : model.getInvoiceLine()) {
				type.addInvoiceLine(toType(item));
			}
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				type.addTaxTotal(toType(item));
			}
		}
		return type;
	}

	private static InvoiceLineType toType(InvoiceLineModel model) {
		InvoiceLineType type = new InvoiceLineType();
		if (model.getInvoicedQuantity() != null) {
			type.setInvoicedQuantity(toType(model.getInvoicedQuantity()));
		}
		if (model.getItem() != null) {
			type.setItem(toType(model.getItem()));
		}
		if (model.getPrice() != null) {
			type.setPrice(toType(model.getPrice()));
		}
		if (model.getPricingReference() != null) {
			type.setPricingReference(toType(model.getPricingReference()));
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				type.addTaxTotal(toType(item));
			}
		}
		if (model.getLineExtensionAmount() != null) {
			type.setLineExtensionAmount(model.getLineExtensionAmount());
		}
		type.setID(model.getID());
		if (model.getAllowanceCharge() != null) {
			for (AllowanceChargeModel item : model.getAllowanceCharge()) {
				type.addAllowanceCharge(toType(item));
			}
		}
		return type;
	}

	private static AllowanceChargeType toType(AllowanceChargeModel model) {
		AllowanceChargeType type = new AllowanceChargeType();
		type.setAmount(model.getAmount());
		type.setChargeIndicator(model.getChargeIndicator());
		return type;
	}

	private static PricingReferenceType toType(PricingReferenceModel model) {
		PricingReferenceType type = new PricingReferenceType();
		if (model.getAlternativeConditionPrice() != null) {
			for (PriceModel item : model.getAlternativeConditionPrice()) {
				type.addAlternativeConditionPrice(toType(item));
			}
		}
		return type;
	}

	private static PriceType toType(PriceModel model) {
		PriceType type = new PriceType();
		// if (model.getPriceAmount() != null) {
		// type.setPriceAmount(toType(model.getPriceAmount()));
		// }
		type.setPriceAmount(model.getPriceAmount());

		return type;
	}

	// private static PriceAmountType toType(PriceAmountModel model) {
	// PriceAmountType type = new PriceAmountType();
	// type.setCurrencyID(model.getCurrencyID());
	// type.setValue(model.getValue());
	// return type;
	// }

	private static ItemType toType(ItemModel model) {
		ItemType type = new ItemType();
		for (String item : model.getDescription()) {
			type.addDescription(new DescriptionType(item));
		}
		if (model.getSellersItemIdentification() != null) {
			type.setSellersItemIdentification(toType(model.getSellersItemIdentification()));
		}
		return type;
	}

	private static ItemIdentificationType toType(ItemIdentificationModel model) {
		ItemIdentificationType type = new ItemIdentificationType();
		type.setID(model.getID());
		return type;
	}

	private static InvoicedQuantityType toType(InvoicedQuantityModel model) {
		InvoicedQuantityType type = new InvoicedQuantityType();
		if (model.getUnitCode() != null)
			type.setUnitCode(model.getUnitCode());
		if (model.getValue() != null)
			type.setValue(model.getValue());
		return type;
	}

	private static TaxTotalType toType(TaxTotalModel model) {
		TaxTotalType type = new TaxTotalType();
		if (model.getTaxAmount() != null) {
			type.setTaxAmount(model.getTaxAmount());
		}
		if (model.getTaxSubtotal() != null) {
			for (TaxSubtotalModel item : model.getTaxSubtotal()) {
				type.addTaxSubtotal(toType(item));
			}
		}
		return type;
	}

	private static TaxSubtotalType toType(TaxSubtotalModel model) {
		TaxSubtotalType type = new TaxSubtotalType();
		if (model.getTaxAmount() != null) {
			type.setTaxAmount(model.getTaxAmount());
		}
		if (model.getTaxCategory() != null) {
			type.setTaxCategory(toType(model.getTaxCategory()));
		}
		return type;
	}

	private static TaxCategoryType toType(TaxCategoryModel model) {
		TaxCategoryType type = new TaxCategoryType();
		if (model.getTaxExemptionReasonCode() != null) {
			type.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
		}
		if (model.getTaxScheme() != null) {
			type.setTaxScheme(toType(model.getTaxScheme()));
		}
		if (model.getTierRange() != null) {
			type.setTierRange(model.getTierRange());
		}
		return type;
	}

	private static TaxSchemeType toType(TaxSchemeModel model) {
		TaxSchemeType type = new TaxSchemeType();
		type.setID(model.getID());
		type.setName(model.getName());
		type.setTaxTypeCode(model.getTaxModelCode());
		return type;
	}

	private static CustomerPartyType toType(CustomerPartyModel model) {
		CustomerPartyType type = new CustomerPartyType();
		if (model.getCustomerAssignedAccountID() != null) {
			type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
		}
		for (String item : model.getAdditionalAccountID()) {
			type.addAdditionalAccountID(new AdditionalAccountIDType(item));
		}
		if (model.getParty() != null) {
			type.setParty(toType(model.getParty()));
		}
		return type;
	}

	private static UBLExtensionsType toType(UBLExtensionsModel model) {
		UBLExtensionsType type = new UBLExtensionsType();
		for (UBLExtensionModel item : model.getUBLExtension()) {
			type.addUBLExtension(toType(item));
		}
		return null;
	}

	private static UBLExtensionType toType(UBLExtensionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	private static SupplierPartyType toType(SupplierPartyModel model) {
		SupplierPartyType type = new SupplierPartyType();
		if (model.getParty() != null) {
			type.setParty(toType(model.getParty()));
		}
		type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
		for (String item : model.getAdditionalAccountID()) {
			type.addAdditionalAccountID(new AdditionalAccountIDType(item));
		}
		return type;
	}

	private static PartyType toType(PartyModel model) {
		PartyType type = new PartyType();
		for (PartyLegalEntityModel item : model.getPartyLegalEntity()) {
			type.addPartyLegalEntity(toType(item));
		}
		for (PartyNameModel item : model.getPartyName()) {
			type.addPartyName(toType(item));
		}
		if (model.getPostalAddress() != null) {
			type.setPostalAddress(toType(model.getPostalAddress()));
		}
		return type;
	}

	private static AddressType toType(AddressModel model) {
		AddressType type = new AddressType();
		if (model.getID() != null) {
			type.setID(model.getID());
		}
		if (model.getStreetName() != null) {
			type.setStreetName(model.getStreetName());
		}
		if (model.getCitySubdivisionName() != null) {
			type.setCitySubdivisionName(model.getCitySubdivisionName());
		}
		if (model.getCityName() != null) {
			type.setCityName(model.getCityName());
		}
		if (model.getCountrySubentity() != null) {
			type.setCountrySubentity(model.getCountrySubentity());
		}
		if (model.getDistrict() != null) {
			type.setDistrict(model.getDistrict());
		}
		if (model.getDepartment() != null) {
			type.setDepartment(model.getDepartment());
		}
		if (model.getCountry() != null) {
			type.setCountry(toType(model.getCountry()));
		}
		return type;
	}

	private static CountryType toType(CountryModel model) {
		CountryType type = new CountryType();
		if (model.getIdentificationCode() != null) {
			type.setIdentificationCode(model.getIdentificationCode());
		}
		return type;
	}

	private static PartyNameType toType(PartyNameModel model) {
		PartyNameType type = new PartyNameType();
		if (model.getName() != null) {
			type.setName(model.getName());
		}
		return type;
	}

	private static PartyLegalEntityType toType(PartyLegalEntityModel model) {
		PartyLegalEntityType type = new PartyLegalEntityType();
		if (model.getRegistrationName() != null) {
			type.setRegistrationName(model.getRegistrationName());
		}
		return type;
	}

	private static XMLGregorianCalendar toType(LocalDate date) throws DatatypeConfigurationException {
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
	}
}
