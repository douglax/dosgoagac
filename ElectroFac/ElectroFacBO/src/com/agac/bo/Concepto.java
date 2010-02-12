/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlType(propOrder={"infoAduanera", "cuentaPredial"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Concepto {

    @XmlElement(name="InformacionAduanera")
    private List<InformacionAduanera> infoAduanera;
    @XmlElement(name="CuentaPredial")
    private CuentaPredial cuentaPredial;


    public CuentaPredial getCuentaPredial() {
        return cuentaPredial;
    }

    public void setCuentaPredial(CuentaPredial cuentaPredial) {
        CuentaPredial oldCuentaPredial = this.cuentaPredial;
        this.cuentaPredial = cuentaPredial;
        propertyChangeSupport.firePropertyChange("cuentaPredial", oldCuentaPredial, cuentaPredial);
    }

    public List<InformacionAduanera> getInfoAduanera() {
        return infoAduanera;
    }

    public void setInfoAduanera(List<InformacionAduanera> infoAduanera) {
        List<InformacionAduanera> oldInfoAduanera = this.infoAduanera;
        this.infoAduanera = infoAduanera;
        propertyChangeSupport.firePropertyChange("infoAduanera", oldInfoAduanera, infoAduanera);
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
