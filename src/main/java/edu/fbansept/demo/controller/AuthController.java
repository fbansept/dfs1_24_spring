package edu.fbansept.demo.controller;

import edu.fbansept.demo.dao.UtilisateurDao;
import edu.fbansept.demo.model.Utilisateur;
import edu.fbansept.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UtilisateurDao utilisateurDao;

    @PostMapping("/connexion")
    public ResponseEntity<Map<String, Object>> connexion(@RequestBody Utilisateur utilisateur) {

        try {
            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getEmail(),
                            utilisateur.getPassword())).getPrincipal();

            return new ResponseEntity<>(Map.of("jwt",jwtUtils.generateToken(userDetails)), HttpStatus.OK);

        } catch (AuthenticationException ex) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/inscription")
    public ResponseEntity<Map<String, Object>> inscription (@RequestBody Utilisateur utilisateur) {

        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword()));

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(Map.of("message","utilisateur créé"), HttpStatus.CREATED);

    }

}
