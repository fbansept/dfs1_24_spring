package edu.fbansept.demo.controller;

import edu.fbansept.demo.dao.QuizzDao;
import edu.fbansept.demo.model.Quizz;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

    @Autowired
    QuizzDao quizzDao;

    @GetMapping("/liste")
    public List<Quizz> liste() {
        return quizzDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quizz> get(@PathVariable int id) {

        Optional<Quizz> optionalQuizz = quizzDao.findById(id);

        if(optionalQuizz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalQuizz.get(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Quizz> add(@RequestBody @Valid Quizz quizz) {
        quizz.setId(null);
        quizzDao.save(quizz);
        return new ResponseEntity<>(quizz, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quizz> update(
            @PathVariable int id,
            @RequestBody @Valid Quizz quizz) {
        quizz.setId(id);

        Optional<Quizz> optionalQuizz = quizzDao.findById(id);

        if(optionalQuizz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        quizzDao.save(quizz);

        return new ResponseEntity<>(quizz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quizz> delete(@PathVariable int id) {

        Optional<Quizz> optionalQuizz = quizzDao.findById(id);

        if(optionalQuizz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        quizzDao.deleteById(id);

        return new ResponseEntity<>(optionalQuizz.get(), HttpStatus.OK);
    }

}
