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
@Table(name = "status_operacion", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusOperacion.findAll", query = "SELECT s FROM StatusOperacion s"),
    @NamedQuery(name = "StatusOperacion.findByIdStatusOp", query = "SELECT s FROM StatusOperacion s WHERE s.idStatusOp = :idStatusOp"),
    @NamedQuery(name = "StatusOperacion.findByIdTipoOperacion", query = "SELECT s FROM StatusOperacion s WHERE s.statusOperacionPK.idTipoOperacion = :idTipoOperacion"),
    @NamedQuery(name = "StatusOperacion.findByCodigoStatus", query = "SELECT s FROM StatusOperacion s WHERE s.statusOperacionPK.codigoStatus = :codigoStatus"),
    @NamedQuery(name = "StatusOperacion.findByDescripcion", query = "SELECT s FROM StatusOperacion s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "StatusOperacion.findByStatus", query = "SELECT s FROM StatusOperacion s WHERE s.status = :status"),
    @NamedQuery(name = "StatusOperacion.findByFechaRegistro", query = "SELECT s FROM StatusOperacion s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "StatusOperacion.findByFechaActualizacion", query = "SELECT s FROM StatusOperacion s WHERE s.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "StatusOperacion.findByUsuario", query = "SELECT s FROM StatusOperacion s WHERE s.usuario = :usuario")})
public class StatusOperacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StatusOperacionPK statusOperacionPK;
    @Basic(optional = false)
    @Column(name = "id_status_op")
    private int idStatusOp;
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
    @JoinColumn(name = "id_tipo_operacion", referencedColumnName = "id_tipo_operacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposOperaciones tiposOperaciones;

    public StatusOperacion() {
    }

    public StatusOperacion(StatusOperacionPK statusOperacionPK) {
        this.statusOperacionPK = statusOperacionPK;
    }

    public StatusOperacion(StatusOperacionPK statusOperacionPK, int idStatusOp) {
        this.statusOperacionPK = statusOperacionPK;
        this.idStatusOp = idStatusOp;
    }

    public StatusOperacion(int idTipoOperacion, int codigoStatus) {
        this.statusOperacionPK = new StatusOperacionPK(idTipoOperacion, codigoStatus);
    }

    public StatusOperacionPK getStatusOperacionPK() {
        return statusOperacionPK;
    }

    public void setStatusOperacionPK(StatusOperacionPK statusOperacionPK) {
        this.statusOperacionPK = statusOperacionPK;
    }

    public int getIdStatusOp() {
        return idStatusOp;
    }

    public void setIdStatusOp(int idStatusOp) {
        this.idStatusOp = idStatusOp;
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

    public TiposOperaciones getTiposOperaciones() {
        return tiposOperaciones;
    }

    public void setTiposOperaciones(TiposOperaciones tiposOperaciones) {
        this.tiposOperaciones = tiposOperaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusOperacionPK != null ? statusOperacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusOperacion)) {
            return false;
        }
        StatusOperacion other = (StatusOperacion) object;
        if ((this.statusOperacionPK == null && other.statusOperacionPK != null) || (this.statusOperacionPK != null && !this.statusOperacionPK.equals(other.statusOperacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.StatusOperacion[ statusOperacionPK=" + statusOperacionPK + " ]";
    }
    
}
