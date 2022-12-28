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
@Table(name = "olt", schema = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Olt.findAll", query = "SELECT o FROM Olt o"),
    @NamedQuery(name = "Olt.findByIdOlt", query = "SELECT o FROM Olt o WHERE o.idOlt = :idOlt"),
    @NamedQuery(name = "Olt.findByCodigoNodo", query = "SELECT o FROM Olt o WHERE o.oltPK.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "Olt.findByCodigoOlt", query = "SELECT o FROM Olt o WHERE o.oltPK.codigoOlt = :codigoOlt"),
    @NamedQuery(name = "Olt.findByNombre", query = "SELECT o FROM Olt o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Olt.findByAlias", query = "SELECT o FROM Olt o WHERE o.alias = :alias"),
    @NamedQuery(name = "Olt.findByVisible", query = "SELECT o FROM Olt o WHERE o.visible = :visible"),
    @NamedQuery(name = "Olt.findByFechaRegistro", query = "SELECT o FROM Olt o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Olt.findByFechaActualizacion", query = "SELECT o FROM Olt o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Olt.findByUsuario", query = "SELECT o FROM Olt o WHERE o.usuario = :usuario")})
public class Olt implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OltPK oltPK;
    @Basic(optional = false)
    @Column(name = "id_olt")
    private int idOlt;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 3)
    @Column(name = "alias")
    private String alias;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "codigo_nodo", referencedColumnName = "codigo_nodo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nodos nodos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "olt")
    private List<Mdt> mdtList;

    public Olt() {
    }

    public Olt(OltPK oltPK) {
        this.oltPK = oltPK;
    }

    public Olt(OltPK oltPK, int idOlt) {
        this.oltPK = oltPK;
        this.idOlt = idOlt;
    }

    public Olt(short codigoNodo, short codigoOlt) {
        this.oltPK = new OltPK(codigoNodo, codigoOlt);
    }

    public OltPK getOltPK() {
        return oltPK;
    }

    public void setOltPK(OltPK oltPK) {
        this.oltPK = oltPK;
    }

    public int getIdOlt() {
        return idOlt;
    }

    public void setIdOlt(int idOlt) {
        this.idOlt = idOlt;
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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
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

    public Nodos getNodos() {
        return nodos;
    }

    public void setNodos(Nodos nodos) {
        this.nodos = nodos;
    }

    @XmlTransient
    public List<Mdt> getMdtList() {
        return mdtList;
    }

    public void setMdtList(List<Mdt> mdtList) {
        this.mdtList = mdtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltPK != null ? oltPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Olt)) {
            return false;
        }
        Olt other = (Olt) object;
        if ((this.oltPK == null && other.oltPK != null) || (this.oltPK != null && !this.oltPK.equals(other.oltPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.Olt[ oltPK=" + oltPK + " ]";
    }
    
}
