/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.airtek.TiposServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface TipoServicioRepository extends JpaRepository<TiposServicios, Integer>{
    
    @Query(value = "SELECT * FROM airtek.tipos_servicios WHERE id_tipo_servicio=:id_tipo_servicio", nativeQuery=true)
    public TiposServicios buscarTipoServicioById(Integer id_tipo_servicio);
    
}
