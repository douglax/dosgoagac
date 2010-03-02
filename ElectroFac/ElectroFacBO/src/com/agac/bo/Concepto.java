/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class Concepto {

    @XmlElement(name="InformacionAduanera")
    private List<InformacionAduanera> infoAduanera;
    @XmlElement(name="CuentaPredial")
    private CuentaPredial cuentaPredial;
    @XmlElement(name="ComplementoConcepto")
    private ComplementoConcepto complemento;
    @XmlElement(name="Parte")
    private List<Parte> parte;
    @XmlAttribute(required=true)
    private double cantidad;
    @XmlAttribute
    private String unidad;
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
        if(cuentaPredial == null)
            cuentaPredial = new CuentaPredial();
        return cuentaPredial;
    }

    public void setCuentaPredial(CuentaPredial cuentaPredial) {
        CuentaPredial oldCuentaPredial = this.cuentaPredial;
        this.cuentaPredial = cuentaPredial;
        propertyChangeSupport.firePropertyChange("cuentaPredial", oldCuentaPredial, cuentaPredial);
    }

    public List<InformacionAduanera> getInfoAduanera() {
        if(infoAduanera == null)
            infoAduanera = new ArrayList<InformacionAduanera>();
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
