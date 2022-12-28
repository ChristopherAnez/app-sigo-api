/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author e.colina
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResquest {
    
    @NotBlank
    @Size(min=6, max = 20)
    @NotNull(message = "La identificacion no puede estar vacio")
    private String identificacion;
 
    @NotBlank
    @Size(max = 2)
    @NotNull(message = "El tipo de identificacion no puede estar vacio")
    private String tipo_identificacion;
}
