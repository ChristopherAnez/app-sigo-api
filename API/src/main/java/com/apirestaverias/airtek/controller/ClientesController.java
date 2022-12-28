/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.controller;

import com.apirestaverias.airtek.dto.ClienteResquest;
import com.apirestaverias.airtek.model.clientes.Clientes;
import com.apirestaverias.airtek.model.clientes.ClientesServicios;
import com.apirestaverias.airtek.response.ClienteResponse;
import com.apirestaverias.airtek.response.ListadoClientesServiciosResponse;
import com.apirestaverias.airtek.service.ClientesService;
import com.apirestaverias.airtek.service.EstadoService;
import com.apirestaverias.airtek.service.NodosService;
import com.apirestaverias.airtek.service.PlanesService;
import com.apirestaverias.airtek.service.SucursalService;
import com.apirestaverias.airtek.service.TiposServiciosService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author e.colina
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/averias/clientes")
public class ClientesController {
    
    @Autowired
    ClientesService clientesService;
    
    @Autowired
    EstadoService estadoService;
    
    @Autowired
    SucursalService sucursalService;
    
    @Autowired
    PlanesService planService;
    
    @Autowired
    TiposServiciosService tiposServiciosService;
    
    @Autowired
    NodosService nodosService;
    
    //Tipo_Identificacion = 1:natural, 2:juridico; identificacion = cedula de identidad
    @PostMapping("/ByIdentificacion")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('ADMINTECH') or hasRole('SUPERVISOR') or hasRole('SUPERADMIN')")
    public ClienteResponse buscarClienteByIdentificacion(@Valid @RequestBody ClienteResquest clienteResquest){
        
        ClienteResponse clienteResponse = new ClienteResponse();
        
        Clientes cliente = clientesService.buscarClienteByIdentificacion(Integer.valueOf(clienteResquest.getIdentificacion()), Integer.valueOf(clienteResquest.getTipo_identificacion()));
        
        clienteResponse.setIdCliente(cliente.getIdCliente().toString());
        clienteResponse.setCodigoCliente(String.valueOf(cliente.getCodigoCliente()));
        clienteResponse.setNombreApellido(cliente.getPrimerNombre() + " " + cliente.getPrimerApellido());
        clienteResponse.setDireccion(cliente.getDireccion());
        clienteResponse.setEstado(estadoService.buscarEstadoByCodigoEstado(cliente.getCodigoEstado()).getDescripcion());
        clienteResponse.setSucursal(sucursalService.buscarSucursalByCodigoSucursal(cliente.getCodigoSucursal()).getDescripcion()); // hacer lo mismo
        clienteResponse.setCorreoElectronico(cliente.getEmail());
        clienteResponse.setTelefono(cliente.getTelefono().toString());
        
        List<ListadoClientesServiciosResponse> servicios = new ArrayList<>();
        
        for (ClientesServicios item : cliente.getClientesServiciosList()) {
            
            
            //Preguntamos si esl estatus del clienteServicio es igual a 1 (activo)
            if(String.valueOf(item.getStatusServicio().toString()).equalsIgnoreCase("1")){
                
                ListadoClientesServiciosResponse listadoClientesServiciosResponse = new ListadoClientesServiciosResponse();
            
            
                listadoClientesServiciosResponse.setIdClienteServicio(item.getIdClienteServicio().toString());
                listadoClientesServiciosResponse.setNombreServicio(item.getUserServicio() + "-" + 
                                                                   planService.buscarPlanById(Integer.valueOf(item.getIdPlan().toString())).getDescripcion() + "-" + 
                                                                   tiposServiciosService.buscarTipoServicioById(Integer.valueOf(item.getTipoServicio().toString())).getDescripcion());
                listadoClientesServiciosResponse.setCoordenada(item.getCoordenadas());
                listadoClientesServiciosResponse.setDireccionServicio(item.getDireccionServicio());
                
                if(item.getStatusServicio().toString().equalsIgnoreCase("1"))
                    listadoClientesServiciosResponse.setEstadoServicio("Activo");  
                else
                    listadoClientesServiciosResponse.setEstadoServicio("Inactivo");  
                listadoClientesServiciosResponse.setNodo(nodosService.buscarNodoByCodigoNodo(Integer.valueOf(item.getCodigoNodo().toString())).getNombre());
                listadoClientesServiciosResponse.setTecnologia(tiposServiciosService.buscarTipoServicioById(Integer.valueOf(item.getTipoServicio().toString())).getDescripcion());   

                servicios.add(listadoClientesServiciosResponse); 

            }
            
        }
        
        clienteResponse.setServicio(servicios);   
        
        return clienteResponse;
    }
}
