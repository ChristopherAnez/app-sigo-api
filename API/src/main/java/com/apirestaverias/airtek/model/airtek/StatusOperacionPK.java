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
public class StatusOperacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_operacion")
    private int idTipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_status")
    private int codigoStatus;

    public StatusOperacionPK() {
    }

    public StatusOperacionPK(int idTipoOperacion, int codigoStatus) {
        this.idTipoOperacion = idTipoOperacion;
        this.codigoStatus = codigoStatus;
    }

    public int getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(int idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(int codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoOperacion;
        hash += (int) codigoStatus;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusOperacionPK)) {
            return false;
        }
        StatusOperacionPK other = (StatusOperacionPK) object;
        if (this.idTipoOperacion != other.idTipoOperacion) {
            return false;
        }
        if (this.codigoStatus != other.codigoStatus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.airtek.StatusOperacionPK[ idTipoOperacion=" + idTipoOperacion + ", codigoStatus=" + codigoStatus + " ]";
    }
    
}
