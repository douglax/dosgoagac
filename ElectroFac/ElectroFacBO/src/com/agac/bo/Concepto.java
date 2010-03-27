/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlType(propOrder={"infoAduanera", "cuentaPredial", "complemento", "parte"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Concepto implements Serializable {

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

    @XmlElement(name="InformacionAduanera")
    @OneToMany(cascade=CascadeType.ALL)
    private List<InformacionAduanera> infoAduanera;

    @XmlElement(name="CuentaPredial")
    @OneToOne
    private CuentaPredial cuentaPredial;

    @XmlElement(name="ComplementoConcepto")
    @Transient
    private ComplementoConcepto complemento;

    @XmlElement(name="Parte")
    @OneToMany(cascade=CascadeType.ALL)
    private List<Parte> parte;

    @XmlAttribute(required=true)
    private double cantidad;

    @XmlAttribute
    private String unidad = "Pieza";

    @XmlAttribute
    private String noIdentificacion;

    @XmlAttribute(required=true)
    private String descripcion;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute(required=true)
    private BigDecimal valorUnitario;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute(required=true)
    private BigDecimal importe;

    public BigDecimal getImporte() {
        importe = valorUnitario.multiply(new BigDecimal(cantidad));
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        BigDecimal oldImporte = this.importe;
        this.importe = importe;
        propertyChangeSupport.firePropertyChange("importe", oldImporte, importe);
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        BigDecimal oldValorUnitario = this.valorUnitario;
        this.valorUnitario = valorUnitario;
        propertyChangeSupport.firePropertyChange("valorUnitario", oldValorUnitario, valorUnitario);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        propertyChangeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        String oldNoIdentificacion = this.noIdentificacion;
        this.noIdentificacion = noIdentificacion;
        propertyChangeSupport.firePropertyChange("noIdentificacion", oldNoIdentificacion, noIdentificacion);
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        String oldUnidad = this.unidad;
        this.unidad = unidad;
        propertyChangeSupport.firePropertyChange("unidad", oldUnidad, unidad);
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        double oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        propertyChangeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
    }

    public List<Parte> getParte() {
        if(parte == null)
            parte = new ArrayList<Parte>();
        return parte;
    }

    public void setParte(List<Parte> parte) {
        List<Parte> oldParte = this.parte;
        this.parte = parte;
        propertyChangeSupport.firePropertyChange("parte", oldParte, parte);
    }


    public ComplementoConcepto getComplemento() {
        if(complemento == null)
            complemento = new ComplementoConcepto();
        return complemento;
    }

    public void setComplemento(ComplementoConcepto complemento) {
        ComplementoConcepto oldComplemento = this.complemento;
        this.complemento = complemento;
        propertyChangeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

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
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        for(Parte p : getParte())
            p.addPropertyChangeListener(listener);
        if(infoAduanera != null)
            for(InformacionAduanera inf : infoAduanera)
                inf.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
        for(Parte p : getParte())
            p.removePropertyChangeListener(listener);
        if(infoAduanera != null)
            for(InformacionAduanera inf : infoAduanera)
                inf.removePropertyChangeListener(listener);
    }

    public BigDecimal getTotalPartes(){
        BigDecimal total = new BigDecimal(0);
        if(parte != null){
            for(Parte p : parte){
                total = total.add(p.getImporte());
            }
        }
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Concepto other = (Concepto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }


}
