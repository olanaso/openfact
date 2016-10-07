package org.openfact.soa.test;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openfact.soa.builder.SoapBuilder;
import org.openfact.soa.builder.SoapOperation;
import org.openfact.soa.builder.core.Wsdl;
import org.openfact.soa.client.core.SoapClient;
import org.openfact.soa.common.SoapContext;
import org.openfact.soa.common.utils.ResourceUtils;
import org.xml.sax.SAXException;

import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SoapClientExamplesTest {

	// private static SoapServer server;
	private static final int port = 9797;
	private static final String contextPath = "/stockquote";

	private static final URL wsdlUrl = ResourceUtils.getResourceWithAbsolutePackagePath("/",
			"wsdl/stockquote-service.wsdl");
	private static final QName bindingName = new QName("http://reficio.org/stockquote.wsdl", "StockQuoteSoapBinding");
	private static SoapBuilder builder;

	// @BeforeClass
	// public static void startServer() throws WSDLException {
	// server = SoapServer.builder()
	// .httpPort(port)
	// .build();
	// server.start();
	//
	// AutoResponder responder = getAutoResponderForTestService();
	// server.registerRequestResponder(contextPath, responder);
	// }
	//
	// @AfterClass
	// public static void stopServer() {
	// server.stop();
	// }

	// public static AutoResponder getAutoResponderForTestService() throws
	// WSDLException {
	// SoapContext context =
	// SoapContext.builder().exampleContent(false).build();
	// Wsdl parser = Wsdl.parse(wsdlUrl);
	// builder = parser.binding().name(bindingName).find();
	//
	// AutoResponder responder = new AutoResponder(builder, context);
	// return responder;
	// }

	/**
	 * Here we're gonna generate the SOAP message using SoapBuilder and post it
	 * using SoapClient
	 */
	@Test
	public void invoke_tradePriceRequest_generatedMessages() throws Exception, SAXException, WSDLException {
		// construct the client
		String url = String.format("http://localhost:%d%s", port, contextPath);
		SoapClient client = SoapClient.builder().endpointUri(url).build();

		Wsdl parser = Wsdl.parse(wsdlUrl);
		SoapBuilder soapBuilder = parser.binding().name(bindingName).find();

		// get the operation to invoked -> assumption our operation is the first
		// operation in the WSDL's
		SoapOperation operation = soapBuilder.operation().name("GetLastTradePrice").find();

		// construct the request
		String request = soapBuilder.buildInputMessage(operation);
		// post the request to the server
		String response = client.post(request);
		// get the response
		String expectedResponse = soapBuilder.buildOutputMessage(operation, SoapContext.NO_CONTENT);

		assertTrue(XMLUnit.compareXML(expectedResponse, response).identical());
	}

	/**
	 * Here we're gonna simply post SOAP hardcoded message using SoapClient
	 */
	@Test
	public void invoke_tradePriceRequest_hardcodedMessages() throws IOException, SAXException {
		String url = String.format("http://localhost:%d%s", port, contextPath);
		SoapClient client = SoapClient.builder().endpointUri(url).build();

		String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:stoc=\"http://reficio.org/stockquote.wsdl\" xmlns:stoc1=\"http://reficio.org/stockquote.xsd\">\n"
				+ "   <soapenv:Header/>\n" + "   <soapenv:Body>\n" + "      <stoc:GetLastTradePrice>\n"
				+ "         <stoc1:TradePriceRequest>\n" + "            <tickerSymbol>?</tickerSymbol>\n"
				+ "         </stoc1:TradePriceRequest>\n" + "      </stoc:GetLastTradePrice>\n" + "   </soapenv:Body>\n"
				+ "</soapenv:Envelope>";

		String response = client.post(request);

		String expectedResponse = ""
				+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:stoc=\"http://reficio.org/stockquote.wsdl\" xmlns:stoc1=\"http://reficio.org/stockquote.xsd\">\n"
				+ "   <soapenv:Header/>\n" + "   <soapenv:Body>\n" + "      <stoc:GetLastTradePriceResponse>\n"
				+ "         <stoc1:TradePrice>\n" + "            <price>?</price>\n" + "         </stoc1:TradePrice>\n"
				+ "      </stoc:GetLastTradePriceResponse>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

		assertTrue(XMLUnit.compareXML(expectedResponse, response).identical());
	}

}