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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "cuadrillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuadrillas.findAll", query = "SELECT c FROM Cuadrillas c"),
    @NamedQuery(name = "Cuadrillas.findByIdCuadrilla", query = "SELECT c FROM Cuadrillas c WHERE c.idCuadrilla = :idCuadrilla"),
    @NamedQuery(name = "Cuadrillas.findByCodigoCuadrilla", query = "SELECT c FROM Cuadrillas c WHERE c.codigoCuadrilla = :codigoCuadrilla"),
    @NamedQuery(name = "Cuadrillas.findByDescripcion", query = "SELECT c FROM Cuadrillas c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuadrillas.findByStatus", query = "SELECT c FROM Cuadrillas c WHERE c.status = :status"),
    @NamedQuery(name = "Cuadrillas.findByFechaRegistro", query = "SELECT c FROM Cuadrillas c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Cuadrillas.findByFechaActualizacion", query = "SELECT c FROM Cuadrillas c WHERE c.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Cuadrillas.findByUsuario", query = "SELECT c FROM Cuadrillas c WHERE c.usuario = :usuario")})
public class Cuadrillas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuadrilla")
    private Integer idCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_cuadrilla")
    private int codigoCuadrilla;
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

    public Cuadrillas() {
    }

    public Cuadrillas(Integer idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public Cuadrillas(Integer idCuadrilla, int codigoCuadrilla) {
        this.idCuadrilla = idCuadrilla;
        this.codigoCuadrilla = codigoCuadrilla;
    }

    public Integer getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(Integer idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public int getCodigoCuadrilla() {
        return codigoCuadrilla;
    }

    public void setCodigoCuadrilla(int codigoCuadrilla) {
        this.codigoCuadrilla = codigoCuadrilla;
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
        hash += (idCuadrilla != null ? idCuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadrillas)) {
            return false;
        }
        Cuadrillas other = (Cuadrillas) object;
        if ((this.idCuadrilla == null && other.idCuadrilla != null) || (this.idCuadrilla != null && !this.idCuadrilla.equals(other.idCuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Cuadrillas[ idCuadrilla=" + idCuadrilla + " ]";
    }
    
}
