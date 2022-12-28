/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.clientes;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "clientes", schema = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByCodigoSucursal", query = "SELECT c FROM Clientes c WHERE c.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "Clientes.findByCodigoCliente", query = "SELECT c FROM Clientes c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Clientes.findByTipoIdentificacion", query = "SELECT c FROM Clientes c WHERE c.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "Clientes.findByIdentificacion", query = "SELECT c FROM Clientes c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "Clientes.findByPrimerNombre", query = "SELECT c FROM Clientes c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Clientes.findBySegundoNombre", query = "SELECT c FROM Clientes c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Clientes.findByPrimerApellido", query = "SELECT c FROM Clientes c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Clientes.findBySegundoApellido", query = "SELECT c FROM Clientes c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Clientes.findByCodigoPais", query = "SELECT c FROM Clientes c WHERE c.codigoPais = :codigoPais"),
    @NamedQuery(name = "Clientes.findByCodigoEstado", query = "SELECT c FROM Clientes c WHERE c.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Clientes.findByCodigoMunicipio", query = "SELECT c FROM Clientes c WHERE c.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Clientes.findByCodigoSector", query = "SELECT c FROM Clientes c WHERE c.codigoSector = :codigoSector"),
    @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email"),
    @NamedQuery(name = "Clientes.findByFechaRegistro", query = "SELECT c FROM Clientes c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Clientes.findByFechaActualizacion", query = "SELECT c FROM Clientes c WHERE c.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Clientes.findByUsuario", query = "SELECT c FROM Clientes c WHERE c.usuario = :usuario")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "codigo_sucursal")
    private Short codigoSucursal;
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;
    @Column(name = "tipo_identificacion")
    private Short tipoIdentificacion;
    @Column(name = "identificacion")
    private Integer identificacion;
    @Size(max = 20)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 20)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 20)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "codigo_pais")
    private Short codigoPais;
    @Column(name = "codigo_estado")
    private Short codigoEstado;
    @Column(name = "codigo_municipio")
    private Short codigoMunicipio;
    @Column(name = "codigo_sector")
    private Integer codigoSector;
    @Size(max = 70)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private BigInteger telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 2147483647)
    @Column(name = "usuario")
    private String usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<ClientesServicios> clientesServiciosList;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Short getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Short codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Short getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Short tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Short getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Short codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Short getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Short codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Short getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Short codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Integer getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<ClientesServicios> getClientesServiciosList() {
        return clientesServiciosList;
    }

    public void setClientesServiciosList(List<ClientesServicios> clientesServiciosList) {
        this.clientesServiciosList = clientesServiciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.clientes.Clientes[ idCliente=" + idCliente + " ]";
    }
    
}
