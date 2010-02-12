/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author caguirre
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class InformacionAduanera {

    @XmlAttribute(required=true)
    private String numero;
    @XmlAttribute(required=true)
    private Date fecha;
    @XmlAttribute(required=true)
    private String aduana;

    public String getAduana() {
        return aduana;
    }

    public void setAduana(String aduana) {
        String oldAduana = this.aduana;
        this.aduana = aduana;
        propertyChangeSupport.firePropertyChange("aduana", oldAduana, aduana);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
