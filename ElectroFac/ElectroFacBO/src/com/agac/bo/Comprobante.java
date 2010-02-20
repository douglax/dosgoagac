package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlRootElement(name = "Comprobante", namespace="http://www.sat.gob.mx/cfd/2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comprobante {

    @XmlElement(name="Emisor", required=true)
    private Emisor emisor;
    @XmlElement(name="Receptor", required=true)
    private Receptor receptor;

    @XmlElementWrapper(name="Conceptos")
    @XmlElement(name="Concepto")
    private List<Concepto> conceptos;

    
    @XmlElement(name="Impuestos", required=true)
    private Impuesto impuesto;

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }


    public List<Concepto> getConceptos() {
        if(conceptos == null)
            conceptos = new ArrayList<Concepto>();
        return conceptos;
    }

    public void setConceptos(List<Concepto> conceptos) {
        List<Concepto> oldConceptos = this.conceptos;
        this.conceptos = conceptos;
        propertyChangeSupport.firePropertyChange("conceptos", oldConceptos, conceptos);
    }


    public Receptor getReceptor() {
        if(receptor == null)
            receptor = new Receptor();
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        Receptor oldReceptor = this.receptor;
        this.receptor = receptor;
        propertyChangeSupport.firePropertyChange("receptor", oldReceptor, receptor);
    }

    public Emisor getEmisor() {
        if(emisor == null)
            emisor = new Emisor();
        return emisor;
    }
    public void setEmisor(Emisor emisor) {
        Emisor oldEmisor = this.emisor;
        this.emisor = emisor;
        propertyChangeSupport.firePropertyChange("emisor", oldEmisor, emisor);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
}
