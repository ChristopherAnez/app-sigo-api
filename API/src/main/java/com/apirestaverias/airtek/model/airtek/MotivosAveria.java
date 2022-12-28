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
@Table(name = "motivos_averia", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivosAveria.findAll", query = "SELECT m FROM MotivosAveria m"),
    @NamedQuery(name = "MotivosAveria.findByIdMotivoAveria", query = "SELECT m FROM MotivosAveria m WHERE m.idMotivoAveria = :idMotivoAveria"),
    @NamedQuery(name = "MotivosAveria.findByDescripcion", query = "SELECT m FROM MotivosAveria m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MotivosAveria.findByStatus", query = "SELECT m FROM MotivosAveria m WHERE m.status = :status"),
    @NamedQuery(name = "MotivosAveria.findByFechaRegistro", query = "SELECT m FROM MotivosAveria m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "MotivosAveria.findByFechaActualizacion", query = "SELECT m FROM MotivosAveria m WHERE m.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "MotivosAveria.findByUsuario", query = "SELECT m FROM MotivosAveria m WHERE m.usuario = :usuario")})
public class MotivosAveria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo_averia")
    private Integer idMotivoAveria;
    @Size(max = 100)
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

    public MotivosAveria() {
    }

    public MotivosAveria(Integer idMotivoAveria) {
        this.idMotivoAveria = idMotivoAveria;
    }

    public Integer getIdMotivoAveria() {
        return idMotivoAveria;
    }

    public void setIdMotivoAveria(Integer idMotivoAveria) {
        this.idMotivoAveria = idMotivoAveria;
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
        hash += (idMotivoAveria != null ? idMotivoAveria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivosAveria)) {
            return false;
        }
        MotivosAveria other = (MotivosAveria) object;
        if ((this.idMotivoAveria == null && other.idMotivoAveria != null) || (this.idMotivoAveria != null && !this.idMotivoAveria.equals(other.idMotivoAveria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.MotivosAveria[ idMotivoAveria=" + idMotivoAveria + " ]";
    }
    
}
