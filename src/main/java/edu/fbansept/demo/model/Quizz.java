package edu.fbansept.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 50)
    @Column(length = 50)
    protected String nom;

    @Min(1)
    @Max(5)
    protected int niveau;

    @ManyToOne(optional = false)
    protected Utilisateur createur;

    @ManyToMany
    @JoinTable(
            name = "categorie_quizz",
            joinColumns = @JoinColumn(name = "quizz_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    protected List<Categorie> listeCategorie;

}
