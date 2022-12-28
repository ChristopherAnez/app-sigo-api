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
public class NapPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nodo")
    private short codigoNodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_olt")
    private short codigoOlt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_mdt")
    private int codigoMdt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nap")
    private int codigoNap;

    public NapPK() {
    }

    public NapPK(short codigoNodo, short codigoOlt, int codigoMdt, int codigoNap) {
        this.codigoNodo = codigoNodo;
        this.codigoOlt = codigoOlt;
        this.codigoMdt = codigoMdt;
        this.codigoNap = codigoNap;
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

    public int getCodigoMdt() {
        return codigoMdt;
    }

    public void setCodigoMdt(int codigoMdt) {
        this.codigoMdt = codigoMdt;
    }

    public int getCodigoNap() {
        return codigoNap;
    }

    public void setCodigoNap(int codigoNap) {
        this.codigoNap = codigoNap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoNodo;
        hash += (int) codigoOlt;
        hash += (int) codigoMdt;
        hash += (int) codigoNap;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NapPK)) {
            return false;
        }
        NapPK other = (NapPK) object;
        if (this.codigoNodo != other.codigoNodo) {
            return false;
        }
        if (this.codigoOlt != other.codigoOlt) {
            return false;
        }
        if (this.codigoMdt != other.codigoMdt) {
            return false;
        }
        if (this.codigoNap != other.codigoNap) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.tecnologia.NapPK[ codigoNodo=" + codigoNodo + ", codigoOlt=" + codigoOlt + ", codigoMdt=" + codigoMdt + ", codigoNap=" + codigoNap + " ]";
    }
    
}
