package com.culysoft.usermodule.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;

import org.springframework.core.env.Environment;

import java.util.function.Function;

@Component
public class JWTUtil {

    private final String SECRET_KEY="spring.security.oauth2.resourceserver.jwt.public-key-location";

    @Autowired
    private Environment environment;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));
    }
    
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(Keys.hmacShaKeyFor(environment.getRequiredProperty(SECRET_KEY).getBytes()))
                .build()
                .parseClaimsJws(token).getBody();
    }
}
