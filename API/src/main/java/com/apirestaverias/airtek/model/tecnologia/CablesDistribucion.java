/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.tecnologia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "cables_distribucion", schema = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CablesDistribucion.findAll", query = "SELECT c FROM CablesDistribucion c"),
    @NamedQuery(name = "CablesDistribucion.findByIdCable", query = "SELECT c FROM CablesDistribucion c WHERE c.idCable = :idCable"),
    @NamedQuery(name = "CablesDistribucion.findByDescripcion", query = "SELECT c FROM CablesDistribucion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CablesDistribucion.findByStatus", query = "SELECT c FROM CablesDistribucion c WHERE c.status = :status"),
    @NamedQuery(name = "CablesDistribucion.findByFechaRegistro", query = "SELECT c FROM CablesDistribucion c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CablesDistribucion.findByFechaActualizacion", query = "SELECT c FROM CablesDistribucion c WHERE c.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "CablesDistribucion.findByUsuario", query = "SELECT c FROM CablesDistribucion c WHERE c.usuario = :usuario")})
public class CablesDistribucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cable")
    private Integer idCable;
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
    @OneToMany(mappedBy = "cableDistribucion")
    private List<Nap> napList;

    public CablesDistribucion() {
    }

    public CablesDistribucion(Integer idCable) {
        this.idCable = idCable;
    }

    public Integer getIdCable() {
        return idCable;
    }

    public void setIdCable(Integer idCable) {
        this.idCable = idCable;
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

    @XmlTransient
    public List<Nap> getNapList() {
        return napList;
    }

    public void setNapList(List<Nap> napList) {
        this.napList = napList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCable != null ? idCable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CablesDistribucion)) {
            return false;
        }
        CablesDistribucion other = (CablesDistribucion) object;
        if ((this.idCable == null && other.idCable != null) || (this.idCable != null && !this.idCable.equals(other.idCable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.CablesDistribucion[ idCable=" + idCable + " ]";
    }
    
}
