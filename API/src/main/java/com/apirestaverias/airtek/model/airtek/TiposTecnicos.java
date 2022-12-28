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
@Table(name = "tipos_tecnicos", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposTecnicos.findAll", query = "SELECT t FROM TiposTecnicos t"),
    @NamedQuery(name = "TiposTecnicos.findByIdTipoTecnico", query = "SELECT t FROM TiposTecnicos t WHERE t.idTipoTecnico = :idTipoTecnico"),
    @NamedQuery(name = "TiposTecnicos.findByDescripcion", query = "SELECT t FROM TiposTecnicos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposTecnicos.findByStatus", query = "SELECT t FROM TiposTecnicos t WHERE t.status = :status"),
    @NamedQuery(name = "TiposTecnicos.findByFechaRegistro", query = "SELECT t FROM TiposTecnicos t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TiposTecnicos.findByFechaActualizacion", query = "SELECT t FROM TiposTecnicos t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TiposTecnicos.findByUsuario", query = "SELECT t FROM TiposTecnicos t WHERE t.usuario = :usuario")})
public class TiposTecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_tecnico")
    private Integer idTipoTecnico;
    @Size(max = 30)
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

    public TiposTecnicos() {
    }

    public TiposTecnicos(Integer idTipoTecnico) {
        this.idTipoTecnico = idTipoTecnico;
    }

    public Integer getIdTipoTecnico() {
        return idTipoTecnico;
    }

    public void setIdTipoTecnico(Integer idTipoTecnico) {
        this.idTipoTecnico = idTipoTecnico;
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
        hash += (idTipoTecnico != null ? idTipoTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposTecnicos)) {
            return false;
        }
        TiposTecnicos other = (TiposTecnicos) object;
        if ((this.idTipoTecnico == null && other.idTipoTecnico != null) || (this.idTipoTecnico != null && !this.idTipoTecnico.equals(other.idTipoTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.TiposTecnicos[ idTipoTecnico=" + idTipoTecnico + " ]";
    }
    
}
