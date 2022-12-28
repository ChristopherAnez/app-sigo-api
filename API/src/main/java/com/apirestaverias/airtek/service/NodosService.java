/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.tecnologia.Nodos;
import com.apirestaverias.airtek.repository.NodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class NodosService {
    
    
    @Autowired
    NodosRepository nodosRepository;
    
    public Nodos buscarNodoByCodigoNodo(Integer codigo_nodo){
        
        return nodosRepository.buscarNodoByCodigoNodo(codigo_nodo);
    }
    
}
