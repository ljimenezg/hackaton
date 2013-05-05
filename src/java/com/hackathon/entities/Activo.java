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
import javax.persistence.Lob;
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
@Table(name = "activo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a"),
    @NamedQuery(name = "Activo.findByCodigo", query = "SELECT a FROM Activo a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Activo.findByLon", query = "SELECT a FROM Activo a WHERE a.lon = :lon"),
    @NamedQuery(name = "Activo.findByLat", query = "SELECT a FROM Activo a WHERE a.lat = :lat"),
    @NamedQuery(name = "Activo.findByCodCategoria", query = "SELECT a FROM Activo a WHERE a.codCategoria = :codCategoria"),
    @NamedQuery(name = "Activo.findByDireccion", query = "SELECT a FROM Activo a WHERE a.direccion = :direccion")})
public class Activo implements Serializable {
    @Lob
    @Column(name = "the_geom")
    private String theGeom;
    @Size(max = 2000)
    @Column(name = "foto")
    private String foto;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lon")
    private Double lon;
    @Column(name = "lat")
    private Double lat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_categoria")
    private String codCategoria;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;

    public Activo() {
    }

    public Activo(String codigo) {
        this.codigo = codigo;
    }

    public Activo(String codigo, String codCategoria) {
        this.codigo = codigo;
        this.codCategoria = codCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTheGeom() {
        return theGeom;
    }

    public void setTheGeom(String theGeom) {
        this.theGeom = theGeom;
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
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Activo[ codigo=" + codigo + " ]";
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
