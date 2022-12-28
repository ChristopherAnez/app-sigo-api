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
public class SectoresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_pais")
    private short codigoPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_estado")
    private short codigoEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_municipio")
    private short codigoMunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_sector")
    private int codigoSector;

    public SectoresPK() {
    }

    public SectoresPK(short codigoPais, short codigoEstado, short codigoMunicipio, int codigoSector) {
        this.codigoPais = codigoPais;
        this.codigoEstado = codigoEstado;
        this.codigoMunicipio = codigoMunicipio;
        this.codigoSector = codigoSector;
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

    public short getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(short codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public int getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(int codigoSector) {
        this.codigoSector = codigoSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoPais;
        hash += (int) codigoEstado;
        hash += (int) codigoMunicipio;
        hash += (int) codigoSector;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectoresPK)) {
            return false;
        }
        SectoresPK other = (SectoresPK) object;
        if (this.codigoPais != other.codigoPais) {
            return false;
        }
        if (this.codigoEstado != other.codigoEstado) {
            return false;
        }
        if (this.codigoMunicipio != other.codigoMunicipio) {
            return false;
        }
        if (this.codigoSector != other.codigoSector) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.SectoresPK[ codigoPais=" + codigoPais + ", codigoEstado=" + codigoEstado + ", codigoMunicipio=" + codigoMunicipio + ", codigoSector=" + codigoSector + " ]";
    }
    
}
