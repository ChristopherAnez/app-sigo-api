/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.model.clientes;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author e.colina
 */
@Entity
@Table(name = "clientes_servicios", schema = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesServicios.findAll", query = "SELECT c FROM ClientesServicios c"),
    @NamedQuery(name = "ClientesServicios.findByIdClienteServicio", query = "SELECT c FROM ClientesServicios c WHERE c.idClienteServicio = :idClienteServicio"),
    @NamedQuery(name = "ClientesServicios.findByCodigoSucursal", query = "SELECT c FROM ClientesServicios c WHERE c.codigoSucursal = :codigoSucursal"),
    @NamedQuery(name = "ClientesServicios.findByCodigoCliente", query = "SELECT c FROM ClientesServicios c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "ClientesServicios.findByCodigoNodo", query = "SELECT c FROM ClientesServicios c WHERE c.codigoNodo = :codigoNodo"),
    @NamedQuery(name = "ClientesServicios.findByCodigoOlt", query = "SELECT c FROM ClientesServicios c WHERE c.codigoOlt = :codigoOlt"),
    @NamedQuery(name = "ClientesServicios.findByTarjetaOlt", query = "SELECT c FROM ClientesServicios c WHERE c.tarjetaOlt = :tarjetaOlt"),
    @NamedQuery(name = "ClientesServicios.findBySlotTarjetaOlt", query = "SELECT c FROM ClientesServicios c WHERE c.slotTarjetaOlt = :slotTarjetaOlt"),
    @NamedQuery(name = "ClientesServicios.findByCodigoMdt", query = "SELECT c FROM ClientesServicios c WHERE c.codigoMdt = :codigoMdt"),
    @NamedQuery(name = "ClientesServicios.findByCodigoNap", query = "SELECT c FROM ClientesServicios c WHERE c.codigoNap = :codigoNap"),
    @NamedQuery(name = "ClientesServicios.findByPuertoNap", query = "SELECT c FROM ClientesServicios c WHERE c.puertoNap = :puertoNap"),
    @NamedQuery(name = "ClientesServicios.findByCodigoOnt", query = "SELECT c FROM ClientesServicios c WHERE c.codigoOnt = :codigoOnt"),
    @NamedQuery(name = "ClientesServicios.findByUbicacionServicio", query = "SELECT c FROM ClientesServicios c WHERE c.ubicacionServicio = :ubicacionServicio"),
    @NamedQuery(name = "ClientesServicios.findByMacAddress", query = "SELECT c FROM ClientesServicios c WHERE c.macAddress = :macAddress"),
    @NamedQuery(name = "ClientesServicios.findByCodigoPais", query = "SELECT c FROM ClientesServicios c WHERE c.codigoPais = :codigoPais"),
    @NamedQuery(name = "ClientesServicios.findByCodigoEstado", query = "SELECT c FROM ClientesServicios c WHERE c.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "ClientesServicios.findByCodigoMunicipio", query = "SELECT c FROM ClientesServicios c WHERE c.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "ClientesServicios.findByDireccionServicio", query = "SELECT c FROM ClientesServicios c WHERE c.direccionServicio = :direccionServicio"),
    @NamedQuery(name = "ClientesServicios.findByCoordenadas", query = "SELECT c FROM ClientesServicios c WHERE c.coordenadas = :coordenadas"),
    @NamedQuery(name = "ClientesServicios.findByLatitud", query = "SELECT c FROM ClientesServicios c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "ClientesServicios.findByLongitud", query = "SELECT c FROM ClientesServicios c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "ClientesServicios.findByIdPlan", query = "SELECT c FROM ClientesServicios c WHERE c.idPlan = :idPlan"),
    @NamedQuery(name = "ClientesServicios.findByUserServicio", query = "SELECT c FROM ClientesServicios c WHERE c.userServicio = :userServicio"),
    @NamedQuery(name = "ClientesServicios.findByTipoServicio", query = "SELECT c FROM ClientesServicios c WHERE c.tipoServicio = :tipoServicio"),
    @NamedQuery(name = "ClientesServicios.findByStatusServicio", query = "SELECT c FROM ClientesServicios c WHERE c.statusServicio = :statusServicio"),
    @NamedQuery(name = "ClientesServicios.findByFechaRegistro", query = "SELECT c FROM ClientesServicios c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ClientesServicios.findByFechaActualizacion", query = "SELECT c FROM ClientesServicios c WHERE c.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "ClientesServicios.findByUsuario", query = "SELECT c FROM ClientesServicios c WHERE c.usuario = :usuario")})
public class ClientesServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_servicio")
    private Integer idClienteServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_sucursal")
    private short codigoSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_cliente")
    private int codigoCliente;
    @Column(name = "codigo_nodo")
    private Short codigoNodo;
    @Column(name = "codigo_olt")
    private Integer codigoOlt;
    @Column(name = "tarjeta_olt")
    private Short tarjetaOlt;
    @Column(name = "slot_tarjeta_olt")
    private Short slotTarjetaOlt;
    @Column(name = "codigo_mdt")
    private Integer codigoMdt;
    @Column(name = "codigo_nap")
    private Integer codigoNap;
    @Column(name = "puerto_nap")
    private Short puertoNap;
    @Column(name = "codigo_ont")
    private BigInteger codigoOnt;
    @Size(max = 30)
    @Column(name = "ubicacion_servicio")
    private String ubicacionServicio;
    @Size(max = 30)
    @Column(name = "mac_address")
    private String macAddress;
    @Column(name = "codigo_pais")
    private Short codigoPais;
    @Column(name = "codigo_estado")
    private Short codigoEstado;
    @Column(name = "codigo_municipio")
    private Short codigoMunicipio;
    @Size(max = 100)
    @Column(name = "direccion_servicio")
    private String direccionServicio;
    @Size(max = 50)
    @Column(name = "coordenadas")
    private String coordenadas;
    @Size(max = 30)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 30)
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "id_plan")
    private Short idPlan;
    @Size(max = 30)
    @Column(name = "user_servicio")
    private String userServicio;
    @Column(name = "tipo_servicio")
    private Short tipoServicio;
    @Column(name = "status_servicio")
    private Short statusServicio;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public ClientesServicios() {
    }

    public ClientesServicios(Integer idClienteServicio) {
        this.idClienteServicio = idClienteServicio;
    }

    public ClientesServicios(Integer idClienteServicio, short codigoSucursal, int codigoCliente) {
        this.idClienteServicio = idClienteServicio;
        this.codigoSucursal = codigoSucursal;
        this.codigoCliente = codigoCliente;
    }

    public Integer getIdClienteServicio() {
        return idClienteServicio;
    }

    public void setIdClienteServicio(Integer idClienteServicio) {
        this.idClienteServicio = idClienteServicio;
    }

    public short getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(short codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Short getCodigoNodo() {
        return codigoNodo;
    }

    public void setCodigoNodo(Short codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public Integer getCodigoOlt() {
        return codigoOlt;
    }

    public void setCodigoOlt(Integer codigoOlt) {
        this.codigoOlt = codigoOlt;
    }

    public Short getTarjetaOlt() {
        return tarjetaOlt;
    }

    public void setTarjetaOlt(Short tarjetaOlt) {
        this.tarjetaOlt = tarjetaOlt;
    }

    public Short getSlotTarjetaOlt() {
        return slotTarjetaOlt;
    }

    public void setSlotTarjetaOlt(Short slotTarjetaOlt) {
        this.slotTarjetaOlt = slotTarjetaOlt;
    }

    public Integer getCodigoMdt() {
        return codigoMdt;
    }

    public void setCodigoMdt(Integer codigoMdt) {
        this.codigoMdt = codigoMdt;
    }

    public Integer getCodigoNap() {
        return codigoNap;
    }

    public void setCodigoNap(Integer codigoNap) {
        this.codigoNap = codigoNap;
    }

    public Short getPuertoNap() {
        return puertoNap;
    }

    public void setPuertoNap(Short puertoNap) {
        this.puertoNap = puertoNap;
    }

    public BigInteger getCodigoOnt() {
        return codigoOnt;
    }

    public void setCodigoOnt(BigInteger codigoOnt) {
        this.codigoOnt = codigoOnt;
    }

    public String getUbicacionServicio() {
        return ubicacionServicio;
    }

    public void setUbicacionServicio(String ubicacionServicio) {
        this.ubicacionServicio = ubicacionServicio;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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

    public String getDireccionServicio() {
        return direccionServicio;
    }

    public void setDireccionServicio(String direccionServicio) {
        this.direccionServicio = direccionServicio;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Short getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Short idPlan) {
        this.idPlan = idPlan;
    }

    public String getUserServicio() {
        return userServicio;
    }

    public void setUserServicio(String userServicio) {
        this.userServicio = userServicio;
    }

    public Short getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Short tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Short getStatusServicio() {
        return statusServicio;
    }

    public void setStatusServicio(Short statusServicio) {
        this.statusServicio = statusServicio;
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

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteServicio != null ? idClienteServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesServicios)) {
            return false;
        }
        ClientesServicios other = (ClientesServicios) object;
        if ((this.idClienteServicio == null && other.idClienteServicio != null) || (this.idClienteServicio != null && !this.idClienteServicio.equals(other.idClienteServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirestaverias.airtek.model.clientes.ClientesServicios[ idClienteServicio=" + idClienteServicio + " ]";
    }
    
}
