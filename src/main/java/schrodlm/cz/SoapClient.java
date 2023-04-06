package schrodlm.cz;

import javax.xml.soap.*;

/**
 * Sends an HTTP request containing SOAP Web Service body and prints out the
 * response to the stdout
 */
public class SoapClient {

    public void run() {
        try {
            // Create a SOAP message factory
            MessageFactory messageFactory = MessageFactory.newInstance();

            // Create a SOAP message
            SOAPMessage soapMessage = messageFactory.createMessage();

            // Create a SOAP part
            SOAPPart soapPart = soapMessage.getSOAPPart();

            // Set the SOAP envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("", "http://adis.mfcr.cz/rozhraniCRPDPH/");

            // Create the SOAP body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapElement = soapBody.addChildElement("StatusNespolehlivyPlatceRequest", "");

            String[] dic_values = { "00028894", "06865151" };

            for (String dic_value : dic_values) {
                SOAPElement dicElement = soapElement.addChildElement("dic");
                dicElement.addTextNode(dic_value);

            }
            // Create the SOAP connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send the SOAP message and get the response
            String endpointUrl = "https://adisrws.mfcr.cz/dpr/axis2/services/rozhraniCRPDPH.rozhraniCRPDPHSOAP";
            SOAPMessage soapResponse = soapConnection.call(soapMessage, endpointUrl);

            // Print the SOAP response
            System.out.println("Response:");
            soapResponse.writeTo(System.out);

            // Close the SOAP connection
            soapConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
