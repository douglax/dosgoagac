package com.agac.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Retencion implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @XmlAttribute(required = true)
    private String impuesto;
    
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

