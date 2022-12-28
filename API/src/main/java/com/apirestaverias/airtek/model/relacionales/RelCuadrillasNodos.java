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
@Table(name = "rel_cuadrillas_nodos", schema = "relacionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelCuadrillasNodos.findAll", query = "SELECT r FROM RelCuadrillasNodos r"),
    @NamedQuery(name = "RelCuadrillasNodos.findByIdRel", query = "SELECT r FROM RelCuadrillasNodos r WHERE r.idRel = :idRel"),
    @NamedQuery(name = "RelCuadrillasNodos.findByIdCuadrilla", query = "SELECT r FROM RelCuadrillasNodos r WHERE r.idCuadrilla = :idCuadrilla"),
    @NamedQuery(name = "RelCuadrillasNodos.findByCodigoNodo", query = "SELECT r FROM RelCuadrillasNodos r WHERE r.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "RelCuadrillasNodos.findByNodoCercano", query = "SELECT r FROM RelCuadrillasNodos r WHERE r.nodoCercano = :nodoCercano")})
public class RelCuadrillasNodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rel")
    private Integer idRel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuadrilla")
    private int idCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nodo")
    private int codigoNodo;
    @Column(name = "nodo_cercano")
    private Integer nodoCercano;

    public RelCuadrillasNodos() {
    }

    public RelCuadrillasNodos(Integer idRel) {
        this.idRel = idRel;
    }

    public RelCuadrillasNodos(Integer idRel, int idCuadrilla, int codigoNodo) {
        this.idRel = idRel;
        this.idCuadrilla = idCuadrilla;
        this.codigoNodo = codigoNodo;
    }

    public Integer getIdRel() {
        return idRel;
    }

    public void setIdRel(Integer idRel) {
        this.idRel = idRel;
    }

    public int getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(int idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public int getCodigoNodo() {
        return codigoNodo;
    }

    public void setCodigoNodo(int codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public Integer getNodoCercano() {
        return nodoCercano;
    }

    public void setNodoCercano(Integer nodoCercano) {
        this.nodoCercano = nodoCercano;
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
        if (!(object instanceof RelCuadrillasNodos)) {
            return false;
        }
        RelCuadrillasNodos other = (RelCuadrillasNodos) object;
        if ((this.idRel == null && other.idRel != null) || (this.idRel != null && !this.idRel.equals(other.idRel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.relacionales.RelCuadrillasNodos[ idRel=" + idRel + " ]";
    }
    
}
