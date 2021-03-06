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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "impuesto")
    private Map<String, Retencion> retenciones;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "impuesto")
    private Map<String, Traslado> traslados;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    @Column(columnDefinition="Decimal(20,6)")
    private BigDecimal totalImpuestosRetenidos = new BigDecimal("0.0");
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    @Column(columnDefinition="Decimal(20,6)")
    private BigDecimal totalImpuestosTrasladados = new BigDecimal("0.0");

    public Map<String, Retencion> getRetenciones() {

        return retenciones;
    }

    public void setRetenciones(Map<String, Retencion> retenciones) {
        Map<String, Retencion> oldParte = this.retenciones;
        this.retenciones = retenciones;
        propertyChangeSupport.firePropertyChange("retencion", oldParte, retenciones);
    }

    public Map<String, Traslado> getTraslados() {
        if (traslados == null) {
            traslados = new TreeMap<String, Traslado>();
        }
        return traslados;
    }

    public void setTraslados(Map<String, Traslado> traslados) {
        Map<String, Traslado> oldParte = this.traslados;
        this.traslados = traslados;
        propertyChangeSupport.firePropertyChange("traslados", oldParte, traslados);
    }

    public BigDecimal getTotalImpuestosRetenidos() {
        if (totalImpuestosRetenidos.equals(new BigDecimal("0")) || totalImpuestosRetenidos == null) {
            return null;
        } else {
            return totalImpuestosRetenidos;
        }
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

    @XmlElementWrapper(name = "Traslados", namespace = "http://www.sat.gob.mx/cfd/2")
    @XmlElement(name = "Traslado", namespace = "http://www.sat.gob.mx/cfd/2")
    public List<Traslado> getTrasladosList() {
        return new ArrayList<Traslado>(traslados.values());
    }

    @XmlElementWrapper(name = "Retenciones", namespace = "http://www.sat.gob.mx/cfd/2")
    @XmlElement(name = "Retencion", namespace = "http://www.sat.gob.mx/cfd/2")
    public List<Retencion> getRetencionesList() {
        if (retenciones == null || retenciones.isEmpty()) {
            return null;
        } else {
            return new ArrayList<Retencion>(retenciones.values());
        }
    }

    
}
