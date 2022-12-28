/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "menu", schema = "sigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByCodeModule", query = "SELECT m FROM Menu m WHERE m.codeModule = :codeModule"),
    @NamedQuery(name = "Menu.findByCodeDivision", query = "SELECT m FROM Menu m WHERE m.codeDivision = :codeDivision"),
    @NamedQuery(name = "Menu.findByCodeOption", query = "SELECT m FROM Menu m WHERE m.codeOption = :codeOption"),
    @NamedQuery(name = "Menu.findByCodeFeature", query = "SELECT m FROM Menu m WHERE m.codeFeature = :codeFeature"),
    @NamedQuery(name = "Menu.findByDescription", query = "SELECT m FROM Menu m WHERE m.description = :description"),
    @NamedQuery(name = "Menu.findByShorcut", query = "SELECT m FROM Menu m WHERE m.shorcut = :shorcut"),
    @NamedQuery(name = "Menu.findByRoute", query = "SELECT m FROM Menu m WHERE m.route = :route"),
    @NamedQuery(name = "Menu.findByStatus", query = "SELECT m FROM Menu m WHERE m.status = :status")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_module")
    private int codeModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_division")
    private int codeDivision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_option")
    private int codeOption;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_feature")
    private int codeFeature;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 1)
    @Column(name = "shorcut")
    private String shorcut;
    @Size(max = 150)
    @Column(name = "route")
    private String route;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @JoinTable(name = "menu_rel_roles", schema = "sigo", joinColumns = {
        @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")}, inverseJoinColumns = {
        @JoinColumn(name = "id_role", referencedColumnName = "id")})
    @ManyToMany
    private List<Role> roleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<MenuRelUsers> menuRelUsersList;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, int codeModule, int codeDivision, int codeOption, int codeFeature) {
        this.idMenu = idMenu;
        this.codeModule = codeModule;
        this.codeDivision = codeDivision;
        this.codeOption = codeOption;
        this.codeFeature = codeFeature;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public int getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(int codeModule) {
        this.codeModule = codeModule;
    }

    public int getCodeDivision() {
        return codeDivision;
    }

    public void setCodeDivision(int codeDivision) {
        this.codeDivision = codeDivision;
    }

    public int getCodeOption() {
        return codeOption;
    }

    public void setCodeOption(int codeOption) {
        this.codeOption = codeOption;
    }

    public int getCodeFeature() {
        return codeFeature;
    }

    public void setCodeFeature(int codeFeature) {
        this.codeFeature = codeFeature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShorcut() {
        return shorcut;
    }

    public void setShorcut(String shorcut) {
        this.shorcut = shorcut;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @XmlTransient
    public List<MenuRelUsers> getMenuRelUsersList() {
        return menuRelUsersList;
    }

    public void setMenuRelUsersList(List<MenuRelUsers> menuRelUsersList) {
        this.menuRelUsersList = menuRelUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
