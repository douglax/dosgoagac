package com.agac.bo;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Carlos Aguirre
 */
@Embeddable
public class ArticuloPK implements Serializable {

    public ArticuloPK() {
    }

    public ArticuloPK(String identificador, Long emisor) {
        this.identificador = identificador;
        this.emisor_id = emisor;
    }
    private String identificador;    
    private Long emisor_id;

    public Long getEmisor_id() {
        return emisor_id;
    }

    public void setEmisor_id(Long emisor_id) {
        this.emisor_id = emisor_id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticuloPK other = (ArticuloPK) obj;
        if ((this.identificador == null) ? (other.identificador != null) : !this.identificador.equals(other.identificador)) {
            return false;
        }
        if (this.emisor_id != other.emisor_id && (this.emisor_id == null || !this.emisor_id.equals(other.emisor_id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.identificador != null ? this.identificador.hashCode() : 0);
        hash = 67 * hash + (this.emisor_id != null ? this.emisor_id.hashCode() : 0);
        return hash;
    }
    
}
