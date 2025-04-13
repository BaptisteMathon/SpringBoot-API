package com.api_etudiant.example.demo.controller;

import com.api_etudiant.example.demo.entity.Cours;
import com.api_etudiant.example.demo.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursController {
    
    @Autowired
    private CoursRepository coursRepository;

    @GetMapping
    public List <Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable Long id) {
        Optional<Cours> cours = coursRepository.findById(id);

        if (cours.isPresent()){
            return ResponseEntity.ok(cours.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cours> createStudent(@Valid @RequestBody Cours cours) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coursRepository.save(cours));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCours(@Valid @PathVariable Long id, @RequestBody Cours coursDetails){
        Cours cours = coursRepository.findById(id).orElse(null);
        if (cours != null) {
            if(coursDetails.getNameCours() != null) {
                cours.setNameCours(coursDetails.getNameCours());
            }

            if(coursDetails.getNameProf() != null) {
                cours.setNameProf(coursDetails.getNameProf());
            }

            coursRepository.save(cours);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCours(@PathVariable Long id){
        boolean exists = coursRepository.existsById(id);
        if (exists) {
            coursRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
