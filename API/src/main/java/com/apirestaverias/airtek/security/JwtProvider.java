/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirestaverias.airtek.security;

import java.security.SignatureException;
import java.time.Instant;
import java.util.Date;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.apirestaverias.airtek.cache.LoggedOutJwtTokenCache;
import com.apirestaverias.airtek.event.OnUserLogoutSuccessEvent;
import com.apirestaverias.airtek.exception.InvalidTokenRequestException;
import com.apirestaverias.airtek.model.User;
import com.apirestaverias.airtek.service.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtProvider {
    
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;
        
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Autowired
    private LoggedOutJwtTokenCache loggedOutJwtTokenCache;
 
    public String generateJwtToken(Authentication authentication) {
 
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
 
        return Jwts.builder()
                    .setSubject((userPrincipal.getUsername()))
                    .setIssuer("StackAbuse")
                    .setId(Long.toString(userPrincipal.getId()))
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
    }
    
    public String generateTokenFromUser(User user) {
        Instant expiryDate = Instant.now().plusMillis(jwtExpirationInMs);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer("Therapex")
                .setId(Long.toString(user.getId()))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(expiryDate))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
 
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                      .setSigningKey(jwtSecret)
                      .parseClaimsJws(token)
                      .getBody().getSubject();
    }
    
    public Date getTokenExpiryFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }
 
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            validateTokenIsNotForALoggedOutDevice(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("JWT Invalido token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("JWT Expirado token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("JWT Sin soporte token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string esta vacia -> Message: {}", e);
        }
        
        return false;
    }
    
    private void validateTokenIsNotForALoggedOutDevice(String authToken) {
        OnUserLogoutSuccessEvent previouslyLoggedOutEvent = loggedOutJwtTokenCache.getLogoutEventForToken(authToken);
        if (previouslyLoggedOutEvent != null) {
            String username = previouslyLoggedOutEvent.getUsername();
            Date logoutEventDate = previouslyLoggedOutEvent.getEventTime();
            String errorMessage = String.format("Token corresponds to an already logged out user [%s] at [%s]. Please login again", username, logoutEventDate);
            throw new InvalidTokenRequestException("JWT", authToken, errorMessage);
        }
    }
    
    public long getExpiryDuration() {
        return jwtExpirationInMs;
    }
}
