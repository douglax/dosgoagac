/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author alex
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "retenciones",
    "traslados"
})
public class Impuesto implements Serializable {
    @XmlElementWrapper(name="Retenciones")
    @XmlElement(name = "Retencion")
    private List<Retencion> retenciones;
    @XmlElementWrapper(name="Traslados")
    @XmlElement(name = "Traslado")
    private List<Traslado> traslados;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    private BigDecimal totalImpuestosRetenidos;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    private BigDecimal totalImpuestosTrasladados;


    /**
     * Gets the value of the retenciones property.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Impuestos.Retenciones }
     *
     */
    public List<Retencion> getRetenciones() {
        if (retenciones == null) {
            retenciones = new ArrayList<Retencion>();
        }
        return retenciones;
    }

    /**
     * Sets the value of the retenciones property.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Impuestos.Retenciones }
     *
     */
    public void setRetenciones(List<Retencion> retenciones) {
        List<Retencion> oldParte = this.retenciones;
        this.retenciones = retenciones;
        propertyChangeSupport.firePropertyChange("retencion", oldParte, retenciones);
    }

    /**
     * Gets the value of the traslados property.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Impuestos.Traslados }
     *
     */
    public List<Traslado> getTraslados() {
        if (traslados == null) {
            traslados = new ArrayList<Traslado>();
        }
        return traslados;
    }

    /**
     * Sets the value of the traslados property.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Impuestos.Traslados }
     *
     */
    public void setTraslados(List<Traslado> traslados) {
        List<Traslado> oldParte = this.traslados;
        this.traslados = traslados;
        propertyChangeSupport.firePropertyChange("traslados", oldParte, traslados);
    }

    /**
     * Gets the value of the totalImpuestosRetenidos property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    /**
     * Sets the value of the totalImpuestosRetenidos property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotalImpuestosRetenidos(BigDecimal value) {
        this.totalImpuestosRetenidos = value;
    }

    /**
     * Gets the value of the totalImpuestosTrasladados property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    /**
     * Sets the value of the totalImpuestosTrasladados property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotalImpuestosTrasladados(BigDecimal value) {
        this.totalImpuestosTrasladados = value;
    }
    @XmlTransient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
