/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.clientes.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
    
    @Query(value = "SELECT * FROM clientes.clientes WHERE identificacion=:identificacion AND tipo_identificacion=:tipo_identificacion", nativeQuery=true)
    public Clientes buscarClienteByIdentificacion(Integer identificacion, int tipo_identificacion);
    
}
