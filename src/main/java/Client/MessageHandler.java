package Client;

import Mapper.getDataMapper;
import Mapper.sentDataMapper;
import service.RU.*;
import service.RU.Faults.InvalidMessageException;
import service.RU.Faults.MessageAlreadyExistException;
import service.RU.Faults.MessageNotFoundException;
import service.RU.Faults.UnknownException;
import service.RU.Formats.*;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
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
            getDataMapper.getInstance().saveSingleMessageOfList("gfhghgjhjhkhjkjkjlkjjjahj", "NEW");
            GetNewMessageListResponseType res = port.getNewMessageList(parameters);

            System.out.println("list:");
            for (int i = 0; i < res.getEnvelopeID().size(); i++) {
                String currentEnvelope = res.getEnvelopeID().get(i);
                System.out.println(currentEnvelope);
                /* ADDED */
                getDataMapper.getInstance().saveSingleMessageOfList(currentEnvelope, "NEW");
                /* ADDED */
            }

            return true;
        } catch (UnknownException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendMessage(File content, String fXmlPath, String type) {
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            SendMessageRequestType parameters = XmlDocumentUtility.getInstance().createData(content, type);
            SendMessageResponseType res = port.sendMessage(parameters);
            //after this we should call Res and Send Confirm
            /* ADDED */
            if(res.getResultCode().equals("80000")){
                String stringContent = Files.readString(Paths.get(fXmlPath), StandardCharsets.UTF_8);
                boolean saveResult = false;
                while(!saveResult){
                    saveResult = sentDataMapper.getInstance().saveMessage(parameters.getMessageMeta(), stringContent, type);
                }

                System.out.println("Successfully sent and saved ! ");
                return true;
            }
            /* ADDED */
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return false;

        } catch (IOException  | MessageAlreadyExistException | InvalidMessageException | UnknownException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
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
            /* ADDED */
            boolean saveResult = getDataMapper.getInstance().saveMessageBody(res.getMessageMeta(), resString);
            System.out.println(saveResult);
            /* ADDED */
            System.out.println("res:\n" + resString + "meta:\n" + metaString);
            return true;
        } catch (UnknownException | MessageNotFoundException ex) {
            //Logger.getLogger(MainGetMessageBody.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /* MATCHED WITH SENDMESSAGE */

    /*public boolean sendConfirm(File xmlContent){
        try {
            ForeignApi port = fas.getForeignApiEndpointPort();
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            SendMessageRequestType parameters = new SendMessageRequestType();
            MessageType.MessageContent content = new MessageType.MessageContent();

            Document document = XmlDocumentUtility.getInstance().convertStringToXMLDocument(xmlContent);
            content.setAny(document.getDocumentElement());
            parameters.setMessageContent(content);
            MessageType.MessageMeta meta = new MessageType.MessageMeta();
            meta.setEnvelopeId("4f741c2d-2c59-43c5-9454-2e798bb4eb55");
            meta.setInitialEnvelopeId("6b6be9d5-5ea3-4c0b-a68a-582000a9f412");
            meta.setMessageKind("CONFIRM");
            XmlDateUtility dateUtility = new XmlDateUtility();
            XMLGregorianCalendar time = dateUtility.createXMLGregorinCalendarNOW();
            meta.setPreparationDateTime(time);
            parameters.setMessageMeta(meta);
            SendMessageResponseType res = port.sendMessage(parameters);
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return true;
        } catch (InvalidMessageException | MessageAlreadyExistException | UnknownException ex) {
            //Logger.getLogger(MainSendConfirm.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    /* MATCHED WITH SENDMESSAGE */

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
            /* ADDED */
            boolean saveResult = getDataMapper.getInstance().saveSingleMessageOfList(envelopeID, "FIRST_CONFIRM");
            System.out.println(saveResult);
            /* ADDED */
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
            return true;
        } catch (UnknownException | MessageNotFoundException ex) {
            //Logger.getLogger(MainConfirm.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }








    /*public static void setMessageHandler(MessageHandler messageHandler) {
        MessageHandler.messageHandler = messageHandler;
    }*/
}
