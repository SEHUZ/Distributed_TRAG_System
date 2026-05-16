//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2026.05.15 a las 07:59:02 PM MST 
//


package com.mycompany.quoteservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="quoteId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "quoteId",
    "mensaje",
    "totalEstimado"
})
@XmlRootElement(name = "CalculateQuoteResponse")
public class CalculateQuoteResponse {

    protected long quoteId;
    @XmlElement(required = true)
    protected String mensaje;
    protected double totalEstimado;

    /**
     * Obtiene el valor de la propiedad quoteId.
     * 
     */
    public long getQuoteId() {
        return quoteId;
    }

    /**
     * Define el valor de la propiedad quoteId.
     * 
     */
    public void setQuoteId(long value) {
        this.quoteId = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
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
