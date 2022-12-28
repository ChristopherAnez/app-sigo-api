/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.tecnologia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author e.colina
 */
@Embeddable
public class OltPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nodo")
    private short codigoNodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_olt")
    private short codigoOlt;

    public OltPK() {
    }

    public OltPK(short codigoNodo, short codigoOlt) {
        this.codigoNodo = codigoNodo;
        this.codigoOlt = codigoOlt;
    }

    public short getCodigoNodo() {
        return codigoNodo;
    }

    public void setCodigoNodo(short codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public short getCodigoOlt() {
        return codigoOlt;
    }

    public void setCodigoOlt(short codigoOlt) {
        this.codigoOlt = codigoOlt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoNodo;
        hash += (int) codigoOlt;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OltPK)) {
            return false;
        }
        OltPK other = (OltPK) object;
        if (this.codigoNodo != other.codigoNodo) {
            return false;
        }
        if (this.codigoOlt != other.codigoOlt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.OltPK[ codigoNodo=" + codigoNodo + ", codigoOlt=" + codigoOlt + " ]";
    }
    
}
