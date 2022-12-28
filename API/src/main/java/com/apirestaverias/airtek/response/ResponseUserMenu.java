/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.response;

/**
 *
 * @author e.colina
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserMenu {
    
    private Integer idMenu;
    private int codeModule;
    private int codeDivision;
    private int codeOption;
    private int codeFeature;
    private String description;
    private String shorcut;
    private String route;
    private String critico;
}
