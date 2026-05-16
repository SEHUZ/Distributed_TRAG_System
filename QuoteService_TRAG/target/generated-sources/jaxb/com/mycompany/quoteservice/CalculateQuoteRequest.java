//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2026.05.15 a las 07:59:02 PM MST 
//


package com.mycompany.quoteservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clienteId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="vehiculoId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="vehicleStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="generalDiagnosis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clienteId",
    "vehiculoId",
    "serviceId",
    "vehicleStatus",
    "generalDiagnosis"
})
@XmlRootElement(name = "CalculateQuoteRequest")
public class CalculateQuoteRequest {

    protected long clienteId;
    protected long vehiculoId;
    protected long serviceId;
    protected String vehicleStatus;
    protected String generalDiagnosis;

    /**
     * Obtiene el valor de la propiedad clienteId.
     * 
     */
    public long getClienteId() {
        return clienteId;
    }

    /**
     * Define el valor de la propiedad clienteId.
     * 
     */
    public void setClienteId(long value) {
        this.clienteId = value;
    }

    /**
     * Obtiene el valor de la propiedad vehiculoId.
     * 
     */
    public long getVehiculoId() {
        return vehiculoId;
    }

    /**
     * Define el valor de la propiedad vehiculoId.
     * 
     */
    public void setVehiculoId(long value) {
        this.vehiculoId = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceId.
     * 
     */
    public long getServiceId() {
        return serviceId;
    }

    /**
     * Define el valor de la propiedad serviceId.
     * 
     */
    public void setServiceId(long value) {
        this.serviceId = value;
    }

    /**
     * Obtiene el valor de la propiedad vehicleStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleStatus() {
        return vehicleStatus;
    }

    /**
     * Define el valor de la propiedad vehicleStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleStatus(String value) {
        this.vehicleStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad generalDiagnosis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralDiagnosis() {
        return generalDiagnosis;
    }

    /**
     * Define el valor de la propiedad generalDiagnosis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralDiagnosis(String value) {
        this.generalDiagnosis = value;
    }

}
