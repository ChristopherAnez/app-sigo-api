/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.operaciones;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "operaciones", schema = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o"),
    @NamedQuery(name = "Operaciones.findByIdOperacion", query = "SELECT o FROM Operaciones o WHERE o.idOperacion = :idOperacion"),
    @NamedQuery(name = "Operaciones.findByIdTipoOperacion", query = "SELECT o FROM Operaciones o WHERE o.idTipoOperacion = :idTipoOperacion"),
    @NamedQuery(name = "Operaciones.findByNumOperacion", query = "SELECT o FROM Operaciones o WHERE o.numOperacion = :numOperacion"),
    @NamedQuery(name = "Operaciones.findByNumSucursal", query = "SELECT o FROM Operaciones o WHERE o.numSucursal = :numSucursal"),
    @NamedQuery(name = "Operaciones.findByCodigoMotivoPrevio", query = "SELECT o FROM Operaciones o WHERE o.codigoMotivoPrevio = :codigoMotivoPrevio"),
    @NamedQuery(name = "Operaciones.findByCodigoStatus", query = "SELECT o FROM Operaciones o WHERE o.codigoStatus = :codigoStatus"),
    @NamedQuery(name = "Operaciones.findByCodigoMotivoFinal", query = "SELECT o FROM Operaciones o WHERE o.codigoMotivoFinal = :codigoMotivoFinal"),
    @NamedQuery(name = "Operaciones.findByFechaVisita", query = "SELECT o FROM Operaciones o WHERE o.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "Operaciones.findByUrgencia", query = "SELECT o FROM Operaciones o WHERE o.urgencia = :urgencia"),
    @NamedQuery(name = "Operaciones.findByFechaRegistro", query = "SELECT o FROM Operaciones o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Operaciones.findByFechaActualizacion", query = "SELECT o FROM Operaciones o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Operaciones.findByUsuario", query = "SELECT o FROM Operaciones o WHERE o.usuario = :usuario")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_operacion")
    private short idTipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_operacion")
    private int numOperacion;
    @Column(name = "num_sucursal")
    private Short numSucursal;
    @Column(name = "codigo_motivo_previo")
    private Short codigoMotivoPrevio;
    @Column(name = "codigo_status")
    private Short codigoStatus;
    @Column(name = "codigo_motivo_final")
    private Short codigoMotivoFinal;
    @Column(name = "fecha_visita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Column(name = "urgencia")
    private Short urgencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 2147483647)
    @Column(name = "usuario")
    private String usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperacion")
    private List<OperacionesMateriales> operacionesMaterialesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperacion")
    private List<OperacionesStatus> operacionesStatusList;
    @OneToMany(mappedBy = "idOperacion")
    private List<OperacionesContact> operacionesContactList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idOperacion")
    private OperacionesCuadrillas operacionesCuadrillas;

    public Operaciones() {
    }

    public Operaciones(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Operaciones(Integer idOperacion, short idTipoOperacion, int numOperacion) {
        this.idOperacion = idOperacion;
        this.idTipoOperacion = idTipoOperacion;
        this.numOperacion = numOperacion;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public short getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(short idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public int getNumOperacion() {
        return numOperacion;
    }

    public void setNumOperacion(int numOperacion) {
        this.numOperacion = numOperacion;
    }

    public Short getNumSucursal() {
        return numSucursal;
    }

    public void setNumSucursal(Short numSucursal) {
        this.numSucursal = numSucursal;
    }

    public Short getCodigoMotivoPrevio() {
        return codigoMotivoPrevio;
    }

    public void setCodigoMotivoPrevio(Short codigoMotivoPrevio) {
        this.codigoMotivoPrevio = codigoMotivoPrevio;
    }

    public Short getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Short codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public Short getCodigoMotivoFinal() {
        return codigoMotivoFinal;
    }

    public void setCodigoMotivoFinal(Short codigoMotivoFinal) {
        this.codigoMotivoFinal = codigoMotivoFinal;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Short getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Short urgencia) {
        this.urgencia = urgencia;
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
    public List<OperacionesMateriales> getOperacionesMaterialesList() {
        return operacionesMaterialesList;
    }

    public void setOperacionesMaterialesList(List<OperacionesMateriales> operacionesMaterialesList) {
        this.operacionesMaterialesList = operacionesMaterialesList;
    }

    @XmlTransient
    public List<OperacionesStatus> getOperacionesStatusList() {
        return operacionesStatusList;
    }

    public void setOperacionesStatusList(List<OperacionesStatus> operacionesStatusList) {
        this.operacionesStatusList = operacionesStatusList;
    }

    @XmlTransient
    public List<OperacionesContact> getOperacionesContactList() {
        return operacionesContactList;
    }

    public void setOperacionesContactList(List<OperacionesContact> operacionesContactList) {
        this.operacionesContactList = operacionesContactList;
    }

    public OperacionesCuadrillas getOperacionesCuadrillas() {
        return operacionesCuadrillas;
    }

    public void setOperacionesCuadrillas(OperacionesCuadrillas operacionesCuadrillas) {
        this.operacionesCuadrillas = operacionesCuadrillas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.operaciones.Operaciones[ idOperacion=" + idOperacion + " ]";
    }
    
}
