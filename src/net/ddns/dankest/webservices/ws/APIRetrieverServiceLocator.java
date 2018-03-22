/**
 * APIRetrieverServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.ddns.dankest.webservices.ws;

public class APIRetrieverServiceLocator extends org.apache.axis.client.Service implements APIRetrieverService {

    public APIRetrieverServiceLocator() {
    }


    public APIRetrieverServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public APIRetrieverServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for APIRetriever
    private java.lang.String APIRetriever_address = "http://localhost:8080/Calculator/services/APIRetriever";

    public java.lang.String getAPIRetrieverAddress() {
        return APIRetriever_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String APIRetrieverWSDDServiceName = "APIRetriever";

    public java.lang.String getAPIRetrieverWSDDServiceName() {
        return APIRetrieverWSDDServiceName;
    }

    public void setAPIRetrieverWSDDServiceName(java.lang.String name) {
        APIRetrieverWSDDServiceName = name;
    }

    public APIRetriever_PortType getAPIRetriever() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(APIRetriever_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAPIRetriever(endpoint);
    }

    public APIRetriever_PortType getAPIRetriever(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            APIRetrieverSoapBindingStub _stub = new APIRetrieverSoapBindingStub(portAddress, this);
            _stub.setPortName(getAPIRetrieverWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAPIRetrieverEndpointAddress(java.lang.String address) {
        APIRetriever_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (APIRetriever_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                APIRetrieverSoapBindingStub _stub = new APIRetrieverSoapBindingStub(new java.net.URL(APIRetriever_address), this);
                _stub.setPortName(getAPIRetrieverWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("APIRetriever".equals(inputPortName)) {
            return getAPIRetriever();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://apiretriever.dankest.ddns.net", "APIRetrieverService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://apiretriever.dankest.ddns.net", "APIRetriever"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("APIRetriever".equals(portName)) {
            setAPIRetrieverEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
