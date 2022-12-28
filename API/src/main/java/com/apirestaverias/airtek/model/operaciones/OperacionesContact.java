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
@Table(name = "operaciones_contact", schema = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionesContact.findAll", query = "SELECT o FROM OperacionesContact o"),
    @NamedQuery(name = "OperacionesContact.findByIdOpContact", query = "SELECT o FROM OperacionesContact o WHERE o.idOpContact = :idOpContact"),
    @NamedQuery(name = "OperacionesContact.findByTicketContact", query = "SELECT o FROM OperacionesContact o WHERE o.ticketContact = :ticketContact"),
    @NamedQuery(name = "OperacionesContact.findByUserContact", query = "SELECT o FROM OperacionesContact o WHERE o.userContact = :userContact"),
    @NamedQuery(name = "OperacionesContact.findByFechaRegistro", query = "SELECT o FROM OperacionesContact o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OperacionesContact.findByFechaActualizacion", query = "SELECT o FROM OperacionesContact o WHERE o.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "OperacionesContact.findByUsuario", query = "SELECT o FROM OperacionesContact o WHERE o.usuario = :usuario")})
public class OperacionesContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_op_contact")
    private Integer idOpContact;
    @Column(name = "ticket_contact")
    private Integer ticketContact;
    @Size(max = 2147483647)
    @Column(name = "user_contact")
    private String userContact;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 2147483647)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "id_operacion", referencedColumnName = "id_operacion")
    @ManyToOne
    private Operaciones idOperacion;

    public OperacionesContact() {
    }

    public OperacionesContact(Integer idOpContact) {
        this.idOpContact = idOpContact;
    }

    public Integer getIdOpContact() {
        return idOpContact;
    }

    public void setIdOpContact(Integer idOpContact) {
        this.idOpContact = idOpContact;
    }

    public Integer getTicketContact() {
        return ticketContact;
    }

    public void setTicketContact(Integer ticketContact) {
        this.ticketContact = ticketContact;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
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
        hash += (idOpContact != null ? idOpContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionesContact)) {
            return false;
        }
        OperacionesContact other = (OperacionesContact) object;
        if ((this.idOpContact == null && other.idOpContact != null) || (this.idOpContact != null && !this.idOpContact.equals(other.idOpContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.operaciones.OperacionesContact[ idOpContact=" + idOpContact + " ]";
    }
    
}
