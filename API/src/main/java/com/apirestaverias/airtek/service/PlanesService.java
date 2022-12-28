/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.Planes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirestaverias.airtek.repository.PlanesRepository;

/**
 *
 * @author e.colina
 */

@Service
public class PlanesService {
    
    
    @Autowired
    PlanesRepository planRepository;
    
    public Planes buscarPlanById(Integer id_plan){
        
        return planRepository.buscarPlanById(id_plan);  
    }
    
}
