/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.Transient;


/**
 *
 * @author alex
 */
public class ExpedienteFolios implements Serializable {

    private List<Serie> series;

    public List<Serie> getSeries() {

        if (series == null) {
            series = new ArrayList<Serie>();
        }

        return series;
    }

    public void setSeries(List<Serie> series) {
        List<Serie> oldSeries = this.series;
        this.series = series;
        propertyChangeSupport.firePropertyChange("series",oldSeries, series);
    }

    public void addSerie(Serie serie){
        getSeries().add(serie);
        propertyChangeSupport.firePropertyChange("serie", null, serie);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        for(Serie s : getSeries()){
            s.addPropertyChangeListener(listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
        for(Serie s : getSeries()){
            s.removePropertyChangeListener(listener);
        }
    }
    @XmlTransient
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);


    private Emisor emisor;

    public Emisor getEmisor() {
        if (emisor == null) {
            emisor = new Emisor();
        }
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        Emisor oldEmisor = this.emisor;
        this.emisor = emisor;
        propertyChangeSupport.firePropertyChange("emisor", oldEmisor, emisor);
    }
}
