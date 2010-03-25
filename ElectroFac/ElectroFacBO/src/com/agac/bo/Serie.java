/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.io.Serializable;
import java.math.BigInteger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author alex
 */


public class Serie implements Serializable {





    private String numSerie;
    private BigInteger folioInicial;
    private BigInteger folioFinal;
    private String numAutorización;
    private int anoAprob;

    //private Emisor emisor;


//        public Emisor getEmisor() {
//        if (emisor == null) {
//            emisor = new Emisor();
//        }
//        return emisor;
//    }
//
//    public void setEmisor(Emisor emisor) {
//        //Emisor oldEmisor = this.emisor;
//        this.emisor = emisor;
//        //propertyChangeSupport.firePropertyChange("emisor", oldEmisor, emisor);
//    }


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


}
