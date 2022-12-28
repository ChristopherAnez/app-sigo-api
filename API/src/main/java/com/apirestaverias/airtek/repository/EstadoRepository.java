/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.airtek.Estados;
import com.apirestaverias.airtek.model.airtek.EstadosPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface EstadoRepository extends JpaRepository<Estados, Short>{
    
    @Query(value = "SELECT * FROM airtek.estados WHERE codigo_estado=:codigo_estado", nativeQuery=true)
    public Estados buscarEstadoByCodigoEstado(Short codigo_estado);
    
}
