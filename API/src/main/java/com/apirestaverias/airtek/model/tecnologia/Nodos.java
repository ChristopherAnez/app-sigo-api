/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.tecnologia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "nodos", schema = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nodos.findAll", query = "SELECT n FROM Nodos n"),
    @NamedQuery(name = "Nodos.findByIdNodo", query = "SELECT n FROM Nodos n WHERE n.idNodo = :idNodo"),
    @NamedQuery(name = "Nodos.findByCodigoNodo", query = "SELECT n FROM Nodos n WHERE n.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "Nodos.findByNombre", query = "SELECT n FROM Nodos n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Nodos.findByAlias", query = "SELECT n FROM Nodos n WHERE n.alias = :alias"),
    @NamedQuery(name = "Nodos.findByCodigoSucursal", query = "SELECT n FROM Nodos n WHERE n.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "Nodos.findByUbicacion", query = "SELECT n FROM Nodos n WHERE n.ubicacion = :ubicacion"),
    @NamedQuery(name = "Nodos.findByCoordenadas", query = "SELECT n FROM Nodos n WHERE n.coordenadas = :coordenadas"),
    @NamedQuery(name = "Nodos.findByVisible", query = "SELECT n FROM Nodos n WHERE n.visible = :visible"),
    @NamedQuery(name = "Nodos.findByStatus", query = "SELECT n FROM Nodos n WHERE n.status = :status"),
    @NamedQuery(name = "Nodos.findByFechaRegistro", query = "SELECT n FROM Nodos n WHERE n.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Nodos.findByFechaActualizacion", query = "SELECT n FROM Nodos n WHERE n.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Nodos.findByUsuario", query = "SELECT n FROM Nodos n WHERE n.usuario = :usuario")})
public class Nodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_nodo")
    private int idNodo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nodo")
    private Integer codigoNodo;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 3)
    @Column(name = "alias")
    private String alias;
    @Column(name = "codigo_sucursal")
    private Short codigoSucursal;
    @Size(max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 50)
    @Column(name = "coordenadas")
    private String coordenadas;
    @Column(name = "visible")
    private Boolean visible;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nodos")
    private List<Olt> oltList;

    public Nodos() {
    }

    public Nodos(Integer codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public Nodos(Integer codigoNodo, int idNodo) {
        this.codigoNodo = codigoNodo;
        this.idNodo = idNodo;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public Integer getCodigoNodo() {
        return codigoNodo;
    }

    public void setCodigoNodo(Integer codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Short getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Short codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
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

    @XmlTransient
    public List<Olt> getOltList() {
        return oltList;
    }

    public void setOltList(List<Olt> oltList) {
        this.oltList = oltList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNodo != null ? codigoNodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nodos)) {
            return false;
        }
        Nodos other = (Nodos) object;
        if ((this.codigoNodo == null && other.codigoNodo != null) || (this.codigoNodo != null && !this.codigoNodo.equals(other.codigoNodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.Nodos[ codigoNodo=" + codigoNodo + " ]";
    }
    
}
