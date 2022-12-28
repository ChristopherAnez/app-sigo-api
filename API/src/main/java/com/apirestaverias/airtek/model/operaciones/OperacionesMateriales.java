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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "operaciones_materiales", schema = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionesMateriales.findAll", query = "SELECT o FROM OperacionesMateriales o"),
    @NamedQuery(name = "OperacionesMateriales.findByIdMaterialOperacion", query = "SELECT o FROM OperacionesMateriales o WHERE o.idMaterialOperacion = :idMaterialOperacion"),
    @NamedQuery(name = "OperacionesMateriales.findByIdMaterial", query = "SELECT o FROM OperacionesMateriales o WHERE o.idMaterial = :idMaterial"),
    @NamedQuery(name = "OperacionesMateriales.findByCantidad", query = "SELECT o FROM OperacionesMateriales o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OperacionesMateriales.findByFechaRegistro", query = "SELECT o FROM OperacionesMateriales o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OperacionesMateriales.findByFechaActualizacion", query = "SELECT o FROM OperacionesMateriales o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "OperacionesMateriales.findByUsuario", query = "SELECT o FROM OperacionesMateriales o WHERE o.usuario = :usuario")})
public class OperacionesMateriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_operacion")
    private Integer idMaterialOperacion;
    @Column(name = "id_material")
    private Integer idMaterial;
    @Column(name = "cantidad")
    private Integer cantidad;
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

    public OperacionesMateriales() {
    }

    public OperacionesMateriales(Integer idMaterialOperacion) {
        this.idMaterialOperacion = idMaterialOperacion;
    }

    public Integer getIdMaterialOperacion() {
        return idMaterialOperacion;
    }

    public void setIdMaterialOperacion(Integer idMaterialOperacion) {
        this.idMaterialOperacion = idMaterialOperacion;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        hash += (idMaterialOperacion != null ? idMaterialOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionesMateriales)) {
            return false;
        }
        OperacionesMateriales other = (OperacionesMateriales) object;
        if ((this.idMaterialOperacion == null && other.idMaterialOperacion != null) || (this.idMaterialOperacion != null && !this.idMaterialOperacion.equals(other.idMaterialOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.operaciones.OperacionesMateriales[ idMaterialOperacion=" + idMaterialOperacion + " ]";
    }
    
}
