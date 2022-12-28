/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "tecnicos", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicos.findAll", query = "SELECT t FROM Tecnicos t"),
    @NamedQuery(name = "Tecnicos.findByIdTecnico", query = "SELECT t FROM Tecnicos t WHERE t.idTecnico = :idTecnico"),
    @NamedQuery(name = "Tecnicos.findByCodigoTecnico", query = "SELECT t FROM Tecnicos t WHERE t.codigoTecnico = :codigoTecnico"),
    @NamedQuery(name = "Tecnicos.findByCodigoSucursal", query = "SELECT t FROM Tecnicos t WHERE t.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "Tecnicos.findByNombreTecnico", query = "SELECT t FROM Tecnicos t WHERE t.nombreTecnico = :nombreTecnico"),
    @NamedQuery(name = "Tecnicos.findByTipoTecnico", query = "SELECT t FROM Tecnicos t WHERE t.tipoTecnico = :tipoTecnico"),
    @NamedQuery(name = "Tecnicos.findByCodigoProveedor", query = "SELECT t FROM Tecnicos t WHERE t.codigoProveedor = :codigoProveedor"),
    @NamedQuery(name = "Tecnicos.findByStatus", query = "SELECT t FROM Tecnicos t WHERE t.status = :status"),
    @NamedQuery(name = "Tecnicos.findByTipoVehiculo", query = "SELECT t FROM Tecnicos t WHERE t.tipoVehiculo = :tipoVehiculo"),
    @NamedQuery(name = "Tecnicos.findByIdVehiculo", query = "SELECT t FROM Tecnicos t WHERE t.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Tecnicos.findByTelefono", query = "SELECT t FROM Tecnicos t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tecnicos.findByMail", query = "SELECT t FROM Tecnicos t WHERE t.mail = :mail"),
    @NamedQuery(name = "Tecnicos.findByCodigoSupervisor", query = "SELECT t FROM Tecnicos t WHERE t.codigoSupervisor = :codigoSupervisor"),
    @NamedQuery(name = "Tecnicos.findByFechaRegistro", query = "SELECT t FROM Tecnicos t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tecnicos.findByFechaActualizacion", query = "SELECT t FROM Tecnicos t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Tecnicos.findByUsuario", query = "SELECT t FROM Tecnicos t WHERE t.usuario = :usuario")})
public class Tecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tecnico")
    private Integer idTecnico;
    @Column(name = "codigo_tecnico")
    private Integer codigoTecnico;
    @Column(name = "codigo_sucursal")
    private Short codigoSucursal;
    @Size(max = 70)
    @Column(name = "nombre_tecnico")
    private String nombreTecnico;
    @Column(name = "tipo_tecnico")
    private Integer tipoTecnico;
    @Column(name = "codigo_proveedor")
    private Integer codigoProveedor;
    @Size(max = 2)
    @Column(name = "status")
    private String status;
    @Size(max = 1)
    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Column(name = "telefono")
    private BigInteger telefono;
    @Size(max = 70)
    @Column(name = "mail")
    private String mail;
    @Column(name = "codigo_supervisor")
    private Short codigoSupervisor;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;

    public Tecnicos() {
    }

    public Tecnicos(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getCodigoTecnico() {
        return codigoTecnico;
    }

    public void setCodigoTecnico(Integer codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }

    public Short getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Short codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public Integer getTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(Integer tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Short getCodigoSupervisor() {
        return codigoSupervisor;
    }

    public void setCodigoSupervisor(Short codigoSupervisor) {
        this.codigoSupervisor = codigoSupervisor;
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
        hash += (idTecnico != null ? idTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicos)) {
            return false;
        }
        Tecnicos other = (Tecnicos) object;
        if ((this.idTecnico == null && other.idTecnico != null) || (this.idTecnico != null && !this.idTecnico.equals(other.idTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Tecnicos[ idTecnico=" + idTecnico + " ]";
    }
    
}
