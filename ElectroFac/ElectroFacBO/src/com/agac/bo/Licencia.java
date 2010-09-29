/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro.acosta
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Licencia implements Serializable{

    //
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @XmlAttribute(name = "folio", required = true)
    @Column(nullable = false)
    private String folio;



    @XmlAttribute(name = "autorizados", required = true)
    @Column(nullable = false)
    private int autorizados;

    @XmlAttribute(name = "fecha", required = true)
    @Column(nullable = false)
    private Date fecha;

    @XmlAttribute(name = "emitidos", required = true)
    @Column(nullable = false)
    private int emitidos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public int getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(int autorizados) {
        int oldAut = autorizados;
        this.autorizados = autorizados;
        propertyChangeSupport.firePropertyChange("autorizados", oldAut, autorizados);
    }

    public int getEmitidos() {
        return emitidos;
    }

    public void setEmitidos(int emitidos) {
        int oldEmi = emitidos;
        this.emitidos = emitidos;
        propertyChangeSupport.firePropertyChange("emitidos", oldEmi, emitidos);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = fecha;
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        String oldFolio = folio;
        this.folio = folio;
        propertyChangeSupport.firePropertyChange("folio",oldFolio,folio);
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
