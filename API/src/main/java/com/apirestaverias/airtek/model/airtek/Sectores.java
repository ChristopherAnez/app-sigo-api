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
@Table(name = "sectores", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectores.findAll", query = "SELECT s FROM Sectores s"),
    @NamedQuery(name = "Sectores.findByIdSector", query = "SELECT s FROM Sectores s WHERE s.idSector = :idSector"),
    @NamedQuery(name = "Sectores.findByCodigoPais", query = "SELECT s FROM Sectores s WHERE s.sectoresPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Sectores.findByCodigoEstado", query = "SELECT s FROM Sectores s WHERE s.sectoresPK.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Sectores.findByCodigoMunicipio", query = "SELECT s FROM Sectores s WHERE s.sectoresPK.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Sectores.findByCodigoSector", query = "SELECT s FROM Sectores s WHERE s.sectoresPK.codigoSector = :codigoSector"),
    @NamedQuery(name = "Sectores.findByDescripcion", query = "SELECT s FROM Sectores s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sectores.findByStatus", query = "SELECT s FROM Sectores s WHERE s.status = :status"),
    @NamedQuery(name = "Sectores.findByFechaRegistro", query = "SELECT s FROM Sectores s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Sectores.findByFechaActualizacion", query = "SELECT s FROM Sectores s WHERE s.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Sectores.findByUsuario", query = "SELECT s FROM Sectores s WHERE s.usuario = :usuario")})
public class Sectores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectoresPK sectoresPK;
    @Basic(optional = false)
    @Column(name = "id_sector")
    private int idSector;
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
        @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_municipio", referencedColumnName = "codigo_municipio", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Municipios municipios;

    public Sectores() {
    }

    public Sectores(SectoresPK sectoresPK) {
        this.sectoresPK = sectoresPK;
    }

    public Sectores(SectoresPK sectoresPK, int idSector) {
        this.sectoresPK = sectoresPK;
        this.idSector = idSector;
    }

    public Sectores(short codigoPais, short codigoEstado, short codigoMunicipio, int codigoSector) {
        this.sectoresPK = new SectoresPK(codigoPais, codigoEstado, codigoMunicipio, codigoSector);
    }

    public SectoresPK getSectoresPK() {
        return sectoresPK;
    }

    public void setSectoresPK(SectoresPK sectoresPK) {
        this.sectoresPK = sectoresPK;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
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

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectoresPK != null ? sectoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectores)) {
            return false;
        }
        Sectores other = (Sectores) object;
        if ((this.sectoresPK == null && other.sectoresPK != null) || (this.sectoresPK != null && !this.sectoresPK.equals(other.sectoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Sectores[ sectoresPK=" + sectoresPK + " ]";
    }
    
}
