/*
 * Nodo requerido para expresar la información del contribuyente emisor del comprobante.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 * @author Carlos Aguirre 12 Febrero 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {        
        "domicilioFiscal",
        "expedidoEn"        
    })
@Entity
public class Emisor implements Serializable {

    @XmlTransient
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }
    @XmlAttribute(name = "nombre", required = true)
    @Column(nullable = false)
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
    @Column(nullable = false)
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
    @OneToOne(cascade=CascadeType.ALL)
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
    @OneToOne(cascade=CascadeType.ALL)
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
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
