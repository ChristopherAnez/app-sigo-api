/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apirestaverias.airtek.dto.LoginForm;
import com.apirestaverias.airtek.dto.SignUpForm;
import com.apirestaverias.airtek.dto.TokenRefreshRequest;
import com.apirestaverias.airtek.exception.TokenRefreshException;
import com.apirestaverias.airtek.model.RefreshToken;
import com.apirestaverias.airtek.model.Role;
import com.apirestaverias.airtek.model.RoleName;
import com.apirestaverias.airtek.model.User;
import com.apirestaverias.airtek.model.UserDevice;
import com.apirestaverias.airtek.repository.RoleRepository;
import com.apirestaverias.airtek.repository.UserRepository;
import com.apirestaverias.airtek.response.ApiResponse;
import com.apirestaverias.airtek.response.JwtResponse;
import com.apirestaverias.airtek.response.UserIdentityAvailability;
import com.apirestaverias.airtek.security.JwtProvider;
import com.apirestaverias.airtek.service.RefreshTokenService;
import com.apirestaverias.airtek.service.UserDeviceService;
import java.security.Principal;
import org.springframework.security.core.AuthenticationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UserRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    private RefreshTokenService refreshTokenService;
    
    @Autowired
    private UserDeviceService userDeviceService;
 
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
    	
        
        try{
            
            User user = userRepository.findByUsername(loginRequest.getUsername().toLowerCase())
    			.orElseThrow(() -> new RuntimeException("Fallo! authenticateUser() -> Causa: Usuario no encontrado."));
    	
            if (user.getActive()) {
                    Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername().toLowerCase(),
                                loginRequest.getPassword()
                        )
                ); 
                SecurityContextHolder.getContext().setAuthentication(authentication); 
                String jwtToken = jwtProvider.generateJwtToken(authentication);
                userDeviceService.findByUserId(user.getId())
                .map(UserDevice::getRefreshToken)
                .map(RefreshToken::getId)
                .ifPresent(refreshTokenService::deleteById);

                UserDevice userDevice = userDeviceService.createUserDevice(loginRequest.getDeviceInfo());
                RefreshToken refreshToken = refreshTokenService.createRefreshToken();
                userDevice.setUser(user);
                userDevice.setRefreshToken(refreshToken);
                refreshToken.setUserDevice(userDevice);
                refreshToken = refreshTokenService.save(refreshToken);
                return ResponseEntity.ok(new JwtResponse(jwtToken, refreshToken.getToken(), jwtProvider.getExpiryDuration()));
            }
            return ResponseEntity.badRequest().body(new ApiResponse(false, "El Usuario ha sido desactivado"));
            
        }catch(AuthenticationException e){
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Usuario no registrado"));
        }
    	
    }
 
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername().toLowerCase())) {
            return new ResponseEntity<String>("Fallo! registerUser() -> Usuario en Uso!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername().toLowerCase());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
 
        Set<String> strRoles = signUpRequest.getRole();
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
        user.activate();
        User result = userRepository.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();
 
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Usuario registrado Exitosamente!"));
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshJwtToken(@Valid @RequestBody TokenRefreshRequest tokenRefreshRequest) {
    	
    	String requestRefreshToken = tokenRefreshRequest.getRefreshToken();
    	
    	Optional<String> token = Optional.of(refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshToken -> {
                    refreshTokenService.verifyExpiration(refreshToken);
                    userDeviceService.verifyRefreshAvailability(refreshToken);
                    refreshTokenService.increaseCount(refreshToken);
                    return refreshToken;
                })
                .map(RefreshToken::getUserDevice)
                .map(UserDevice::getUser)
                .map(u -> jwtProvider.generateTokenFromUser(u))
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Falta el token de actualización en la base de datos. Vuelva a iniciar sesión")));
        return ResponseEntity.ok().body(new JwtResponse(token.get(), tokenRefreshRequest.getRefreshToken(), jwtProvider.getExpiryDuration()));
    }

    @GetMapping("/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }
}
