/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.operaciones;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "operaciones_status", schema = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionesStatus.findAll", query = "SELECT o FROM OperacionesStatus o"),
    @NamedQuery(name = "OperacionesStatus.findByIdOperacionStatus", query = "SELECT o FROM OperacionesStatus o WHERE o.idOperacionStatus = :idOperacionStatus"),
    @NamedQuery(name = "OperacionesStatus.findByCodigoStatus", query = "SELECT o FROM OperacionesStatus o WHERE o.codigoStatus = :codigoStatus"),
    @NamedQuery(name = "OperacionesStatus.findByFecha", query = "SELECT o FROM OperacionesStatus o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "OperacionesStatus.findByComentarios", query = "SELECT o FROM OperacionesStatus o WHERE o.comentarios = :comentarios"),
    @NamedQuery(name = "OperacionesStatus.findByFechaRegistro", query = "SELECT o FROM OperacionesStatus o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OperacionesStatus.findByFechaActualizacion", query = "SELECT o FROM OperacionesStatus o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "OperacionesStatus.findByUsuario", query = "SELECT o FROM OperacionesStatus o WHERE o.usuario = :usuario")})
public class OperacionesStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion_status")
    private Integer idOperacionStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_status")
    private int codigoStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "id_operacion", referencedColumnName = "id_operacion")
    @ManyToOne(optional = false)
    private Operaciones idOperacion;

    public OperacionesStatus() {
    }

    public OperacionesStatus(Integer idOperacionStatus) {
        this.idOperacionStatus = idOperacionStatus;
    }

    public OperacionesStatus(Integer idOperacionStatus, int codigoStatus, Date fecha) {
        this.idOperacionStatus = idOperacionStatus;
        this.codigoStatus = codigoStatus;
        this.fecha = fecha;
    }

    public Integer getIdOperacionStatus() {
        return idOperacionStatus;
    }

    public void setIdOperacionStatus(Integer idOperacionStatus) {
        this.idOperacionStatus = idOperacionStatus;
    }

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(int codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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

    public Operaciones getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Operaciones idOperacion) {
        this.idOperacion = idOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacionStatus != null ? idOperacionStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionesStatus)) {
            return false;
        }
        OperacionesStatus other = (OperacionesStatus) object;
        if ((this.idOperacionStatus == null && other.idOperacionStatus != null) || (this.idOperacionStatus != null && !this.idOperacionStatus.equals(other.idOperacionStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.operaciones.OperacionesStatus[ idOperacionStatus=" + idOperacionStatus + " ]";
    }
    
}
