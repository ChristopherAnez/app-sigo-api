/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "municipios", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIdCiudad", query = "SELECT m FROM Municipios m WHERE m.idCiudad = :idCiudad"),
    @NamedQuery(name = "Municipios.findByCodigoPais", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Municipios.findByCodigoEstado", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Municipios.findByCodigoMunicipio", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Municipios.findByDescripcion", query = "SELECT m FROM Municipios m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Municipios.findByStatus", query = "SELECT m FROM Municipios m WHERE m.status = :status"),
    @NamedQuery(name = "Municipios.findByFechaRegistro", query = "SELECT m FROM Municipios m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Municipios.findByFechaActualizacion", query = "SELECT m FROM Municipios m WHERE m.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Municipios.findByUsuario", query = "SELECT m FROM Municipios m WHERE m.usuario = :usuario")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipiosPK municipiosPK;
    @Basic(optional = false)
    @Column(name = "id_ciudad")
    private int idCiudad;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumns({
        @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Estados estados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipios")
    private List<Sucursales> sucursalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipios")
    private List<Sectores> sectoresList;

    public Municipios() {
    }

    public Municipios(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public Municipios(MunicipiosPK municipiosPK, int idCiudad) {
        this.municipiosPK = municipiosPK;
        this.idCiudad = idCiudad;
    }

    public Municipios(short codigoPais, short codigoEstado, short codigoMunicipio) {
        this.municipiosPK = new MunicipiosPK(codigoPais, codigoEstado, codigoMunicipio);
    }

    public MunicipiosPK getMunicipiosPK() {
        return municipiosPK;
    }

    public void setMunicipiosPK(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    @XmlTransient
    public List<Sucursales> getSucursalesList() {
        return sucursalesList;
    }

    public void setSucursalesList(List<Sucursales> sucursalesList) {
        this.sucursalesList = sucursalesList;
    }

    @XmlTransient
    public List<Sectores> getSectoresList() {
        return sectoresList;
    }

    public void setSectoresList(List<Sectores> sectoresList) {
        this.sectoresList = sectoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipiosPK != null ? municipiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.municipiosPK == null && other.municipiosPK != null) || (this.municipiosPK != null && !this.municipiosPK.equals(other.municipiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Municipios[ municipiosPK=" + municipiosPK + " ]";
    }
    
}
