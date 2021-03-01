package com.project.utils;

import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// marking JwtUtil class as component
@Component
public class JwtUtil{

    private final String secret = "secret";

    // Method for to get the username from the token
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    // Method for to get the expiration date from the token
    public Date getExpirationDateFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
    }

    // Method to check whether the token is expired or not
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Method to generate token
    public String generateToken(UserDetails user) {
        long token_validity = 5 * 60 * 60;
        return Jwts.builder().setClaims(null).setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + token_validity * 1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    // Method to validate token by matching the stored username and username got from the token
    public Boolean validateToken(String token, UserDetails user) {
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
