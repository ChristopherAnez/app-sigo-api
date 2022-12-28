/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.operaciones;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "operaciones_cuadrillas", schema = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionesCuadrillas.findAll", query = "SELECT o FROM OperacionesCuadrillas o"),
    @NamedQuery(name = "OperacionesCuadrillas.findByIdOperacionCuadrilla", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.idOperacionCuadrilla = :idOperacionCuadrilla"),
    @NamedQuery(name = "OperacionesCuadrillas.findByIdCuadrilla", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.idCuadrilla = :idCuadrilla"),
    @NamedQuery(name = "OperacionesCuadrillas.findByIdTecnico", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.idTecnico = :idTecnico"),
    @NamedQuery(name = "OperacionesCuadrillas.findByTipoTecnico", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.tipoTecnico = :tipoTecnico"),
    @NamedQuery(name = "OperacionesCuadrillas.findByStatus", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.status = :status"),
    @NamedQuery(name = "OperacionesCuadrillas.findByCalificacion", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.calificacion = :calificacion"),
    @NamedQuery(name = "OperacionesCuadrillas.findByFechaRegistro", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OperacionesCuadrillas.findByFechaActualizacion", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "OperacionesCuadrillas.findByUsuario", query = "SELECT o FROM OperacionesCuadrillas o WHERE o.usuario = :usuario")})
public class OperacionesCuadrillas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion_cuadrilla")
    private Integer idOperacionCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuadrilla")
    private int idCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tecnico")
    private int idTecnico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_tecnico")
    private int tipoTecnico;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private BigDecimal calificacion;
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
    @OneToOne(optional = false)
    private Operaciones idOperacion;

    public OperacionesCuadrillas() {
    }

    public OperacionesCuadrillas(Integer idOperacionCuadrilla) {
        this.idOperacionCuadrilla = idOperacionCuadrilla;
    }

    public OperacionesCuadrillas(Integer idOperacionCuadrilla, int idCuadrilla, int idTecnico, int tipoTecnico) {
        this.idOperacionCuadrilla = idOperacionCuadrilla;
        this.idCuadrilla = idCuadrilla;
        this.idTecnico = idTecnico;
        this.tipoTecnico = tipoTecnico;
    }

    public Integer getIdOperacionCuadrilla() {
        return idOperacionCuadrilla;
    }

    public void setIdOperacionCuadrilla(Integer idOperacionCuadrilla) {
        this.idOperacionCuadrilla = idOperacionCuadrilla;
    }

    public int getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(int idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(int tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
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
        hash += (idOperacionCuadrilla != null ? idOperacionCuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionesCuadrillas)) {
            return false;
        }
        OperacionesCuadrillas other = (OperacionesCuadrillas) object;
        if ((this.idOperacionCuadrilla == null && other.idOperacionCuadrilla != null) || (this.idOperacionCuadrilla != null && !this.idOperacionCuadrilla.equals(other.idOperacionCuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.operaciones.OperacionesCuadrillas[ idOperacionCuadrilla=" + idOperacionCuadrilla + " ]";
    }
    
}
