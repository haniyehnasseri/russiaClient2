package service.RU;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.0
 * 2020-10-29T17:10:36.549+03:30
 * Generated source version: 3.4.0
 *
 */
@WebServiceClient(name = "ForeignApiService",
                  wsdlLocation = "file:/C:/Users/haniye/OneDrive/Desktop/jax-ws/russiaClient/src/main/resources/RU.wsdl",
                  targetNamespace = "urn:customs.ru:ForeignApi:1.0")
public class ForeignApiService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:customs.ru:ForeignApi:1.0", "ForeignApiService");
    public final static QName ForeignApiEndpointPort = new QName("urn:customs.ru:ForeignApi:1.0", "ForeignApiEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/haniye/OneDrive/Desktop/jax-ws/russiaClient/src/main/resources/RU.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ForeignApiService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/haniye/OneDrive/Desktop/jax-ws/russiaClient/src/main/resources/RU.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ForeignApiService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ForeignApiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ForeignApiService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ForeignApiService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ForeignApiService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ForeignApiService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ForeignApi
     */
    @WebEndpoint(name = "ForeignApiEndpointPort")
    public ForeignApi getForeignApiEndpointPort() {
        return super.getPort(ForeignApiEndpointPort, ForeignApi.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ForeignApi
     */
    @WebEndpoint(name = "ForeignApiEndpointPort")
    public ForeignApi getForeignApiEndpointPort(WebServiceFeature... features) {
        return super.getPort(ForeignApiEndpointPort, ForeignApi.class, features);
    }

}