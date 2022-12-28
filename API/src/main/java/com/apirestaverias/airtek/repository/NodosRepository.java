/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.tecnologia.Nodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface NodosRepository extends JpaRepository<Nodos, Integer>{
    
    @Query(value = "SELECT * FROM tecnologia.nodos WHERE codigo_nodo=:codigo_nodo", nativeQuery=true)
    public Nodos buscarNodoByCodigoNodo(Integer codigo_nodo);
    
}
