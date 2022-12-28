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
public class ResponseUserMe {
    
    private Long id;
    private String email;
    private String username;
    private String name;
    private Boolean active;
    private List<ResponseUserMenu> menu;
    //private List Shorcut shorcut
    private String role;
    
}
