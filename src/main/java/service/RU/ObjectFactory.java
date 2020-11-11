
package service.RU;

import service.RU.Faults.*;
import service.RU.Formats.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.RU package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvalidMessage_QNAME = new QName("urn:customs.ru:ForeignApi:FaultTypes:1.0", "InvalidMessage");
    private final static QName _MessageAlreadyExist_QNAME = new QName("urn:customs.ru:ForeignApi:FaultTypes:1.0", "MessageAlreadyExist");
    private final static QName _MessageNotFound_QNAME = new QName("urn:customs.ru:ForeignApi:FaultTypes:1.0", "MessageNotFound");
    private final static QName _UnknownError_QNAME = new QName("urn:customs.ru:ForeignApi:FaultTypes:1.0", "UnknownError");
    private final static QName _SendMessageRequest_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "SendMessageRequest");
    private final static QName _SendMessageResponse_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "SendMessageResponse");
    private final static QName _GetNewMessageListRequest_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "GetNewMessageListRequest");
    private final static QName _GetNewMessageListResponse_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "GetNewMessageListResponse");
    private final static QName _GetMessageRequest_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "GetMessageRequest");
    private final static QName _GetMessageResponse_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "GetMessageResponse");
    private final static QName _ConfirmationMessageRequest_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "ConfirmationMessageRequest");
    private final static QName _ConfirmationMessageResponse_QNAME = new QName("urn:customs.ru:ForeignApi:Formats:1.0", "ConfirmationMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.RU
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link InvalidMessageFaultType }
     * 
     */
    public InvalidMessageFaultType createInvalidMessageFaultType() {
        return new InvalidMessageFaultType();
    }

    /**
     * Create an instance of {@link MessageAlreadyExistFaultType }
     * 
     */
    public MessageAlreadyExistFaultType createMessageAlreadyExistFaultType() {
        return new MessageAlreadyExistFaultType();
    }

    /**
     * Create an instance of {@link MessageNotFoundFaultType }
     * 
     */
    public MessageNotFoundFaultType createMessageNotFoundFaultType() {
        return new MessageNotFoundFaultType();
    }

    /**
     * Create an instance of {@link UnknownErrorType }
     * 
     */
    public UnknownErrorType createUnknownErrorType() {
        return new UnknownErrorType();
    }

    /**
     * Create an instance of {@link FaultCommonType }
     * 
     */
    public FaultCommonType createFaultCommonType() {
        return new FaultCommonType();
    }

    /**
     * Create an instance of {@link SendMessageRequestType }
     * 
     */
    public SendMessageRequestType createSendMessageRequestType() {
        return new SendMessageRequestType();
    }

    /**
     * Create an instance of {@link SendMessageResponseType }
     * 
     */
    public SendMessageResponseType createSendMessageResponseType() {
        return new SendMessageResponseType();
    }

    /**
     * Create an instance of {@link GetNewMessageListRequestType }
     * 
     */
    public GetNewMessageListRequestType createGetNewMessageListRequestType() {
        return new GetNewMessageListRequestType();
    }

    /**
     * Create an instance of {@link GetNewMessageListResponseType }
     * 
     */
    public GetNewMessageListResponseType createGetNewMessageListResponseType() {
        return new GetNewMessageListResponseType();
    }

    /**
     * Create an instance of {@link GetMessageRequestType }
     * 
     */
    public GetMessageRequestType createGetMessageRequestType() {
        return new GetMessageRequestType();
    }

    /**
     * Create an instance of {@link GetMessageResponseType }
     * 
     */
    public GetMessageResponseType createGetMessageResponseType() {
        return new GetMessageResponseType();
    }

    /**
     * Create an instance of {@link ConfirmationMessageRequestType }
     * 
     */
    public ConfirmationMessageRequestType createConfirmationMessageRequestType() {
        return new ConfirmationMessageRequestType();
    }

    /**
     * Create an instance of {@link ConfirmationMessageResponseType }
     * 
     */
    public ConfirmationMessageResponseType createConfirmationMessageResponseType() {
        return new ConfirmationMessageResponseType();
    }

    /**
     * Create an instance of {@link SuccessProcessingResultType }
     * 
     */
    public SuccessProcessingResultType createSuccessProcessingResultType() {
        return new SuccessProcessingResultType();
    }

    /**
     * Create an instance of {@link MessageType.MessageMeta }
     * 
     */
    public MessageType.MessageMeta createMessageTypeMessageMeta() {
        return new MessageType.MessageMeta();
    }

    /**
     * Create an instance of {@link MessageType.MessageContent }
     * 
     */
    public MessageType.MessageContent createMessageTypeMessageContent() {
        return new MessageType.MessageContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidMessageFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidMessageFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0", name = "InvalidMessage")
    public JAXBElement<InvalidMessageFaultType> createInvalidMessage(InvalidMessageFaultType value) {
        return new JAXBElement<InvalidMessageFaultType>(_InvalidMessage_QNAME, InvalidMessageFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageAlreadyExistFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageAlreadyExistFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0", name = "MessageAlreadyExist")
    public JAXBElement<MessageAlreadyExistFaultType> createMessageAlreadyExist(MessageAlreadyExistFaultType value) {
        return new JAXBElement<MessageAlreadyExistFaultType>(_MessageAlreadyExist_QNAME, MessageAlreadyExistFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageNotFoundFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageNotFoundFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0", name = "MessageNotFound")
    public JAXBElement<MessageNotFoundFaultType> createMessageNotFound(MessageNotFoundFaultType value) {
        return new JAXBElement<MessageNotFoundFaultType>(_MessageNotFound_QNAME, MessageNotFoundFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnknownErrorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnknownErrorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0", name = "UnknownError")
    public JAXBElement<UnknownErrorType> createUnknownError(UnknownErrorType value) {
        return new JAXBElement<UnknownErrorType>(_UnknownError_QNAME, UnknownErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendMessageRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "SendMessageRequest")
    public JAXBElement<SendMessageRequestType> createSendMessageRequest(SendMessageRequestType value) {
        return new JAXBElement<SendMessageRequestType>(_SendMessageRequest_QNAME, SendMessageRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendMessageResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "SendMessageResponse")
    public JAXBElement<SendMessageResponseType> createSendMessageResponse(SendMessageResponseType value) {
        return new JAXBElement<SendMessageResponseType>(_SendMessageResponse_QNAME, SendMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewMessageListRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetNewMessageListRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "GetNewMessageListRequest")
    public JAXBElement<GetNewMessageListRequestType> createGetNewMessageListRequest(GetNewMessageListRequestType value) {
        return new JAXBElement<GetNewMessageListRequestType>(_GetNewMessageListRequest_QNAME, GetNewMessageListRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewMessageListResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetNewMessageListResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "GetNewMessageListResponse")
    public JAXBElement<GetNewMessageListResponseType> createGetNewMessageListResponse(GetNewMessageListResponseType value) {
        return new JAXBElement<GetNewMessageListResponseType>(_GetNewMessageListResponse_QNAME, GetNewMessageListResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMessageRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "GetMessageRequest")
    public JAXBElement<GetMessageRequestType> createGetMessageRequest(GetMessageRequestType value) {
        return new JAXBElement<GetMessageRequestType>(_GetMessageRequest_QNAME, GetMessageRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMessageResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "GetMessageResponse")
    public JAXBElement<GetMessageResponseType> createGetMessageResponse(GetMessageResponseType value) {
        return new JAXBElement<GetMessageResponseType>(_GetMessageResponse_QNAME, GetMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmationMessageRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfirmationMessageRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "ConfirmationMessageRequest")
    public JAXBElement<ConfirmationMessageRequestType> createConfirmationMessageRequest(ConfirmationMessageRequestType value) {
        return new JAXBElement<ConfirmationMessageRequestType>(_ConfirmationMessageRequest_QNAME, ConfirmationMessageRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmationMessageResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfirmationMessageResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:customs.ru:ForeignApi:Formats:1.0", name = "ConfirmationMessageResponse")
    public JAXBElement<ConfirmationMessageResponseType> createConfirmationMessageResponse(ConfirmationMessageResponseType value) {
        return new JAXBElement<ConfirmationMessageResponseType>(_ConfirmationMessageResponse_QNAME, ConfirmationMessageResponseType.class, null, value);
    }

}
