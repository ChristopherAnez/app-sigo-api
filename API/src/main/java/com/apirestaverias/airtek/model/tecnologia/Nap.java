/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.tecnologia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "nap", schema = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nap.findAll", query = "SELECT n FROM Nap n"),
    @NamedQuery(name = "Nap.findByIdNap", query = "SELECT n FROM Nap n WHERE n.idNap = :idNap"),
    @NamedQuery(name = "Nap.findByCodigoNodo", query = "SELECT n FROM Nap n WHERE n.napPK.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "Nap.findByCodigoOlt", query = "SELECT n FROM Nap n WHERE n.napPK.codigoOlt = :codigoOlt"),
    @NamedQuery(name = "Nap.findByCodigoMdt", query = "SELECT n FROM Nap n WHERE n.napPK.codigoMdt = :codigoMdt"),
    @NamedQuery(name = "Nap.findByCodigoNap", query = "SELECT n FROM Nap n WHERE n.napPK.codigoNap = :codigoNap"),
    @NamedQuery(name = "Nap.findByNombre", query = "SELECT n FROM Nap n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Nap.findByAlias", query = "SELECT n FROM Nap n WHERE n.alias = :alias"),
    @NamedQuery(name = "Nap.findByUbicacion", query = "SELECT n FROM Nap n WHERE n.ubicacion = :ubicacion"),
    @NamedQuery(name = "Nap.findByCoordenadas", query = "SELECT n FROM Nap n WHERE n.coordenadas = :coordenadas"),
    @NamedQuery(name = "Nap.findByVisible", query = "SELECT n FROM Nap n WHERE n.visible = :visible"),
    @NamedQuery(name = "Nap.findByStatus", query = "SELECT n FROM Nap n WHERE n.status = :status"),
    @NamedQuery(name = "Nap.findByFechaRegistro", query = "SELECT n FROM Nap n WHERE n.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Nap.findByFechaActualizacion", query = "SELECT n FROM Nap n WHERE n.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Nap.findByUsuario", query = "SELECT n FROM Nap n WHERE n.usuario = :usuario")})
public class Nap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NapPK napPK;
    @Basic(optional = false)
    @Column(name = "id_nap")
    private int idNap;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 5)
    @Column(name = "alias")
    private String alias;
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
    @JoinColumn(name = "cable_distribucion", referencedColumnName = "id_cable")
    @ManyToOne
    private CablesDistribucion cableDistribucion;
    @JoinColumns({
        @JoinColumn(name = "codigo_nodo", referencedColumnName = "codigo_nodo", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_olt", referencedColumnName = "codigo_olt", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_mdt", referencedColumnName = "codigo_mdt", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Mdt mdt;

    public Nap() {
    }

    public Nap(NapPK napPK) {
        this.napPK = napPK;
    }

    public Nap(NapPK napPK, int idNap) {
        this.napPK = napPK;
        this.idNap = idNap;
    }

    public Nap(short codigoNodo, short codigoOlt, int codigoMdt, int codigoNap) {
        this.napPK = new NapPK(codigoNodo, codigoOlt, codigoMdt, codigoNap);
    }

    public NapPK getNapPK() {
        return napPK;
    }

    public void setNapPK(NapPK napPK) {
        this.napPK = napPK;
    }

    public int getIdNap() {
        return idNap;
    }

    public void setIdNap(int idNap) {
        this.idNap = idNap;
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

    public CablesDistribucion getCableDistribucion() {
        return cableDistribucion;
    }

    public void setCableDistribucion(CablesDistribucion cableDistribucion) {
        this.cableDistribucion = cableDistribucion;
    }

    public Mdt getMdt() {
        return mdt;
    }

    public void setMdt(Mdt mdt) {
        this.mdt = mdt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (napPK != null ? napPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nap)) {
            return false;
        }
        Nap other = (Nap) object;
        if ((this.napPK == null && other.napPK != null) || (this.napPK != null && !this.napPK.equals(other.napPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.Nap[ napPK=" + napPK + " ]";
    }
    
}
