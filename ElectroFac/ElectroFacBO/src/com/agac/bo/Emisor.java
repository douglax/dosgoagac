/*
 * Nodo requerido para expresar la información del contribuyente emisor del comprobante.
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
 * @author Carlos Aguirre 12 Febrero 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {        
        "domicilioFiscal",
        "expedidoEn"        
    })
public class Emisor {
    @XmlAttribute(name = "nombre", required = true)
    private String nombre;    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }
    @XmlAttribute(name = "rfc", required = true)
    private String rfc;    

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        String oldRfc = this.rfc;
        this.rfc = rfc;
        propertyChangeSupport.firePropertyChange( "rfc", oldRfc, rfc);
    }
    @XmlElement(name="ExpedidoEn", required=true)
    private Ubicacion expedidoEn;    

    public Ubicacion getExpedidoEn() {
        if(expedidoEn == null)
            expedidoEn = new Ubicacion();
        return expedidoEn;
    }

    public void setExpedidoEn(Ubicacion expedidoEn) {
        Ubicacion oldExpedidoEn = this.expedidoEn;
        this.expedidoEn = expedidoEn;
        propertyChangeSupport.firePropertyChange("expedidoEn", oldExpedidoEn, expedidoEn);
    }

    @XmlElement(name="DomicilioFiscal", required=true)
    private UbicacionFiscal domicilioFiscal;    

    public UbicacionFiscal getDomicilioFiscal() {
        if(domicilioFiscal == null)
            domicilioFiscal = new UbicacionFiscal();
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(UbicacionFiscal domicilioFiscal) {
        UbicacionFiscal oldDomicilioFiscal = this.domicilioFiscal;
        this.domicilioFiscal = domicilioFiscal;
        propertyChangeSupport.firePropertyChange("domicilioFiscal", oldDomicilioFiscal, domicilioFiscal);
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