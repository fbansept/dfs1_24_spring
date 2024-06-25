package edu.fbansept.demo.controller;

import edu.fbansept.demo.dao.UtilisateurDao;
import edu.fbansept.demo.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/liste")
    public List<Utilisateur> liste() {
        return utilisateurDao.findAll();
    }

    @GetMapping("/utilisateur")
    public Utilisateur get() {

        Utilisateur franck = new Utilisateur();
        franck.setId(4);
        franck.setEmail("a@a.com");
        franck.setPassword("root");

        return franck;
    }

    @PostMapping("/utilisateur")
    public boolean add(@RequestBody Utilisateur utilisateur) {

        return true;
    }

}
