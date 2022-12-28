/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.controller;

import com.apirestaverias.airtek.dto.EditUserForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirestaverias.airtek.dto.LogOutRequest;
import com.apirestaverias.airtek.dto.SignUpForm;
import com.apirestaverias.airtek.event.OnUserLogoutSuccessEvent;
import com.apirestaverias.airtek.exception.ResourceNotFoundException;
import com.apirestaverias.airtek.exception.UserLogoutException;
import com.apirestaverias.airtek.model.Menu;
import com.apirestaverias.airtek.model.MenuRelUsers;
import com.apirestaverias.airtek.model.Role;
import com.apirestaverias.airtek.model.RoleName;
import com.apirestaverias.airtek.model.User;
import com.apirestaverias.airtek.model.UserDevice;
import com.apirestaverias.airtek.model.airtek.Paises;
import com.apirestaverias.airtek.repository.RoleRepository;
import com.apirestaverias.airtek.repository.UserRepository;
import com.apirestaverias.airtek.response.ApiResponse;
import com.apirestaverias.airtek.response.ResponseUserMe;
import com.apirestaverias.airtek.response.ResponseUserMenu;
import com.apirestaverias.airtek.response.UserProfile;
import com.apirestaverias.airtek.service.CurrentUser;
import com.apirestaverias.airtek.service.PaisesService;
import com.apirestaverias.airtek.service.RefreshTokenService;
import com.apirestaverias.airtek.service.UserDeviceService;
import com.apirestaverias.airtek.service.UserPrincipal;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
        
    @Autowired
    private RefreshTokenService refreshTokenService;
    
    @Autowired
    private UserDeviceService userDeviceService;
    
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    RoleRepository roleRepository;
    
    /*@Autowired
    PaisesService paisesService;*/

    @GetMapping("/me")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('ADMINTECH') or hasRole('SUPERVISOR') or hasRole('SUPERADMIN')")
    public ResponseUserMe getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
              
        //List<Paises> a = paisesService.buscarPaises();
        
        ResponseUserMe responseUserMe = new ResponseUserMe();
        ArrayList<ResponseUserMenu> responseUserMenu = new ArrayList<>();  
        
        User user = userRepository.findCurrentUserById(userPrincipal.getId());
        
        responseUserMe.setId(user.getId());
        responseUserMe.setEmail(user.getEmail());
        responseUserMe.setUsername(user.getUsername());
        responseUserMe.setName(user.getName());
        responseUserMe.setActive(user.getActive());
        responseUserMe.setRole(user.getRoles().toString());
        
        for (Role rol : user.getRoles()) {
            responseUserMe.setRole(rol.getName().name());   
            
            for (Menu menu : rol.getMenuList()) {
     
                ResponseUserMenu item = new ResponseUserMenu();

                //Comprobamos si hay un elemento menu critico para este rol si hay entonces lo dejamos pasar
                if(menu.getStatus().equalsIgnoreCase("2")){

                    item.setCodeDivision(menu.getCodeDivision());
                    item.setCodeFeature(menu.getCodeFeature());
                    item.setCodeModule(menu.getCodeModule());
                    item.setCodeOption(menu.getCodeOption());
                    item.setDescription(menu.getDescription());
                    item.setIdMenu(menu.getIdMenu());
                    item.setRoute(menu.getRoute());
                    item.setShorcut(menu.getShorcut());
                    
                    if(!menu.getMenuRelUsersList().isEmpty()){
                        
                        for (MenuRelUsers menuRelUsers : menu.getMenuRelUsersList()) {
                            
                            //compruebo si el ID del usuario actual esta en la tabla menu_rel_users, si esta lo autorizo si no caso contrario
                            if(menuRelUsers.getIdUser() ==  userPrincipal.getId()){
                                item.setCritico("A");
                                break;
                            } else{
                                item.setCritico("NA");
                            }
                            
                        }    
                    } else{
                        item.setCritico("NA");
                    }

                    responseUserMenu.add(item);
                }
                else if(menu.getStatus().equalsIgnoreCase("1")){

                    item.setCodeDivision(menu.getCodeDivision());
                    item.setCodeFeature(menu.getCodeFeature());
                    item.setCodeModule(menu.getCodeModule());
                    item.setCodeOption(menu.getCodeOption());
                    item.setDescription(menu.getDescription());
                    item.setIdMenu(menu.getIdMenu());
                    item.setRoute(menu.getRoute());
                    item.setShorcut(menu.getShorcut());
                    item.setCritico("A");

                    responseUserMenu.add(item);
                }       
            }
        }
        
        responseUserMe.setMenu(responseUserMenu);
        
        return responseUserMe;
            
    }

    @GetMapping("/allusers")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public List<UserProfile> getUserProfile(@RequestParam(value = "username", required = false) Optional<String> username) {
    	List<UserProfile> userProfiles = new ArrayList<>();
    	if (username.isPresent()) {
    		User user = userRepository.findByUsername(username.get())
                    .orElseThrow(() -> new ResourceNotFoundException("User", "username", username.get()));
    		UserProfile userProfile = new UserProfile(user.getId(), user.getEmail(), user.getUsername(), user.getName(),  user.getActive());
    		userProfiles.add(userProfile);
    	} else {
    		List<User> users = userRepository.findAll();
    		for (User u: users) {
    			UserProfile userProfile = new UserProfile(u.getId(), u.getEmail(), u.getUsername(), u.getName(),  u.getActive());
    			userProfiles.add(userProfile);
    		}
    	}
        return userProfiles;
    }

    @GetMapping("/byID/{id}")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public User getUserProfileById(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        //UserProfile userProfile = new UserProfile(user.getId(), user.getEmail(), user.getName(), user.getActive());

        return user;
    }
    
    
    //Falta el cambio de edicion de la contraseña que se hara por otro modulo y otro endpoint
    @PutMapping("/byID/{id}/edit")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> editUserById(@PathVariable(value = "id") Long id, @Valid @RequestBody EditUserForm editUserForm){
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        
        user.setName(editUserForm.getName());
        user.setEmail(editUserForm.getEmail());
        user.setUsername(editUserForm.getUsername());
        
        if(editUserForm.getActive().equalsIgnoreCase("A"))
            user.activate();
        else if(editUserForm.getActive().equalsIgnoreCase("I"))
            user.desactivate();
        
        Set<String> strRoles = editUserForm.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
            case "administrador":
                Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                      .orElseThrow(() -> new RuntimeException("Fallo! editUserById() -> Causa: Usuario Rol no encontrado"));
                roles.add(adminRole);
            
            break;
            case "supervisor":
                Role supervisorRole = roleRepository.findByName(RoleName.ROLE_SUPERVISOR)
                  .orElseThrow(() -> new RuntimeException("Fallo! editUserById() -> Causa: Usuario Rol no encontrado"));
                roles.add(supervisorRole);
                
            break;
            
            case "usuario":
                Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                  .orElseThrow(() -> new RuntimeException("Fallo! editUserById() -> Causa: Usuario Rol no encontrado"));
                roles.add(userRole);
                
            break;
            
            case "administrador_tecnico":
                Role adminTechRole = roleRepository.findByName(RoleName.ROLE_ADMINTECH)
                  .orElseThrow(() -> new RuntimeException("Fallo! editUserById() -> Causa: Usuario Rol no encontrado"));
                roles.add(adminTechRole);
                
            break;
            
            case "super_administrador":
                Role superAdminRole = roleRepository.findByName(RoleName.ROLE_SUPERADMIN)
                  .orElseThrow(() -> new RuntimeException("Fallo! editUserById() -> Causa: Usuario Rol no encontrado"));
                roles.add(superAdminRole);
                
            break;
          }
        });
        
        user.setRoles(roles);
        
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario editado Exitosamente!"));  
    }

    @PutMapping("/byID/{id}/desactivate")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> desactivateUserById(@PathVariable(value = "id") Long id) {
    	User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.desactivate();
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario desactivado Exitosamente!"));  
    }

    @PutMapping("/byID/{id}/activate")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> activateUserById(@PathVariable(value = "id") Long id) {
       User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.activate();
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario activado Exitosamente!"));
    }

    @DeleteMapping("/byID/{id}")
    @PreAuthorize("hasRole('ADMINTECH') or hasRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "id") Long id) {
    	User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario elimnado Exitosamente!"));
    }
        
    @PutMapping("/logout")
    public ResponseEntity<ApiResponse> logoutUser(@CurrentUser UserPrincipal currentUser,
    		@Valid @RequestBody LogOutRequest logOutRequest) {
        String deviceId = logOutRequest.getDeviceInfo().getDeviceId();
        UserDevice userDevice = userDeviceService.findByUserId(currentUser.getId())
                .filter(device -> device.getDeviceId().equals(deviceId))
                .orElseThrow(() -> new UserLogoutException(logOutRequest.getDeviceInfo().getDeviceId(), "Invalid device Id supplied. No matching device found for the given user "));
        refreshTokenService.deleteById(userDevice.getRefreshToken().getId());
        
        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(currentUser.getUsername(), logOutRequest.getToken(), logOutRequest);
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario deslogeado del sistema!"));
    }

}
