/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "menu_rel_users", schema = "sigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuRelUsers.findAll", query = "SELECT m FROM MenuRelUsers m"),
    @NamedQuery(name = "MenuRelUsers.findByIdRel", query = "SELECT m FROM MenuRelUsers m WHERE m.idRel = :idRel"),
    @NamedQuery(name = "MenuRelUsers.findByIdUser", query = "SELECT m FROM MenuRelUsers m WHERE m.idUser = :idUser")})
public class MenuRelUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rel")
    private Integer idRel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    @ManyToOne(optional = false)
    private Menu idMenu;

    public MenuRelUsers() {
    }

    public MenuRelUsers(Integer idRel) {
        this.idRel = idRel;
    }

    public MenuRelUsers(Integer idRel, int idUser) {
        this.idRel = idRel;
        this.idUser = idUser;
    }

    public Integer getIdRel() {
        return idRel;
    }

    public void setIdRel(Integer idRel) {
        this.idRel = idRel;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
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
        if (!(object instanceof MenuRelUsers)) {
            return false;
        }
        MenuRelUsers other = (MenuRelUsers) object;
        if ((this.idRel == null && other.idRel != null) || (this.idRel != null && !this.idRel.equals(other.idRel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.MenuRelUsers[ idRel=" + idRel + " ]";
    }
    
}
