/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.io.Serializable;
import java.math.BigInteger;

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





}
