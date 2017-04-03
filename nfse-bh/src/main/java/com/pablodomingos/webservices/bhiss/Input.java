/**
 * Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pablodomingos.webservices.bhiss;

public class Input  implements java.io.Serializable {
    private java.lang.String nfseCabecMsg;

    private java.lang.String nfseDadosMsg;

    public Input() {
    }

    public Input(
           java.lang.String nfseCabecMsg,
           java.lang.String nfseDadosMsg) {
           this.nfseCabecMsg = nfseCabecMsg;
           this.nfseDadosMsg = nfseDadosMsg;
    }


    /**
     * Gets the nfseCabecMsg value for this Input.
     * 
     * @return nfseCabecMsg
     */
    public java.lang.String getNfseCabecMsg() {
        return nfseCabecMsg;
    }


    /**
     * Sets the nfseCabecMsg value for this Input.
     * 
     * @param nfseCabecMsg
     */
    public void setNfseCabecMsg(java.lang.String nfseCabecMsg) {
        this.nfseCabecMsg = nfseCabecMsg;
    }


    /**
     * Gets the nfseDadosMsg value for this Input.
     * 
     * @return nfseDadosMsg
     */
    public java.lang.String getNfseDadosMsg() {
        return nfseDadosMsg;
    }


    /**
     * Sets the nfseDadosMsg value for this Input.
     * 
     * @param nfseDadosMsg
     */
    public void setNfseDadosMsg(java.lang.String nfseDadosMsg) {
        this.nfseDadosMsg = nfseDadosMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Input)) return false;
        Input other = (Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nfseCabecMsg==null && other.getNfseCabecMsg()==null) || 
             (this.nfseCabecMsg!=null &&
              this.nfseCabecMsg.equals(other.getNfseCabecMsg()))) &&
            ((this.nfseDadosMsg==null && other.getNfseDadosMsg()==null) || 
             (this.nfseDadosMsg!=null &&
              this.nfseDadosMsg.equals(other.getNfseDadosMsg())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNfseCabecMsg() != null) {
            _hashCode += getNfseCabecMsg().hashCode();
        }
        if (getNfseDadosMsg() != null) {
            _hashCode += getNfseDadosMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.bhiss.pbh.gov.br", "input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nfseCabecMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nfseCabecMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nfseDadosMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nfseDadosMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
