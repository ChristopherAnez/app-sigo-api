/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.clientes.Clientes;
import com.apirestaverias.airtek.model.clientes.ClientesServicios;
import com.apirestaverias.airtek.repository.ClientesRepository;
import com.apirestaverias.airtek.repository.ClientesServiciosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class ClientesService {
    
    @Autowired
    ClientesServiciosRepository clientesServiciosRepository;
    
    @Autowired
    ClientesRepository clientesRepository;
    
    public List<ClientesServicios> buscarClientesServiciosById(Integer id_cliente_servicio){
        return clientesServiciosRepository.findAllById(id_cliente_servicio);
    }
    
    public Clientes buscarClienteByIdentificacion(Integer identificacion, int tipo_identificacion){
        return clientesRepository.buscarClienteByIdentificacion(identificacion, tipo_identificacion);
    }
}
