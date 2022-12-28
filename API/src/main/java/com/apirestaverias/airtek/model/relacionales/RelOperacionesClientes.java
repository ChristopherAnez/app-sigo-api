/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.relacionales;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "rel_operaciones_clientes", schema = "relacionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelOperacionesClientes.findAll", query = "SELECT r FROM RelOperacionesClientes r"),
    @NamedQuery(name = "RelOperacionesClientes.findByIdRel", query = "SELECT r FROM RelOperacionesClientes r WHERE r.idRel = :idRel"),
    @NamedQuery(name = "RelOperacionesClientes.findByIdOperacion", query = "SELECT r FROM RelOperacionesClientes r WHERE r.idOperacion = :idOperacion"),
    @NamedQuery(name = "RelOperacionesClientes.findByIdCliente", query = "SELECT r FROM RelOperacionesClientes r WHERE r.idCliente = :idCliente"),
    @NamedQuery(name = "RelOperacionesClientes.findByIdServicioCliente", query = "SELECT r FROM RelOperacionesClientes r WHERE r.idServicioCliente = :idServicioCliente")})
public class RelOperacionesClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rel")
    private Integer idRel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_operacion")
    private int idOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio_cliente")
    private int idServicioCliente;

    public RelOperacionesClientes() {
    }

    public RelOperacionesClientes(Integer idRel) {
        this.idRel = idRel;
    }

    public RelOperacionesClientes(Integer idRel, int idOperacion, int idCliente, int idServicioCliente) {
        this.idRel = idRel;
        this.idOperacion = idOperacion;
        this.idCliente = idCliente;
        this.idServicioCliente = idServicioCliente;
    }

    public Integer getIdRel() {
        return idRel;
    }

    public void setIdRel(Integer idRel) {
        this.idRel = idRel;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicioCliente() {
        return idServicioCliente;
    }

    public void setIdServicioCliente(int idServicioCliente) {
        this.idServicioCliente = idServicioCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRel != null ? idRel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelOperacionesClientes)) {
            return false;
        }
        RelOperacionesClientes other = (RelOperacionesClientes) object;
        if ((this.idRel == null && other.idRel != null) || (this.idRel != null && !this.idRel.equals(other.idRel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.relacionales.RelOperacionesClientes[ idRel=" + idRel + " ]";
    }
    
}
