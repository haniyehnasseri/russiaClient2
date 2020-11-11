
package service.RU.Formats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * &lt;p&gt;Java class for MessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="MessageMeta"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="MessageKind" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;element name="PreparationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *                   &amp;lt;element name="EnvelopeId" type="{http://www.w3.org/2001/XMLSchema}token"/&amp;gt;
 *                   &amp;lt;element name="InitialEnvelopeId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&amp;gt;
 *                   &amp;lt;element name="ConsignmentId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="MessageContent"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;any processContents='skip'/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageType", propOrder = {
    "messageMeta",
    "messageContent"
})
@XmlSeeAlso({
    SendMessageRequestType.class,
    GetMessageResponseType.class
})
public class MessageType {

    @XmlElement(name = "MessageMeta", required = true)
    protected MessageType.MessageMeta messageMeta;
    @XmlElement(name = "MessageContent", required = true)
    protected MessageType.MessageContent messageContent;

    /**
     * Gets the value of the messageMeta property.
     * 
     * @return
     *     possible object is
     *     {@link MessageType.MessageMeta }
     *     
     */
    public MessageType.MessageMeta getMessageMeta() {
        return messageMeta;
    }

    /**
     * Sets the value of the messageMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType.MessageMeta }
     *     
     */
    public void setMessageMeta(MessageType.MessageMeta value) {
        this.messageMeta = value;
    }

    /**
     * Gets the value of the messageContent property.
     * 
     * @return
     *     possible object is
     *     {@link MessageType.MessageContent }
     *     
     */
    public MessageType.MessageContent getMessageContent() {
        return messageContent;
    }

    /**
     * Sets the value of the messageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType.MessageContent }
     *     
     */
    public void setMessageContent(MessageType.MessageContent value) {
        this.messageContent = value;
    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;any processContents='skip'/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class MessageContent {

        @XmlAnyElement
        protected Element any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     
         */
        public Element getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     
         */
        public void setAny(Element value) {
            this.any = value;
        }

    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="MessageKind" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;element name="PreparationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
     *         &amp;lt;element name="EnvelopeId" type="{http://www.w3.org/2001/XMLSchema}token"/&amp;gt;
     *         &amp;lt;element name="InitialEnvelopeId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&amp;gt;
     *         &amp;lt;element name="ConsignmentId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "messageKind",
        "preparationDateTime",
        "envelopeId",
        "initialEnvelopeId",
        "consignmentId"
    })
    public static class MessageMeta {

        @XmlElement(name = "MessageKind", required = true)
        protected String messageKind;
        @XmlElement(name = "PreparationDateTime", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar preparationDateTime;
        @XmlElement(name = "EnvelopeId", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String envelopeId;
        @XmlElement(name = "InitialEnvelopeId")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String initialEnvelopeId;
        @XmlElement(name = "ConsignmentId")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String consignmentId;

        /**
         * Gets the value of the messageKind property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageKind() {
            return messageKind;
        }

        /**
         * Sets the value of the messageKind property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageKind(String value) {
            this.messageKind = value;
        }

        /**
         * Gets the value of the preparationDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getPreparationDateTime() {
            return preparationDateTime;
        }

        /**
         * Sets the value of the preparationDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setPreparationDateTime(XMLGregorianCalendar value) {
            this.preparationDateTime = value;
        }

        /**
         * Gets the value of the envelopeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnvelopeId() {
            return envelopeId;
        }

        /**
         * Sets the value of the envelopeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnvelopeId(String value) {
            this.envelopeId = value;
        }

        /**
         * Gets the value of the initialEnvelopeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInitialEnvelopeId() {
            return initialEnvelopeId;
        }

        /**
         * Sets the value of the initialEnvelopeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInitialEnvelopeId(String value) {
            this.initialEnvelopeId = value;
        }

        /**
         * Gets the value of the consignmentId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConsignmentId() {
            return consignmentId;
        }

        /**
         * Sets the value of the consignmentId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConsignmentId(String value) {
            this.consignmentId = value;
        }

    }

}
