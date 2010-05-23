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
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author alex
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
    "retencionesList",
    "trasladosList"
})
@Entity
public class Impuesto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private Map<String,Retencion> retenciones;
    
    @OneToMany
    private Map<String,Traslado> traslados;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    private BigDecimal totalImpuestosRetenidos;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    private BigDecimal totalImpuestosTrasladados;

    public Map<String,Retencion> getRetenciones() {
        if (retenciones == null) {
            retenciones = new TreeMap<String,Retencion>();
        }
        return retenciones;
    }


    public void setRetenciones(Map<String,Retencion> retenciones) {
        Map<String,Retencion> oldParte = this.retenciones;
        this.retenciones = retenciones;
        propertyChangeSupport.firePropertyChange("retencion", oldParte, retenciones);
    }


    public Map<String,Traslado> getTraslados() {
        if (traslados == null) {
            traslados = new TreeMap<String,Traslado>();
        }
        return traslados;
    }


    public void setTraslados(Map<String,Traslado> traslados) {
        Map<String,Traslado> oldParte = this.traslados;
        this.traslados = traslados;
        propertyChangeSupport.firePropertyChange("traslados", oldParte, traslados);
    }


    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }


    public void setTotalImpuestosRetenidos(BigDecimal value) {
        this.totalImpuestosRetenidos = value;
    }


    public BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }


    public void setTotalImpuestosTrasladados(BigDecimal value) {
        this.totalImpuestosTrasladados = value;
    }

    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @XmlElementWrapper(name="Traslados")
    @XmlElement(name = "Traslado")
    public List<Traslado> getTrasladosList(){
        return new ArrayList<Traslado>(traslados.values());
    }

    @XmlElementWrapper(name="Retenciones")
    @XmlElement(name = "Retencion")
     public List<Retencion> getRetencionesList(){
        return new ArrayList<Retencion>(retenciones.values());
    }
}
