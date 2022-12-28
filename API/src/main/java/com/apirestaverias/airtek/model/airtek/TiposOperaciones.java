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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipos_operaciones", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposOperaciones.findAll", query = "SELECT t FROM TiposOperaciones t"),
    @NamedQuery(name = "TiposOperaciones.findByIdTipoOperacion", query = "SELECT t FROM TiposOperaciones t WHERE t.idTipoOperacion = :idTipoOperacion"),
    @NamedQuery(name = "TiposOperaciones.findByDescripcion", query = "SELECT t FROM TiposOperaciones t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposOperaciones.findByStatus", query = "SELECT t FROM TiposOperaciones t WHERE t.status = :status"),
    @NamedQuery(name = "TiposOperaciones.findByFechaRegistro", query = "SELECT t FROM TiposOperaciones t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TiposOperaciones.findByFechaActualizacion", query = "SELECT t FROM TiposOperaciones t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TiposOperaciones.findByUsuario", query = "SELECT t FROM TiposOperaciones t WHERE t.usuario = :usuario")})
public class TiposOperaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_operacion")
    private Integer idTipoOperacion;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "status")
    private Short status;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposOperaciones")
    private List<StatusOperacion> statusOperacionList;

    public TiposOperaciones() {
    }

    public TiposOperaciones(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public Integer getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
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

    @XmlTransient
    public List<StatusOperacion> getStatusOperacionList() {
        return statusOperacionList;
    }

    public void setStatusOperacionList(List<StatusOperacion> statusOperacionList) {
        this.statusOperacionList = statusOperacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOperacion != null ? idTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposOperaciones)) {
            return false;
        }
        TiposOperaciones other = (TiposOperaciones) object;
        if ((this.idTipoOperacion == null && other.idTipoOperacion != null) || (this.idTipoOperacion != null && !this.idTipoOperacion.equals(other.idTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.TiposOperaciones[ idTipoOperacion=" + idTipoOperacion + " ]";
    }
    
}
