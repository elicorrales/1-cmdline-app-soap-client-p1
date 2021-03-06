package com.eli.calc.shape.service.ws.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.eli.calc.shape.service.ws.ShapeCalculatorWebService;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-10-11T19:20:47.077-04:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "ShapeCalculatorWebServiceImplService", 
                  wsdlLocation = "http://localhost:8080/1-ws-rest-p3/services/soap/shapecalc?wsdl",
                  targetNamespace = "http://impl.ws.service.shape.calc.eli.com/") 
public class ShapeCalculatorWebServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.ws.service.shape.calc.eli.com/", "ShapeCalculatorWebServiceImplService");
    public final static QName ShapeCalculatorWebServiceImplPort = new QName("http://impl.ws.service.shape.calc.eli.com/", "ShapeCalculatorWebServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/1-ws-rest-p3/services/soap/shapecalc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ShapeCalculatorWebServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/1-ws-rest-p3/services/soap/shapecalc?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ShapeCalculatorWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ShapeCalculatorWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ShapeCalculatorWebServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ShapeCalculatorWebServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ShapeCalculatorWebServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ShapeCalculatorWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ShapeCalculatorWebService
     */
    @WebEndpoint(name = "ShapeCalculatorWebServiceImplPort")
    public ShapeCalculatorWebService getShapeCalculatorWebServiceImplPort() {
        return super.getPort(ShapeCalculatorWebServiceImplPort, ShapeCalculatorWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ShapeCalculatorWebService
     */
    @WebEndpoint(name = "ShapeCalculatorWebServiceImplPort")
    public ShapeCalculatorWebService getShapeCalculatorWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(ShapeCalculatorWebServiceImplPort, ShapeCalculatorWebService.class, features);
    }

}
