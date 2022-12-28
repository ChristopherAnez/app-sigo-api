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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperacionesStatusResponse {
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    @Size(min = 1, max = 10)
    private String codigo_status;
    
    @NotBlank
    @Size(min = 1, max = 10)
    private String num_operacion;
    
    @NotBlank
    private CoordenadasResponse coordenadas;
    
    private String primer_nombre;
    
    private String primer_apellido;
    
    private String identificacion;
}
