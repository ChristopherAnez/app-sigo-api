/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.controller;

import com.apirestaverias.airtek.dto.StatusOperacionesRequest;
import com.apirestaverias.airtek.model.airtek.StatusOperacion;
import com.apirestaverias.airtek.model.clientes.ClientesServicios;
import com.apirestaverias.airtek.model.operaciones.OperacionesStatus;
import com.apirestaverias.airtek.model.relacionales.RelOperacionesClientes;
import com.apirestaverias.airtek.response.CoordenadasResponse;
import com.apirestaverias.airtek.response.OperacionesStatusResponse;
import com.apirestaverias.airtek.response.StatusOperacionResponse;
import com.apirestaverias.airtek.service.ClientesService;
import com.apirestaverias.airtek.service.OperacionesService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/averias")
public class OperacionesController {
    
    @Autowired
    OperacionesService operacionesService;
    
    @Autowired
    ClientesService clientesService;
    
    @GetMapping("/allStatusOperaciones")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('ADMINTECH') or hasRole('SUPERVISOR') or hasRole('SUPERADMIN')")
    public List <StatusOperacionResponse> getConsultaStatusOperaciones(){
             
        List<StatusOperacionResponse> ListStatusOperacionesResponse = new ArrayList<>();
        List<StatusOperacion> statusOperacion = new ArrayList<>();
        
        statusOperacion = operacionesService.buscarStatusOperacion();
        
        for (StatusOperacion item : statusOperacion) {
            
            StatusOperacionResponse statusOperacionResponse = new StatusOperacionResponse();
            
            statusOperacionResponse.setDescripcion(item.getDescripcion());
            statusOperacionResponse.setIdStatusOp(item.getIdStatusOp());
            statusOperacionResponse.setIdTipoOperacion(item.getTiposOperaciones().getIdTipoOperacion());
            
            ListStatusOperacionesResponse.add(statusOperacionResponse);
            
        }
        
        return ListStatusOperacionesResponse;      
    
    }
    
    @PostMapping("/statusOperacionesByIdTipoOperacion")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('ADMINTECH') or hasRole('SUPERVISOR') or hasRole('SUPERADMIN')")
    public List <StatusOperacionResponse> consultaStatusOperacionesByIdTipoOperacion(@Valid @RequestBody StatusOperacionesRequest statusOperacionesRequest){
        
        List<StatusOperacionResponse> ListStatusOperacionesResponse = new ArrayList<>();
        List<StatusOperacion> statusOperacion = new ArrayList<>();
        
        statusOperacion = operacionesService.buscarStatusOperacionByIdTipoOperacion(Integer.valueOf(statusOperacionesRequest.getId_tipo_operacion()));
        
        for (StatusOperacion item : statusOperacion) {
            
            if(item.getStatus().equalsIgnoreCase("1")){
                
                StatusOperacionResponse statusOperacionResponse = new StatusOperacionResponse();
            
                statusOperacionResponse.setDescripcion(item.getDescripcion());
                statusOperacionResponse.setIdStatusOp(item.getIdStatusOp());
                statusOperacionResponse.setIdTipoOperacion(item.getTiposOperaciones().getIdTipoOperacion());

                ListStatusOperacionesResponse.add(statusOperacionResponse);
            }
        }
        
        return ListStatusOperacionesResponse;      
    
    }
    
    @PostMapping("/operacionesStatusCoordenadasByIdTipoOperacion")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('ADMINTECH') or hasRole('SUPERVISOR') or hasRole('SUPERADMIN')")
    public List <OperacionesStatusResponse> consultaOperacionesStatusCoordenadasByIdTipoOperacion(@Valid @RequestBody StatusOperacionesRequest statusOperacionesRequest){
        
        List<OperacionesStatusResponse> ListOperacionesStatusResponse = new ArrayList<>();
        List<OperacionesStatus> operacionesStatus = new ArrayList<>();
        //List<String> ListaCoordenadas = new ArrayList<>();
        
        operacionesStatus = operacionesService.buscarOperacionesStatusByFecha();
        
        for (OperacionesStatus item : operacionesStatus) {
            
            //comparamos el Id_Tipo_Operacion
            if(statusOperacionesRequest.getId_tipo_operacion().equalsIgnoreCase(String.valueOf(item.getIdOperacion().getIdTipoOperacion()))){
                
                OperacionesStatusResponse operacionesStatusResponse = new OperacionesStatusResponse();
                
                 List<RelOperacionesClientes> obj = operacionesService.buscarRelOperacionesClientessByIdOperacion(item.getIdOperacion().getIdOperacion());
                for (RelOperacionesClientes rel : obj) {
                    
                    for (ClientesServicios clientesServicios : clientesService.buscarClientesServiciosById(rel.getIdServicioCliente())) {
                         
                        CoordenadasResponse coordenadasResponse = new CoordenadasResponse();
                        coordenadasResponse.setCoordenada(clientesServicios.getCoordenadas());
                        coordenadasResponse.setLatitud(clientesServicios.getLatitud());
                        coordenadasResponse.setLongitud(clientesServicios.getLongitud());
                        
                        operacionesStatusResponse.setPrimer_nombre(clientesServicios.getIdCliente().getPrimerNombre());
                        operacionesStatusResponse.setPrimer_apellido(clientesServicios.getIdCliente().getPrimerApellido());
                        operacionesStatusResponse.setIdentificacion(clientesServicios.getIdCliente().getIdentificacion().toString());
                        operacionesStatusResponse.setCoordenadas(coordenadasResponse);

                    }        
                    
                }           
                
                operacionesStatusResponse.setDescripcion(operacionesService.buscarStatusOperacionDescripcionByCodigoStatus(item.getCodigoStatus())); // consultamos airtek.status_operacion
                operacionesStatusResponse.setNum_operacion(String.valueOf(item.getIdOperacion().getNumOperacion()));
                
                
                operacionesStatusResponse.setCodigo_status(String.valueOf(item.getCodigoStatus()));

                ListOperacionesStatusResponse.add(operacionesStatusResponse);
            }
        }
         
        return ListOperacionesStatusResponse;
    }
    
}
