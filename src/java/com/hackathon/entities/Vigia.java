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
 * @author PC COM
 */
@Entity
@Table(name = "vigia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vigia.findAll", query = "SELECT v FROM Vigia v"),
    @NamedQuery(name = "Vigia.findByCodigo", query = "SELECT v FROM Vigia v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Vigia.findByNombre", query = "SELECT v FROM Vigia v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vigia.findByEmail", query = "SELECT v FROM Vigia v WHERE v.email = :email")})
public class Vigia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;

    public Vigia() {
    }

    public Vigia(String codigo) {
        this.codigo = codigo;
    }

    public Vigia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vigia)) {
            return false;
        }
        Vigia other = (Vigia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Vigia[ codigo=" + codigo + " ]";
    }
    
}
