/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.TiposServicios;
import com.apirestaverias.airtek.repository.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class TiposServiciosService {
    
    @Autowired
    TipoServicioRepository tipoServicioRepository;
    
    public TiposServicios buscarTipoServicioById(Integer id_tipo_servicio){
        return tipoServicioRepository.buscarTipoServicioById(id_tipo_servicio);
    }
    
}
