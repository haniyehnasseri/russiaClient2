package Client;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import service.RU.MessageType;
import service.RU.SendMessageRequestType;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.UUID;

public class XmlDocumentUtility {
    private static XmlDocumentUtility instance;

    public static XmlDocumentUtility getInstance() {
        if(instance == null){
            instance = new XmlDocumentUtility();
        }
        return instance;
    }

    public SendMessageRequestType CreatInformation(String informationBody) {
        SendMessageRequestType parameters = new SendMessageRequestType();
        MessageType.MessageContent content = new MessageType.MessageContent();
        Document document = convertStringToXMLDocument(informationBody);
        if(document != null){
            content.setAny(document.getDocumentElement());
            parameters.setMessageContent(content);
            MessageType.MessageMeta meta = new MessageType.MessageMeta();
            /* this line is changed */
            meta.setConsignmentId(document.getElementsByTagName("IR_Inf:ConsignmentIdentifier").item(0).getTextContent());
            /* this line is changed */
            meta.setEnvelopeId(UUID.randomUUID().toString());
            meta.setInitialEnvelopeId("4f741c2d-2c59-43c5-9454-2e798bb4eb54");
            meta.setMessageKind("INFORM");
            XmlDateUtility dateUtility = new XmlDateUtility();
            XMLGregorianCalendar time = dateUtility.createXMLGregorinCalendarNOW();
            meta.setPreparationDateTime(time);
            parameters.setMessageMeta(meta);
        }
        return parameters;

    }

    public Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            return builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String documentToXml(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }


}
