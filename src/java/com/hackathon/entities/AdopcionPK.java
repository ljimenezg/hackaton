/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC COM
 */
@Embeddable
public class AdopcionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_activo")
    private String codActivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_vigia")
    private String codVigia;

    public AdopcionPK() {
    }

    public AdopcionPK(String codActivo, String codVigia) {
        this.codActivo = codActivo;
        this.codVigia = codVigia;
    }

    public String getCodActivo() {
        return codActivo;
    }

    public void setCodActivo(String codActivo) {
        this.codActivo = codActivo;
    }

    public String getCodVigia() {
        return codVigia;
    }

    public void setCodVigia(String codVigia) {
        this.codVigia = codVigia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codActivo != null ? codActivo.hashCode() : 0);
        hash += (codVigia != null ? codVigia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdopcionPK)) {
            return false;
        }
        AdopcionPK other = (AdopcionPK) object;
        if ((this.codActivo == null && other.codActivo != null) || (this.codActivo != null && !this.codActivo.equals(other.codActivo))) {
            return false;
        }
        if ((this.codVigia == null && other.codVigia != null) || (this.codVigia != null && !this.codVigia.equals(other.codVigia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.AdopcionPK[ codActivo=" + codActivo + ", codVigia=" + codVigia + " ]";
    }
    
}
