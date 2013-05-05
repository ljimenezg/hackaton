/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByLon", query = "SELECT r FROM Reporte r WHERE r.lon = :lon"),
    @NamedQuery(name = "Reporte.findByLat", query = "SELECT r FROM Reporte r WHERE r.lat = :lat"),
    @NamedQuery(name = "Reporte.findByObservacion", query = "SELECT r FROM Reporte r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "Reporte.findByFoto", query = "SELECT r FROM Reporte r WHERE r.foto = :foto"),
    @NamedQuery(name = "Reporte.findByFecha", query = "SELECT r FROM Reporte r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Reporte.findByCodVigia", query = "SELECT r FROM Reporte r WHERE r.codVigia = :codVigia"),
    @NamedQuery(name = "Reporte.findByCodigo", query = "SELECT r FROM Reporte r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Reporte.findByCodActivo", query = "SELECT r FROM Reporte r WHERE r.codActivo = :codActivo")})
public class Reporte implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lon")
    private Double lon;
    @Column(name = "lat")
    private Double lat;
    @Size(max = 400)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_vigia")
    private String codVigia;
    @Id
    
    @Basic(optional = false)
    @Column(name = "codigo")
    @SequenceGenerator(name = "SEQ_REPORTE", sequenceName = "SEQ_REPORTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REPORTE")
    private Integer codigo;
    @Column(name = "cod_activo")
    private Integer codActivo;

    public Reporte() {
    }

    public Reporte(Integer codigo) {
        this.codigo = codigo;
    }

    public Reporte(Integer codigo, String foto, Date fecha, String codVigia) {
        this.codigo = codigo;
        this.foto = foto;
        this.fecha = fecha;
        this.codVigia = codVigia;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodVigia() {
        return codVigia;
    }

    public void setCodVigia(String codVigia) {
        this.codVigia = codVigia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodActivo() {
        return codActivo;
    }

    public void setCodActivo(Integer codActivo) {
        this.codActivo = codActivo;
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
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Reporte[ codigo=" + codigo + " ]";
    }
    
}
