/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;
import org.w3c.dom.Document;
import service.RU.*;

/**
 *
 * @author @AmirShk
 */
public class MainGetMessageBody {

    public static void main(String[] args) {
        /*try {
            ForeignApiService fas = new ForeignApiService();
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            GetMessageRequestType parameters = new GetMessageRequestType();
            parameters.setEnvelopeID("c8ea1a73-dbbb-418c-94a0-9e6c4bcfa46e");
            GetMessageResponseType res = port.getMessage(parameters);
            String resString = toString(res.getMessageContent().getAny().getOwnerDocument());
            String metaString = res.getMessageMeta().toString();
            System.out.println("res:\n" + resString + "meta:\n" + metaString);
        } catch (UnknownException | MessageNotFoundException ex) {
            Logger.getLogger(MainGetMessageBody.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    



}
