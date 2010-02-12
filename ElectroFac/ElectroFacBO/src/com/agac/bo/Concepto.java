/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
public class Concepto {

    private List<InformacionAduanera> infoAduanera;

    public List<InformacionAduanera> getInfoAduanera() {
        return infoAduanera;
    }
    public void setInfoAduanera(List<InformacionAduanera> infoAduanera) {
        List<InformacionAduanera> oldInfoAduanera = this.infoAduanera;
        this.infoAduanera = infoAduanera;
        propertyChangeSupport.firePropertyChange("infoAduanera", oldInfoAduanera, infoAduanera);
    }

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


}
