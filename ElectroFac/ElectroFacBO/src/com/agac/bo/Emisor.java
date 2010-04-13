/*
 * Nodo requerido para expresar la información del contribuyente emisor del comprobante.
 */
package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        propertyChangeSupport.firePropertyChange("rfc", oldRfc, rfc);
    }
    @XmlElement(name = "ExpedidoEn", required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Ubicacion expedidoEn = new Ubicacion();

    public Ubicacion getExpedidoEn() {
        return expedidoEn;
    }

    public void setExpedidoEn(Ubicacion expedidoEn) {
        Ubicacion oldExpedidoEn = this.expedidoEn;
        this.expedidoEn = expedidoEn;
        propertyChangeSupport.firePropertyChange("expedidoEn", oldExpedidoEn, expedidoEn);
    }
    @XmlElement(name = "DomicilioFiscal", required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private UbicacionFiscal domicilioFiscal = new UbicacionFiscal();

    public UbicacionFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(UbicacionFiscal domicilioFiscal) {
        UbicacionFiscal oldDomicilioFiscal = this.domicilioFiscal;
        this.domicilioFiscal = domicilioFiscal;
        propertyChangeSupport.firePropertyChange("domicilioFiscal", oldDomicilioFiscal, domicilioFiscal);
    }

    @XmlTransient
    private String rutaCertificado;

    public String getRutaCertificado() {
        return rutaCertificado;
    }

    public void setRutaCertificado(String rutaCertificado) {
        String oldRutaCertificado = this.rutaCertificado;
        this.rutaCertificado = rutaCertificado;
        propertyChangeSupport.firePropertyChange("rutaCertificado", oldRutaCertificado, rutaCertificado);
    }

    @XmlTransient
    private String rutaLlave;

    public String getRutaLlave() {
        return rutaLlave;
    }

    public void setRutaLlave(String rutaLlave) {
        String oldRutaLlave = this.rutaLlave;
        this.rutaLlave = rutaLlave;
        propertyChangeSupport.firePropertyChange("rutaLlave", oldRutaLlave, rutaLlave);
    }

    @XmlTransient
    private String passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        String oldPasswd = this.passwd;
        this.passwd = passwd;
        propertyChangeSupport.firePropertyChange("passwd", oldPasswd, passwd);
    }

    @XmlTransient
    @OneToMany(cascade=CascadeType.ALL)
    private List<Serie> series;

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> serieList) {
        this.series = serieList;
        propertyChangeSupport.firePropertyChange("series", null, passwd);
    }

    @XmlTransient
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(columnDefinition="BLOB")
    private byte[] logo;

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        byte[] oldLogo = this.logo;
        this.logo = logo;
        propertyChangeSupport.firePropertyChange("logo", oldLogo, logo);
    }


    @XmlTransient
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        domicilioFiscal.addPropertyChangeListener(listener);
        expedidoEn.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
        if (domicilioFiscal != null) {
            domicilioFiscal.removePropertyChangeListener(listener);
        }
        if (expedidoEn != null) {
            expedidoEn.removePropertyChangeListener(listener);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emisor other = (Emisor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

}
