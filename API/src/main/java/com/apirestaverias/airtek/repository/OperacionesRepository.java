/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

/**
 *
 * @author e.colina
 */

import com.apirestaverias.airtek.model.airtek.StatusOperacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author e.colina
 */

@Repository
public interface OperacionesRepository extends JpaRepository<StatusOperacion, Integer>
{
    @Query(value = "SELECT * FROM airtek.status_operacion WHERE id_tipo_operacion=:id", nativeQuery=true)
    public List<StatusOperacion> buscarStatusOperacionByIdTipoOperacion(Integer id);
    
    @Query(value = "SELECT descripcion FROM airtek.status_operacion WHERE codigo_status=:codigo_status", nativeQuery=true)
    public String buscarStatusOperacionDescripcionByCodigoStatus(Integer codigo_status);
    
}
