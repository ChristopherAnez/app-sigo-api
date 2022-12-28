/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.operaciones.OperacionesStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface OperacionesStatusRespository extends JpaRepository<OperacionesStatus, Integer>{
    
    @Query(value = "SELECT ope_sta.id_operacion_status, ope_sta.id_operacion, ope_sta.codigo_status, ope_sta.fecha, \n" +
"	ope_sta.comentarios, ope_sta.fecha_registro, ope_sta.fecha_actualizacion, ope_sta.usuario \n" +
"	FROM operaciones.operaciones_status ope_sta\n" +
"	INNER JOIN operaciones.operaciones ope  ON\n" +
"	ope.id_operacion = ope_sta.id_operacion AND ope.codigo_status = ope_sta.codigo_status\n" +
"	WHERE ope_sta.fecha BETWEEN '2022-12-25 00:00:00' AND '2022-12-26 23:59:59'", nativeQuery=true)
    public List<OperacionesStatus> buscarOperacionesStatusByFecha();
    
}
