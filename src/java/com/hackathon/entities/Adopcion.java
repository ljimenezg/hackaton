/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC COM
 */
@Entity
@Table(name = "adopcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adopcion.findAll", query = "SELECT a FROM Adopcion a"),
    @NamedQuery(name = "Adopcion.findByCodActivo", query = "SELECT a FROM Adopcion a WHERE a.adopcionPK.codActivo = :codActivo"),
    @NamedQuery(name = "Adopcion.findByCodVigia", query = "SELECT a FROM Adopcion a WHERE a.adopcionPK.codVigia = :codVigia")})
public class Adopcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdopcionPK adopcionPK;

    public Adopcion() {
    }

    public Adopcion(AdopcionPK adopcionPK) {
        this.adopcionPK = adopcionPK;
    }

    public Adopcion(String codActivo, String codVigia) {
        this.adopcionPK = new AdopcionPK(codActivo, codVigia);
    }

    public AdopcionPK getAdopcionPK() {
        return adopcionPK;
    }

    public void setAdopcionPK(AdopcionPK adopcionPK) {
        this.adopcionPK = adopcionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adopcionPK != null ? adopcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adopcion)) {
            return false;
        }
        Adopcion other = (Adopcion) object;
        if ((this.adopcionPK == null && other.adopcionPK != null) || (this.adopcionPK != null && !this.adopcionPK.equals(other.adopcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Adopcion[ adopcionPK=" + adopcionPK + " ]";
    }
    
}
