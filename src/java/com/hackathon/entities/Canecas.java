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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "canecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canecas.findAll", query = "SELECT c FROM Canecas c"),
    @NamedQuery(name = "Canecas.findByGid", query = "SELECT c FROM Canecas c WHERE c.gid = :gid"),
    @NamedQuery(name = "Canecas.findByCoorx", query = "SELECT c FROM Canecas c WHERE c.coorx = :coorx"),
    @NamedQuery(name = "Canecas.findByCoory", query = "SELECT c FROM Canecas c WHERE c.coory = :coory"),
    @NamedQuery(name = "Canecas.findByEjDirec", query = "SELECT c FROM Canecas c WHERE c.ejDirec = :ejDirec"),
    @NamedQuery(name = "Canecas.findByEjId", query = "SELECT c FROM Canecas c WHERE c.ejId = :ejId"),
    @NamedQuery(name = "Canecas.findByEjeDirec", query = "SELECT c FROM Canecas c WHERE c.ejeDirec = :ejeDirec"),
    @NamedQuery(name = "Canecas.findByFecha", query = "SELECT c FROM Canecas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Canecas.findByFid", query = "SELECT c FROM Canecas c WHERE c.fid = :fid"),
    @NamedQuery(name = "Canecas.findByIdmuni", query = "SELECT c FROM Canecas c WHERE c.idmuni = :idmuni"),
    @NamedQuery(name = "Canecas.findByIdmuni1", query = "SELECT c FROM Canecas c WHERE c.idmuni1 = :idmuni1"),
    @NamedQuery(name = "Canecas.findByLocaizaci", query = "SELECT c FROM Canecas c WHERE c.locaizaci = :locaizaci"),
    @NamedQuery(name = "Canecas.findByLogo", query = "SELECT c FROM Canecas c WHERE c.logo = :logo"),
    @NamedQuery(name = "Canecas.findByNovedad", query = "SELECT c FROM Canecas c WHERE c.novedad = :novedad"),
    @NamedQuery(name = "Canecas.findByRemisiN", query = "SELECT c FROM Canecas c WHERE c.remisiN = :remisiN"),
    @NamedQuery(name = "Canecas.findByShapeLeng", query = "SELECT c FROM Canecas c WHERE c.shapeLeng = :shapeLeng"),
    @NamedQuery(name = "Canecas.findByTheGeom", query = "SELECT c FROM Canecas c WHERE c.theGeom = :theGeom"),
    @NamedQuery(name = "Canecas.findByTipoDeCa", query = "SELECT c FROM Canecas c WHERE c.tipoDeCa = :tipoDeCa")})
public class Canecas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coorx")
    private Double coorx;
    @Column(name = "coory")
    private Double coory;
    @Size(max = 255)
    @Column(name = "ej_direc")
    private String ejDirec;
    @Column(name = "ej_id")
    private Double ejId;
    @Size(max = 255)
    @Column(name = "eje_direc")
    private String ejeDirec;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fid_")
    private Double fid;
    @Size(max = 255)
    @Column(name = "idmuni")
    private String idmuni;
    @Size(max = 255)
    @Column(name = "idmuni_1")
    private String idmuni1;
    @Size(max = 255)
    @Column(name = "locaizaci_")
    private String locaizaci;
    @Size(max = 255)
    @Column(name = "logo")
    private String logo;
    @Size(max = 255)
    @Column(name = "novedad")
    private String novedad;
    @Column(name = "remisi_n")
    private Double remisiN;
    @Column(name = "shape_leng")
    private Double shapeLeng;
    @Size(max = 2147483647)
    @Column(name = "the_geom")
    private String theGeom;
    @Size(max = 255)
    @Column(name = "tipo_de_ca")
    private String tipoDeCa;

    public Canecas() {
    }

    public Canecas(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Double getCoorx() {
        return coorx;
    }

    public void setCoorx(Double coorx) {
        this.coorx = coorx;
    }

    public Double getCoory() {
        return coory;
    }

    public void setCoory(Double coory) {
        this.coory = coory;
    }

    public String getEjDirec() {
        return ejDirec;
    }

    public void setEjDirec(String ejDirec) {
        this.ejDirec = ejDirec;
    }

    public Double getEjId() {
        return ejId;
    }

    public void setEjId(Double ejId) {
        this.ejId = ejId;
    }

    public String getEjeDirec() {
        return ejeDirec;
    }

    public void setEjeDirec(String ejeDirec) {
        this.ejeDirec = ejeDirec;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getFid() {
        return fid;
    }

    public void setFid(Double fid) {
        this.fid = fid;
    }

    public String getIdmuni() {
        return idmuni;
    }

    public void setIdmuni(String idmuni) {
        this.idmuni = idmuni;
    }

    public String getIdmuni1() {
        return idmuni1;
    }

    public void setIdmuni1(String idmuni1) {
        this.idmuni1 = idmuni1;
    }

    public String getLocaizaci() {
        return locaizaci;
    }

    public void setLocaizaci(String locaizaci) {
        this.locaizaci = locaizaci;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Double getRemisiN() {
        return remisiN;
    }

    public void setRemisiN(Double remisiN) {
        this.remisiN = remisiN;
    }

    public Double getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(Double shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public String getTheGeom() {
        return theGeom;
    }

    public void setTheGeom(String theGeom) {
        this.theGeom = theGeom;
    }

    public String getTipoDeCa() {
        return tipoDeCa;
    }

    public void setTipoDeCa(String tipoDeCa) {
        this.tipoDeCa = tipoDeCa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canecas)) {
            return false;
        }
        Canecas other = (Canecas) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.entities.Canecas[ gid=" + gid + " ]";
    }
    
}
