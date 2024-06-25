package edu.fbansept.demo.dao;

import edu.fbansept.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

}
