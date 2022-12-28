/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.StatusOperacion;
import com.apirestaverias.airtek.model.operaciones.OperacionesStatus;
import com.apirestaverias.airtek.model.relacionales.RelOperacionesClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.apirestaverias.airtek.repository.OperacionesRepository;
import com.apirestaverias.airtek.repository.OperacionesStatusRespository;
import com.apirestaverias.airtek.repository.RelOperacionesClientesRepository;

/**
 *
 * @author e.colina
 */

//Esta clase va a contener todos los servicios relacionados a Operaciones

@Service
public class OperacionesService {
    
    @Autowired
    private OperacionesRepository operacionesRepository;
    
    @Autowired
    private OperacionesStatusRespository operacionesStatusRespository;
    
    @Autowired
    private RelOperacionesClientesRepository relOperacionesClientesRepository;
    
    public List<StatusOperacion> buscarStatusOperacion() {
        return operacionesRepository.findAll();
    }
    
    public List<StatusOperacion> buscarStatusOperacionByIdTipoOperacion(Integer id) {
        return operacionesRepository.buscarStatusOperacionByIdTipoOperacion(id);
    }
    
    public String buscarStatusOperacionDescripcionByCodigoStatus(Integer codigo_status) {
        return operacionesRepository.buscarStatusOperacionDescripcionByCodigoStatus(codigo_status);
    }
    
    public List<OperacionesStatus> buscarOperacionesStatusByFecha(){      
        return operacionesStatusRespository.buscarOperacionesStatusByFecha();
    }
    
    public List<RelOperacionesClientes> buscarRelOperacionesClientessByIdOperacion(Integer id_operacion){
        return relOperacionesClientesRepository.buscarRelOperacionesClientessByIdOperacion(id_operacion);
    }
}
