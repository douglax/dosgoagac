package com.agac.bo;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "retencion"
        })
public class Retencion {

    @XmlAttribute(required = true)
    private String impuesto;


    @XmlAttribute(required = true)
    private BigDecimal importe;

    /**
     * Gets the value of the impuesto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getImpuesto() {
        return impuesto;
    }

    /**
     * Sets the value of the impuesto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setImpuesto(String value) {
        this.impuesto = value;
    }

    /**
     * Gets the value of the importe property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Sets the value of the importe property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setImporte(BigDecimal value) {
        this.importe = value;
    }
}
