/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.airtek.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface PlanesRepository extends JpaRepository<Planes, Integer>{
    
    @Query(value = "SELECT * FROM airtek.planes WHERE id_plan=:id_plan", nativeQuery=true)
    public Planes buscarPlanById(Integer id_plan);
}
