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
@Table(name = "rel_cuadrillas_tecnicos", schema = "relacionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelCuadrillasTecnicos.findAll", query = "SELECT r FROM RelCuadrillasTecnicos r"),
    @NamedQuery(name = "RelCuadrillasTecnicos.findByIdRel", query = "SELECT r FROM RelCuadrillasTecnicos r WHERE r.idRel = :idRel"),
    @NamedQuery(name = "RelCuadrillasTecnicos.findByIdCuadrilla", query = "SELECT r FROM RelCuadrillasTecnicos r WHERE r.idCuadrilla = :idCuadrilla"),
    @NamedQuery(name = "RelCuadrillasTecnicos.findByIdTecnico", query = "SELECT r FROM RelCuadrillasTecnicos r WHERE r.idTecnico = :idTecnico"),
    @NamedQuery(name = "RelCuadrillasTecnicos.findByIdTipoTecnico", query = "SELECT r FROM RelCuadrillasTecnicos r WHERE r.idTipoTecnico = :idTipoTecnico")})
public class RelCuadrillasTecnicos implements Serializable {

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
    @Column(name = "id_tecnico")
    private int idTecnico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_tecnico")
    private int idTipoTecnico;

    public RelCuadrillasTecnicos() {
    }

    public RelCuadrillasTecnicos(Integer idRel) {
        this.idRel = idRel;
    }

    public RelCuadrillasTecnicos(Integer idRel, int idCuadrilla, int idTecnico, int idTipoTecnico) {
        this.idRel = idRel;
        this.idCuadrilla = idCuadrilla;
        this.idTecnico = idTecnico;
        this.idTipoTecnico = idTipoTecnico;
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

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getIdTipoTecnico() {
        return idTipoTecnico;
    }

    public void setIdTipoTecnico(int idTipoTecnico) {
        this.idTipoTecnico = idTipoTecnico;
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
        if (!(object instanceof RelCuadrillasTecnicos)) {
            return false;
        }
        RelCuadrillasTecnicos other = (RelCuadrillasTecnicos) object;
        if ((this.idRel == null && other.idRel != null) || (this.idRel != null && !this.idRel.equals(other.idRel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.relacionales.RelCuadrillasTecnicos[ idRel=" + idRel + " ]";
    }
    
}
