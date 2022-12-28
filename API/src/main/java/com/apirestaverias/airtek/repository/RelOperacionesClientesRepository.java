/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

/**
 *
 * @author e.colina
 */

import com.apirestaverias.airtek.model.relacionales.RelOperacionesClientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelOperacionesClientesRepository extends JpaRepository<RelOperacionesClientes, Integer> {
    
    @Query(value = "SELECT * FROM relacionales.rel_operaciones_clientes WHERE id_operacion=:id_operacion", nativeQuery=true)
    public List<RelOperacionesClientes> buscarRelOperacionesClientessByIdOperacion(Integer id_operacion);
}

