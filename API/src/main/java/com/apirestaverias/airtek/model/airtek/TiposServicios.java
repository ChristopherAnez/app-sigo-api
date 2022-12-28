/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

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
 * @author e.colina
 */
@Entity
@Table(name = "tipos_servicios", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposServicios.findAll", query = "SELECT t FROM TiposServicios t"),
    @NamedQuery(name = "TiposServicios.findByIdTipoServicio", query = "SELECT t FROM TiposServicios t WHERE t.idTipoServicio = :idTipoServicio"),
    @NamedQuery(name = "TiposServicios.findByDescripcion", query = "SELECT t FROM TiposServicios t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposServicios.findByStatus", query = "SELECT t FROM TiposServicios t WHERE t.status = :status"),
    @NamedQuery(name = "TiposServicios.findByFechaRegistro", query = "SELECT t FROM TiposServicios t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TiposServicios.findByFechaActualizacion", query = "SELECT t FROM TiposServicios t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TiposServicios.findByUsuario", query = "SELECT t FROM TiposServicios t WHERE t.usuario = :usuario")})
public class TiposServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_servicio")
    private Integer idTipoServicio;
    @Size(max = 2147483647)
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

    public TiposServicios() {
    }

    public TiposServicios(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServicio != null ? idTipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposServicios)) {
            return false;
        }
        TiposServicios other = (TiposServicios) object;
        if ((this.idTipoServicio == null && other.idTipoServicio != null) || (this.idTipoServicio != null && !this.idTipoServicio.equals(other.idTipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.TiposServicios[ idTipoServicio=" + idTipoServicio + " ]";
    }
    
}
