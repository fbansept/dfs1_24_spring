package edu.fbansept.demo.controller;

import edu.fbansept.demo.dao.UtilisateurDao;
import edu.fbansept.demo.model.Utilisateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/liste")
    public List<Utilisateur> liste() {
        return utilisateurDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUtilisateur.get(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Utilisateur> add(@RequestBody @Valid Utilisateur utilisateur) {
        utilisateur.setId(null);
        utilisateurDao.save(utilisateur);
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> update(
            @PathVariable int id,
            @RequestBody @Valid Utilisateur utilisateur) {
        utilisateur.setId(id);

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Utilisateur> delete(@PathVariable int id) {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if(optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        utilisateurDao.deleteById(id);

        return new ResponseEntity<>(optionalUtilisateur.get(), HttpStatus.OK);
    }

}
