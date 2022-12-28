/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.service;

import com.apirestaverias.airtek.model.airtek.Paises;
import com.apirestaverias.airtek.repository.PaisesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e.colina
 */

@Service
public class PaisesService {
    
    @Autowired
    private PaisesRepository paisesRepository;
    
    public List<Paises> buscarPaises() {
        return paisesRepository.findAll();
    }
    
}
