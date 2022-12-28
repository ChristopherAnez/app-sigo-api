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
@Table(name = "urgencias", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urgencias.findAll", query = "SELECT u FROM Urgencias u"),
    @NamedQuery(name = "Urgencias.findByIdUrgencia", query = "SELECT u FROM Urgencias u WHERE u.idUrgencia = :idUrgencia"),
    @NamedQuery(name = "Urgencias.findByDescripcion", query = "SELECT u FROM Urgencias u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Urgencias.findByStatus", query = "SELECT u FROM Urgencias u WHERE u.status = :status"),
    @NamedQuery(name = "Urgencias.findByFechaRegistro", query = "SELECT u FROM Urgencias u WHERE u.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Urgencias.findByFechaActualizacion", query = "SELECT u FROM Urgencias u WHERE u.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Urgencias.findByUsuario", query = "SELECT u FROM Urgencias u WHERE u.usuario = :usuario")})
public class Urgencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_urgencia")
    private Integer idUrgencia;
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

    public Urgencias() {
    }

    public Urgencias(Integer idUrgencia) {
        this.idUrgencia = idUrgencia;
    }

    public Integer getIdUrgencia() {
        return idUrgencia;
    }

    public void setIdUrgencia(Integer idUrgencia) {
        this.idUrgencia = idUrgencia;
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
        hash += (idUrgencia != null ? idUrgencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urgencias)) {
            return false;
        }
        Urgencias other = (Urgencias) object;
        if ((this.idUrgencia == null && other.idUrgencia != null) || (this.idUrgencia != null && !this.idUrgencia.equals(other.idUrgencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Urgencias[ idUrgencia=" + idUrgencia + " ]";
    }
    
}
