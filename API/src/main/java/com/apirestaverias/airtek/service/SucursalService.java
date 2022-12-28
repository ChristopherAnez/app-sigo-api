/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.Sucursales;
import com.apirestaverias.airtek.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class SucursalService {
    
    @Autowired
    SucursalRepository sucursalRepository;
    
    public Sucursales buscarSucursalByCodigoSucursal(Short codigo_sucursal){
    
        return sucursalRepository.buscarSucursalByCodigoSucursal(codigo_sucursal);
    }
}
