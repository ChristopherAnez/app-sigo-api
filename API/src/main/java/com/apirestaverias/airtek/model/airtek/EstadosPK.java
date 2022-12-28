/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.airtek;

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
public class EstadosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_pais")
    private short codigoPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_estado")
    private short codigoEstado;

    public EstadosPK() {
    }

    public EstadosPK(short codigoPais, short codigoEstado) {
        this.codigoPais = codigoPais;
        this.codigoEstado = codigoEstado;
    }

    public short getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(short codigoPais) {
        this.codigoPais = codigoPais;
    }

    public short getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(short codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoPais;
        hash += (int) codigoEstado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosPK)) {
            return false;
        }
        EstadosPK other = (EstadosPK) object;
        if (this.codigoPais != other.codigoPais) {
            return false;
        }
        if (this.codigoEstado != other.codigoEstado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.EstadosPK[ codigoPais=" + codigoPais + ", codigoEstado=" + codigoEstado + " ]";
    }
    
}
