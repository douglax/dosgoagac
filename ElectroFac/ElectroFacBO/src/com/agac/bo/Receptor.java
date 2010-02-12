/*
 * Nodo requerido para precisar la información del contribuyente
 * receptor del comprobante.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
public class Receptor {

    @XmlElement(name="Domicilio", required=true)
    private Ubicacion domicilio;
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
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
