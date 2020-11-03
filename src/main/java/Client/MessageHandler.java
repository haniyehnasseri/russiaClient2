package Client;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import service.RU.*;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageHandler {
    private static MessageHandler instance;
    private ForeignApiService fas;


    /*public ForeignApiService getFas() {
        return fas;
    }

    public void setFas(ForeignApiService fas) {
        this.fas = fas;
    }*/

    public MessageHandler(){
        fas = new ForeignApiService();
    }

    public static MessageHandler getInstance() {
        if(instance == null){
            instance = new MessageHandler();
        }
        return instance;
    }



    public boolean getNewMessageList() {
        try {
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
            return true;
        } catch (UnknownException ex) {
            Logger.getLogger(MainNewMessageLis.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean sendMessage(String content) {
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            //System.out.println(port);
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            SendMessageRequestType parameters = XmlDocumentUtility.getInstance().CreatInformation(content);
            SendMessageResponseType res = port.sendMessage(parameters);
            //after this we should call Res and Send Confirm
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return true;
        } catch (InvalidMessageException | MessageAlreadyExistException | UnknownException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean getMessageBody(String envelopeID){
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            GetMessageRequestType parameters = new GetMessageRequestType();
            /* this line has been changed */
            parameters.setEnvelopeID(envelopeID);
            GetMessageResponseType res = port.getMessage(parameters);
            String resString = XmlDocumentUtility.getInstance().documentToXml(res.getMessageContent().getAny().getOwnerDocument());
            String metaString = res.getMessageMeta().toString();
            System.out.println("res:\n" + resString + "meta:\n" + metaString);
            return true;
        } catch (UnknownException | MessageNotFoundException ex) {
            Logger.getLogger(MainGetMessageBody.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean sendConfirm(String contentxml){
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            SendMessageRequestType parameters = new SendMessageRequestType();
            MessageType.MessageContent content = new MessageType.MessageContent();

            Document document = XmlDocumentUtility.getInstance().convertStringToXMLDocument(contentxml);
            content.setAny(document.getDocumentElement());
            parameters.setMessageContent(content);
            MessageType.MessageMeta meta = new MessageType.MessageMeta();
            meta.setEnvelopeId("4f741c2d-2c59-43c5-9454-2e798bb4eb55");
            meta.setInitialEnvelopeId("6b6be9d5-5ea3-4c0b-a68a-582000a9f412");
            meta.setMessageKind("CONFIR");
            XmlDateUtility dateUtility = new XmlDateUtility();
            XMLGregorianCalendar time = dateUtility.createXMLGregorinCalendarNOW();
            meta.setPreparationDateTime(time);
            parameters.setMessageMeta(meta);
            SendMessageResponseType res = port.sendMessage(parameters);
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return true;
        } catch (InvalidMessageException | MessageAlreadyExistException | UnknownException ex) {
            Logger.getLogger(MainSendConfirm.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean confirmMessage(String envelopeID){
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            ConfirmationMessageRequestType parameters = new ConfirmationMessageRequestType();
            /* this line has been changed */
            parameters.setEnvelopeID(envelopeID);
            /* this line has been changed */
            ConfirmationMessageResponseType res = port.confirmMessage(parameters);
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return true;
        } catch (UnknownException | MessageNotFoundException ex) {
            Logger.getLogger(MainConfirm.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }








    /*public static void setMessageHandler(MessageHandler messageHandler) {
        MessageHandler.messageHandler = messageHandler;
    }*/
}
