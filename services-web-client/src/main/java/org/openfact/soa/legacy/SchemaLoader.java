package org.openfact.soa.legacy;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public interface SchemaLoader {
	XmlObject loadXmlObject(String wsdlUrl, XmlOptions options) throws Exception;

	String getBaseURI();
}
