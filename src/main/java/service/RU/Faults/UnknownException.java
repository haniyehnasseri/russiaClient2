
package service.RU.Faults;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.0
 * 2020-10-29T17:10:36.343+03:30
 * Generated source version: 3.4.0
 */

@WebFault(name = "UnknownError", targetNamespace = "urn:customs.ru:ForeignApi:FaultTypes:1.0")
public class UnknownException extends Exception {

    private UnknownErrorType unknownError;

    public UnknownException() {
        super();
    }

    public UnknownException(String message) {
        super(message);
    }

    public UnknownException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UnknownException(String message, UnknownErrorType unknownError) {
        super(message);
        this.unknownError = unknownError;
    }

    public UnknownException(String message, UnknownErrorType unknownError, java.lang.Throwable cause) {
        super(message, cause);
        this.unknownError = unknownError;
    }

    public UnknownErrorType getFaultInfo() {
        return this.unknownError;
    }
}
