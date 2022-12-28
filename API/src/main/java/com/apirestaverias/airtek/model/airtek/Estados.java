/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estados", schema = "airtek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByIdEstado", query = "SELECT e FROM Estados e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "Estados.findByCodigoPais", query = "SELECT e FROM Estados e WHERE e.estadosPK.codigoPais = :codigoPais"),
    @NamedQuery(name = "Estados.findByCodigoEstado", query = "SELECT e FROM Estados e WHERE e.estadosPK.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Estados.findByDescripcion", query = "SELECT e FROM Estados e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estados.findByStatus", query = "SELECT e FROM Estados e WHERE e.status = :status"),
    @NamedQuery(name = "Estados.findByFechaRegistro", query = "SELECT e FROM Estados e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Estados.findByFechaActualizacion", query = "SELECT e FROM Estados e WHERE e.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Estados.findByUsuario", query = "SELECT e FROM Estados e WHERE e.usuario = :usuario")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadosPK estadosPK;
    @Basic(optional = false)
    @Column(name = "id_estado")
    private int idEstado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estados")
    private List<Municipios> municipiosList;
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paises paises;

    public Estados() {
    }

    public Estados(EstadosPK estadosPK) {
        this.estadosPK = estadosPK;
    }

    public Estados(EstadosPK estadosPK, int idEstado) {
        this.estadosPK = estadosPK;
        this.idEstado = idEstado;
    }

    public Estados(short codigoPais, short codigoEstado) {
        this.estadosPK = new EstadosPK(codigoPais, codigoEstado);
    }

    public EstadosPK getEstadosPK() {
        return estadosPK;
    }

    public void setEstadosPK(EstadosPK estadosPK) {
        this.estadosPK = estadosPK;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadosPK != null ? estadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.estadosPK == null && other.estadosPK != null) || (this.estadosPK != null && !this.estadosPK.equals(other.estadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.Estados[ estadosPK=" + estadosPK + " ]";
    }
    
}
