/*
 * Nodo opcional donde se incluirán los nodos complementarios de extensión al
 * concepto, definidos por el SAT, de acuerdo a disposiciones particulares a
 * un sector o actividad especifica.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Aguirre 13 Feb 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ComplementoConcepto {

    @XmlAnyElement(lax=true)
    private List<Object> any;


    public List<Object> getAny() {
        if(any == null)
            any = new ArrayList<Object>();
        return any;
    }

    public void setAny(List<Object> any) {
        List<Object> oldAny = this.any;
        this.any = any;
        propertyChangeSupport.firePropertyChange("any", oldAny, any);
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
