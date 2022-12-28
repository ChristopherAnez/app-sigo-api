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
@Table(name = "categoria_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaMateriales.findAll", query = "SELECT c FROM CategoriaMateriales c"),
    @NamedQuery(name = "CategoriaMateriales.findByIdCategoria", query = "SELECT c FROM CategoriaMateriales c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "CategoriaMateriales.findByCodigoCategoria", query = "SELECT c FROM CategoriaMateriales c WHERE c.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "CategoriaMateriales.findByDescripcion", query = "SELECT c FROM CategoriaMateriales c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CategoriaMateriales.findByStatus", query = "SELECT c FROM CategoriaMateriales c WHERE c.status = :status"),
    @NamedQuery(name = "CategoriaMateriales.findByFechaRegistro", query = "SELECT c FROM CategoriaMateriales c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CategoriaMateriales.findByFechaActualizacion", query = "SELECT c FROM CategoriaMateriales c WHERE c.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "CategoriaMateriales.findByUsuario", query = "SELECT c FROM CategoriaMateriales c WHERE c.usuario = :usuario")})
public class CategoriaMateriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "codigo_categoria")
    private Integer codigoCategoria;
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

    public CategoriaMateriales() {
    }

    public CategoriaMateriales(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaMateriales)) {
            return false;
        }
        CategoriaMateriales other = (CategoriaMateriales) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.CategoriaMateriales[ idCategoria=" + idCategoria + " ]";
    }
    
}
