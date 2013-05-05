/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adiaz
 */
@Entity
@Table(name = "prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findByIdPrueba", query = "SELECT p FROM Prueba p WHERE p.idPrueba = :idPrueba"),
    @NamedQuery(name = "Prueba.findByNombrePrueba", query = "SELECT p FROM Prueba p WHERE p.nombrePrueba = :nombrePrueba")})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_prueba")
    private String idPrueba;
    @Size(max = 2147483647)
    @Column(name = "nombre_prueba")
    private String nombrePrueba;

    public Prueba() {
    }

    public Prueba(String idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(String idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrueba != null ? idPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.idPrueba == null && other.idPrueba != null) || (this.idPrueba != null && !this.idPrueba.equals(other.idPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Prueba[ idPrueba=" + idPrueba + " ]";
    }
    
}
