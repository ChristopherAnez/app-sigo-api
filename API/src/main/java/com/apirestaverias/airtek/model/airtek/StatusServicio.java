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
@Table(name = "status_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusServicio.findAll", query = "SELECT s FROM StatusServicio s"),
    @NamedQuery(name = "StatusServicio.findByIdStatusServicio", query = "SELECT s FROM StatusServicio s WHERE s.idStatusServicio = :idStatusServicio"),
    @NamedQuery(name = "StatusServicio.findByDescripcion", query = "SELECT s FROM StatusServicio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "StatusServicio.findByStatus", query = "SELECT s FROM StatusServicio s WHERE s.status = :status"),
    @NamedQuery(name = "StatusServicio.findByFechaRegistro", query = "SELECT s FROM StatusServicio s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "StatusServicio.findByFechaActualizacion", query = "SELECT s FROM StatusServicio s WHERE s.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "StatusServicio.findByUsuario", query = "SELECT s FROM StatusServicio s WHERE s.usuario = :usuario")})
public class StatusServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status_servicio")
    private Integer idStatusServicio;
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

    public StatusServicio() {
    }

    public StatusServicio(Integer idStatusServicio) {
        this.idStatusServicio = idStatusServicio;
    }

    public Integer getIdStatusServicio() {
        return idStatusServicio;
    }

    public void setIdStatusServicio(Integer idStatusServicio) {
        this.idStatusServicio = idStatusServicio;
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
        hash += (idStatusServicio != null ? idStatusServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusServicio)) {
            return false;
        }
        StatusServicio other = (StatusServicio) object;
        if ((this.idStatusServicio == null && other.idStatusServicio != null) || (this.idStatusServicio != null && !this.idStatusServicio.equals(other.idStatusServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.StatusServicio[ idStatusServicio=" + idStatusServicio + " ]";
    }
    
}
