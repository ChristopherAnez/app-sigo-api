/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;


import com.apirestaverias.airtek.model.clientes.ClientesServicios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface ClientesServiciosRepository extends JpaRepository<ClientesServicios, Integer>{

    @Query(value = "SELECT * FROM clientes.clientes_servicios WHERE id_cliente_servicio=:id_cliente_servicio", nativeQuery=true)
    public List<ClientesServicios> findAllById(Integer id_cliente_servicio);
    
}
