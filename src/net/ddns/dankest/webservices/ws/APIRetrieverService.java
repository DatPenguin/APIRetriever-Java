/**
 * APIRetrieverService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.ddns.dankest.webservices.ws;

public interface APIRetrieverService extends javax.xml.rpc.Service {
    public java.lang.String getAPIRetrieverAddress();

    public APIRetriever_PortType getAPIRetriever() throws javax.xml.rpc.ServiceException;

    public APIRetriever_PortType getAPIRetriever(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
