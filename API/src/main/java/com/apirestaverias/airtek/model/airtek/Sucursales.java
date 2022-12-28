/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "sucursales", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findByIdSucursal", query = "SELECT s FROM Sucursales s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursales.findByCodigoPais", query = "SELECT s FROM Sucursales s WHERE s.sucursalesPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Sucursales.findByCodigoEstado", query = "SELECT s FROM Sucursales s WHERE s.sucursalesPK.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Sucursales.findByCodigoMunicipio", query = "SELECT s FROM Sucursales s WHERE s.sucursalesPK.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Sucursales.findByCodigoSucursal", query = "SELECT s FROM Sucursales s WHERE s.sucursalesPK.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "Sucursales.findByDescripcion", query = "SELECT s FROM Sucursales s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sucursales.findByStatus", query = "SELECT s FROM Sucursales s WHERE s.status = :status"),
    @NamedQuery(name = "Sucursales.findBySucursalOld", query = "SELECT s FROM Sucursales s WHERE s.sucursalOld = :sucursalOld"),
    @NamedQuery(name = "Sucursales.findByAbreviatura", query = "SELECT s FROM Sucursales s WHERE s.abreviatura = :abreviatura"),
    @NamedQuery(name = "Sucursales.findByFechaRegistro", query = "SELECT s FROM Sucursales s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Sucursales.findByFechaSucursal", query = "SELECT s FROM Sucursales s WHERE s.fechaSucursal = :fechaSucursal"),
    @NamedQuery(name = "Sucursales.findByUsuario", query = "SELECT s FROM Sucursales s WHERE s.usuario = :usuario")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SucursalesPK sucursalesPK;
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private int idSucursal;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @Column(name = "sucursal_old")
    private Short sucursalOld;
    @Size(max = 3)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_sucursal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSucursal;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumns({
        @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_municipio", referencedColumnName = "codigo_municipio", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Municipios municipios;

    public Sucursales() {
    }

    public Sucursales(SucursalesPK sucursalesPK) {
        this.sucursalesPK = sucursalesPK;
    }

    public Sucursales(SucursalesPK sucursalesPK, int idSucursal) {
        this.sucursalesPK = sucursalesPK;
        this.idSucursal = idSucursal;
    }

    public Sucursales(short codigoPais, short codigoEstado, short codigoMunicipio, short codigoSucursal) {
        this.sucursalesPK = new SucursalesPK(codigoPais, codigoEstado, codigoMunicipio, codigoSucursal);
    }

    public SucursalesPK getSucursalesPK() {
        return sucursalesPK;
    }

    public void setSucursalesPK(SucursalesPK sucursalesPK) {
        this.sucursalesPK = sucursalesPK;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getSucursalOld() {
        return sucursalOld;
    }

    public void setSucursalOld(Short sucursalOld) {
        this.sucursalOld = sucursalOld;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaSucursal() {
        return fechaSucursal;
    }

    public void setFechaSucursal(Date fechaSucursal) {
        this.fechaSucursal = fechaSucursal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalesPK != null ? sucursalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.sucursalesPK == null && other.sucursalesPK != null) || (this.sucursalesPK != null && !this.sucursalesPK.equals(other.sucursalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Sucursales[ sucursalesPK=" + sucursalesPK + " ]";
    }
    
}
