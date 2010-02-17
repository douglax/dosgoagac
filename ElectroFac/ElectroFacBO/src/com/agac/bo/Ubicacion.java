/*
 * Esta clase representa los tipos t_Ubicacion
 * Tipo definido para expresar domicilios o direcciones
 */

package com.agac.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_Ubicacion",
    propOrder={"calle", "noExterior", "noInterior", "colonia",
        "localidad","referencia","municipio", "estado", "pais",
        "codigoPostal"
    }
)
@Entity
public class Ubicacion implements Serializable {

    @XmlTransient
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlAttribute
    private String calle; //Opcional en TUbicacion Mandatorio en TUbicacionFiscal
    @XmlAttribute
    private String noExterior; //Opcional
    @XmlAttribute
    private String noInterior; //Opcional
    @XmlAttribute
    private String colonia; //Opcional
    @XmlAttribute
    private String localidad; //Opcional
    @XmlAttribute
    private String referencia; //Opcional
    @XmlAttribute
    private String municipio; //Opcional en TUbicacion Mandatorio en TUbicacionFiscal
    @XmlAttribute
    private String estado; //Opcional en TUbicacion Mandatorio en TUbicacionFiscal
    @XmlAttribute(required=true)
    @Column(nullable=false)
    private String pais; //Mandatorio
    @XmlAttribute
    private String codigoPostal; //Opcional en TUbicacion Mandatorio en TUbicacionFiscal

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
