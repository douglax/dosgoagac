/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alejandro.acosta
 */


@Entity
public class Licencia implements Serializable{

    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String folio;


    @Column(nullable = false)
    private Long autorizados;


    @Column(nullable = false)
    private Date fecha;


    @Column(nullable = false)
    private Long emitidos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = id;
    }

    public Long getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(Long autorizados) {
        this.autorizados = autorizados;
    }

    public Long getEmitidos() {
        return emitidos;
    }

    public void setEmitidos(Long emitidos) {
        this.emitidos = emitidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;

    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


}
