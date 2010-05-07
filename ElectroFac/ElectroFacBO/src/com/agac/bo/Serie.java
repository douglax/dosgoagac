/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.bo;

import java.io.Serializable;
import java.math.BigInteger;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alex
 */
@Entity
public class Serie implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    private String numSerie;
    private BigInteger folioInicial;
    private BigInteger folioFinal;
    private String numAutorización;
    private int anoAprob;
    @XmlTransient
    private boolean activa = true;
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getAnoAprob() {
        return anoAprob;
    }

    public void setAnoAprob(int anoAprob) {
        this.anoAprob = anoAprob;
    }

    public BigInteger getFolioFinal() {
        return folioFinal;
    }

    public void setFolioFinal(BigInteger folioFinal) {
        this.folioFinal = folioFinal;
    }

    public BigInteger getFolioInicial() {
        return folioInicial;
    }

    public void setFolioInicial(BigInteger folioInicial) {
        this.folioInicial = folioInicial;
    }

    public String getNumAutorización() {
        return numAutorización;
    }

    public void setNumAutorización(String numAutorización) {
        this.numAutorización = numAutorización;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Serie other = (Serie) obj;
        if (this.Id != other.Id && (this.Id == null || !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.Id != null ? this.Id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return numSerie;
    }

}
