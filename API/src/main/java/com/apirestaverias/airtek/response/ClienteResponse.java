/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.response;

/**
 *
 * @author e.colina
 */

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {
    
    private String idCliente;
    private String codigoCliente;
    private String nombreApellido;
    private String direccion;
    private String estado;
    private String sucursal;
    private String correoElectronico;
    private String telefono;
    private List<ListadoClientesServiciosResponse> Servicio;
    
}
