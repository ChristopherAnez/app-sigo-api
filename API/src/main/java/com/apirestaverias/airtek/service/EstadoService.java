/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.Estados;
import com.apirestaverias.airtek.model.airtek.EstadosPK;
import com.apirestaverias.airtek.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class EstadoService {
    
    @Autowired
    EstadoRepository estadoRepository;
    
    public Estados buscarEstadoByCodigoEstado(Short codigo_estado){
      
        return estadoRepository.buscarEstadoByCodigoEstado(codigo_estado);
    }
}
