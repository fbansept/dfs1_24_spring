package edu.fbansept.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtUtils {

    @Value("${secret.jwt}")
    public String secretJwt;

    public String generateToken(UserDetails userDetails) {

        SimpleGrantedAuthority role = (SimpleGrantedAuthority)userDetails.getAuthorities().toArray()[0];

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretJwt)
                .setSubject(userDetails.getUsername())
                .addClaims(Map.of("admin", role.getAuthority().equals("ROLE_ADMIN") ? 1 : 0))
                .compact();
    }

    public String getSubjectFromJwt(String jwt) {

        return Jwts.parser()
                .setSigningKey(secretJwt)
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

}
