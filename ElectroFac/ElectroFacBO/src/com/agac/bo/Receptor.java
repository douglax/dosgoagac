/*
 * Nodo requerido para precisar la información del contribuyente
 * receptor del comprobante.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {
        "domicilio"        
    })
@Entity
public class Receptor implements Serializable {

    @XmlTransient
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @XmlElement(name="Domicilio", required=true)
    private Ubicacion domicilio = new Ubicacion();
    @XmlAttribute(name = "rfc", required = true)
    private String rfc;
    @XmlAttribute
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        String oldRfc = this.rfc;
        this.rfc = rfc;
        propertyChangeSupport.firePropertyChange("rfc", oldRfc, rfc);
    }

    public Ubicacion getDomicilio() {
        return domicilio;
    }
    
    public void setDomicilio(Ubicacion domicilio) {
        Ubicacion oldDomicilio = this.domicilio;
        this.domicilio = domicilio;
        propertyChangeSupport.firePropertyChange("domicilio", oldDomicilio, domicilio);
    }

    @XmlTransient
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        if(domicilio != null){
            domicilio.addPropertyChangeListener(listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
         if(domicilio != null){
            domicilio.removePropertyChangeListener(listener);
        }
    }
}
