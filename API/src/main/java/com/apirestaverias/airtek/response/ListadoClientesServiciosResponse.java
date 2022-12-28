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
public class ListadoClientesServiciosResponse {
    
    private String idClienteServicio;
    private String nombreServicio;
    private String nodo;
    private String coordenada;
    private String tecnologia;
    private String estadoServicio;
    private String direccionServicio;
    
}
