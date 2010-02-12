/*
 *Nodo opcional para asentar el número de cuenta predial con el que fue
 *registrado el inmueble, en el sistema catastral de la entidad federativa
 *de que trate.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlType(propOrder={"infoAduaneta", "cuentaPredial"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CuentaPredial {

    public CuentaPredial() {
    }

    public CuentaPredial(String numero) {
        this.numero = numero;
    }

    @XmlAttribute
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange("numero", oldNumero, numero);
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
