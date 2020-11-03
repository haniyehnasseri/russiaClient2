
package service.RU;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.0
 * 2020-10-29T17:10:36.466+03:30
 * Generated source version: 3.4.0
 */

@WebFault(name = "MessageNotFound", targetNamespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0")
public class MessageNotFoundException extends Exception {

    private service.RU.MessageNotFoundFaultType messageNotFound;

    public MessageNotFoundException() {
        super();
    }

    public MessageNotFoundException(String message) {
        super(message);
    }

    public MessageNotFoundException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public MessageNotFoundException(String message, service.RU.MessageNotFoundFaultType messageNotFound) {
        super(message);
        this.messageNotFound = messageNotFound;
    }

    public MessageNotFoundException(String message, service.RU.MessageNotFoundFaultType messageNotFound, java.lang.Throwable cause) {
        super(message, cause);
        this.messageNotFound = messageNotFound;
    }

    public service.RU.MessageNotFoundFaultType getFaultInfo() {
        return this.messageNotFound;
    }
}