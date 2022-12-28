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
import javax.persistence.JoinColumns;
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
@Table(name = "mdt", schema = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdt.findAll", query = "SELECT m FROM Mdt m"),
    @NamedQuery(name = "Mdt.findByIdMdt", query = "SELECT m FROM Mdt m WHERE m.idMdt = :idMdt"),
    @NamedQuery(name = "Mdt.findByCodigoNodo", query = "SELECT m FROM Mdt m WHERE m.mdtPK.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "Mdt.findByCodigoOlt", query = "SELECT m FROM Mdt m WHERE m.mdtPK.codigoOlt = :codigoOlt"),
    @NamedQuery(name = "Mdt.findByCodigoMdt", query = "SELECT m FROM Mdt m WHERE m.mdtPK.codigoMdt = :codigoMdt"),
    @NamedQuery(name = "Mdt.findByNombre", query = "SELECT m FROM Mdt m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mdt.findByAlias", query = "SELECT m FROM Mdt m WHERE m.alias = :alias"),
    @NamedQuery(name = "Mdt.findByUbicacion", query = "SELECT m FROM Mdt m WHERE m.ubicacion = :ubicacion"),
    @NamedQuery(name = "Mdt.findByCoordenadas", query = "SELECT m FROM Mdt m WHERE m.coordenadas = :coordenadas"),
    @NamedQuery(name = "Mdt.findByVisible", query = "SELECT m FROM Mdt m WHERE m.visible = :visible"),
    @NamedQuery(name = "Mdt.findByDistanciaMdtOlt", query = "SELECT m FROM Mdt m WHERE m.distanciaMdtOlt = :distanciaMdtOlt"),
    @NamedQuery(name = "Mdt.findByTarjetaOlt", query = "SELECT m FROM Mdt m WHERE m.tarjetaOlt = :tarjetaOlt"),
    @NamedQuery(name = "Mdt.findByPuertoOlt", query = "SELECT m FROM Mdt m WHERE m.puertoOlt = :puertoOlt"),
    @NamedQuery(name = "Mdt.findByStatus", query = "SELECT m FROM Mdt m WHERE m.status = :status"),
    @NamedQuery(name = "Mdt.findByFechaRegistro", query = "SELECT m FROM Mdt m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Mdt.findByFechaActualizacion", query = "SELECT m FROM Mdt m WHERE m.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Mdt.findByUsuario", query = "SELECT m FROM Mdt m WHERE m.usuario = :usuario")})
public class Mdt implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MdtPK mdtPK;
    @Basic(optional = false)
    @Column(name = "id_mdt")
    private int idMdt;
    @Size(max = 30)
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
    @Column(name = "distancia_mdt_olt")
    private Integer distanciaMdtOlt;
    @Column(name = "tarjeta_olt")
    private Short tarjetaOlt;
    @Column(name = "puerto_olt")
    private Short puertoOlt;
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
    @JoinColumns({
        @JoinColumn(name = "codigo_nodo", referencedColumnName = "codigo_nodo", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_olt", referencedColumnName = "codigo_olt", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Olt olt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mdt")
    private List<Nap> napList;

    public Mdt() {
    }

    public Mdt(MdtPK mdtPK) {
        this.mdtPK = mdtPK;
    }

    public Mdt(MdtPK mdtPK, int idMdt) {
        this.mdtPK = mdtPK;
        this.idMdt = idMdt;
    }

    public Mdt(short codigoNodo, short codigoOlt, int codigoMdt) {
        this.mdtPK = new MdtPK(codigoNodo, codigoOlt, codigoMdt);
    }

    public MdtPK getMdtPK() {
        return mdtPK;
    }

    public void setMdtPK(MdtPK mdtPK) {
        this.mdtPK = mdtPK;
    }

    public int getIdMdt() {
        return idMdt;
    }

    public void setIdMdt(int idMdt) {
        this.idMdt = idMdt;
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

    public Integer getDistanciaMdtOlt() {
        return distanciaMdtOlt;
    }

    public void setDistanciaMdtOlt(Integer distanciaMdtOlt) {
        this.distanciaMdtOlt = distanciaMdtOlt;
    }

    public Short getTarjetaOlt() {
        return tarjetaOlt;
    }

    public void setTarjetaOlt(Short tarjetaOlt) {
        this.tarjetaOlt = tarjetaOlt;
    }

    public Short getPuertoOlt() {
        return puertoOlt;
    }

    public void setPuertoOlt(Short puertoOlt) {
        this.puertoOlt = puertoOlt;
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

    public Olt getOlt() {
        return olt;
    }

    public void setOlt(Olt olt) {
        this.olt = olt;
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
        hash += (mdtPK != null ? mdtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdt)) {
            return false;
        }
        Mdt other = (Mdt) object;
        if ((this.mdtPK == null && other.mdtPK != null) || (this.mdtPK != null && !this.mdtPK.equals(other.mdtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.Mdt[ mdtPK=" + mdtPK + " ]";
    }
    
}
