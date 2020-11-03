/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.StringReader;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import service.RU.*;

/**
 *
 * @author @AmirShk
 */
public class MainNewMessageLis {

    public static void main(String[] args) {
        /*try {
            ForeignApiService fas = new ForeignApiService();
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            GetNewMessageListRequestType parameters = new GetNewMessageListRequestType();
            GetNewMessageListResponseType res = port.getNewMessageList(parameters);
            System.out.println("list:");
            for(int i=0 ; i < res.getEnvelopeID().size() ; i++){
                System.out.println(res.getEnvelopeID().get(i));
            }
        } catch (UnknownException ex) {
            Logger.getLogger(MainNewMessageLis.class.getName()).log(Level.SEVERE, null, ex);
        } */
    }

    /*private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
