/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirestaverias.airtek.repository;

import com.apirestaverias.airtek.model.airtek.Estados;
import com.apirestaverias.airtek.model.airtek.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author e.colina
 */

@Repository
public interface SucursalRepository extends JpaRepository<Sucursales, Short>{
    
    @Query(value = "SELECT * FROM airtek.sucursales WHERE codigo_sucursal=:codigo_sucursal", nativeQuery=true)
    public Sucursales buscarSucursalByCodigoSucursal(Short codigo_sucursal);
    
}
