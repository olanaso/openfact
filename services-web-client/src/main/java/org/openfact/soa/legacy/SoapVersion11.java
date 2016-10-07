package org.openfact.soa.legacy;

import org.apache.xmlbeans.*;
import org.openfact.soa.common.SoapBuilderException;
import org.openfact.soa.common.utils.ResourceUtils;
import org.xmlsoap.schemas.soap.envelope.EnvelopeDocument;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;

/**
 * SoapVersion for SOAP 1.1
 *
 */
public class SoapVersion11 extends AbstractSoapVersion {
	private final static QName envelopeQName = new QName(Constants.SOAP11_ENVELOPE_NS, "Envelope");
	private final static QName bodyQName = new QName(Constants.SOAP11_ENVELOPE_NS, "Body");
	private final static QName faultQName = new QName(Constants.SOAP11_ENVELOPE_NS, "Fault");
	private final static QName headerQName = new QName(Constants.SOAP11_ENVELOPE_NS, "Header");

	SchemaTypeLoader soapSchema;
	SchemaType soapEnvelopeType;
	private XmlObject soapSchemaXml;
	private XmlObject soapEncodingXml;
	private SchemaType soapFaultType;

	public final static SoapVersion11 instance = new SoapVersion11();

	private SoapVersion11() {
		try {
			XmlOptions options = new XmlOptions();
			options.setCompileNoValidation();
			options.setCompileNoPvrRule();
			options.setCompileDownloadUrls();
			options.setCompileNoUpaRule();
			options.setValidateTreatLaxAsSkip();

			URL soapSchemaXmlResource = ResourceUtils.getResourceWithAbsolutePackagePath(getClass(), "/xsds/",
					"soapEnvelope.xsd");
			soapSchemaXml = XmlUtils.createXmlObject(soapSchemaXmlResource, options);
			soapSchema = XmlBeans.loadXsd(new XmlObject[] { soapSchemaXml });

			soapEnvelopeType = soapSchema.findDocumentType(envelopeQName);
			soapFaultType = soapSchema.findDocumentType(faultQName);

			URL soapEncodingXmlResource = ResourceUtils.getResourceWithAbsolutePackagePath(getClass(), "/xsds/",
					"soapEncoding.xsd");
			soapEncodingXml = XmlUtils.createXmlObject(soapEncodingXmlResource, options);

		} catch (XmlException ex) {
			throw new SoapBuilderException(ex);
		}
	}

	public SchemaType getEnvelopeType() {
		return EnvelopeDocument.type;
	}

	public String getEnvelopeNamespace() {
		return Constants.SOAP11_ENVELOPE_NS;
	}

	public String getEncodingNamespace() {
		return Constants.SOAP_ENCODING_NS;
	}

	public XmlObject getSoapEncodingSchema() throws XmlException, IOException {
		return soapEncodingXml;
	}

	public XmlObject getSoapEnvelopeSchema() throws XmlException, IOException {
		return soapSchemaXml;
	}

	public String toString() {
		return "SOAP 1.1";
	}

	public String getContentTypeHttpHeader(String encoding, String soapAction) {
		if (encoding == null || encoding.trim().length() == 0)
			return getContentType();
		else
			return getContentType() + ";charset=" + encoding;
	}

	public String getSoapActionHeader(String soapAction) {
		if (soapAction == null || soapAction.length() == 0) {
			soapAction = "\"\"";
		} else {
			soapAction = "\"" + soapAction + "\"";
		}

		return soapAction;
	}

	public String getContentType() {
		return "text/xml";
	}

	public QName getBodyQName() {
		return bodyQName;
	}

	public QName getEnvelopeQName() {
		return envelopeQName;
	}

	public QName getHeaderQName() {
		return headerQName;
	}

	protected SchemaTypeLoader getSoapEnvelopeSchemaLoader() {
		return soapSchema;
	}

	public SchemaType getFaultType() {
		return soapFaultType;
	}

	public String getName() {
		return "SOAP 1.1";
	}

	public String getFaultDetailNamespace() {
		return "";
	}
}
