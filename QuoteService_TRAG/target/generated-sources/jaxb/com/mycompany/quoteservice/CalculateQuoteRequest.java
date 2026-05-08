//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2026.05.08 a las 04:10:33 PM MST 
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
 *         &lt;element name="clienteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vehiculoId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="totalEstimado" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
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
    "totalEstimado"
})
@XmlRootElement(name = "CalculateQuoteRequest")
public class CalculateQuoteRequest {

    protected int clienteId;
    protected int vehiculoId;
    protected double totalEstimado;

    /**
     * Obtiene el valor de la propiedad clienteId.
     * 
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Define el valor de la propiedad clienteId.
     * 
     */
    public void setClienteId(int value) {
        this.clienteId = value;
    }

    /**
     * Obtiene el valor de la propiedad vehiculoId.
     * 
     */
    public int getVehiculoId() {
        return vehiculoId;
    }

    /**
     * Define el valor de la propiedad vehiculoId.
     * 
     */
    public void setVehiculoId(int value) {
        this.vehiculoId = value;
    }

    /**
     * Obtiene el valor de la propiedad totalEstimado.
     * 
     */
    public double getTotalEstimado() {
        return totalEstimado;
    }

    /**
     * Define el valor de la propiedad totalEstimado.
     * 
     */
    public void setTotalEstimado(double value) {
        this.totalEstimado = value;
    }

}
