/*
 * Nodo opcional para expresar las partes o componentes que integran la
 * totalidad del concepto expresado en el comprobante fiscal digital
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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Carlos Aguirre 13 Feb 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Parte {

    @XmlElement(name="InformacionAduanera")
    private List<InformacionAduanera> infoAduanera;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute(required=true)
    private BigDecimal cantidad;
    @XmlAttribute
    private String unidad;
    @XmlAttribute
    private String noIdentificacion;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
    private BigDecimal valorUnitario;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlAttribute
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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        BigDecimal oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        propertyChangeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
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
