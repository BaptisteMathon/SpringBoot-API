package com.api_etudiant.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.api_etudiant.example.demo.entity.Rapport;
import com.api_etudiant.example.demo.services.RapportServices;

@RestController
@RequestMapping("/reports")
public class RapportController {

    @Autowired
    private RapportServices reportServices;
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<Rapport> getAverageForCourse(@PathVariable Long courseId){
        double moyenne = reportServices.getAverageByCourse(courseId);
        return ResponseEntity.ok(new Rapport(moyenne));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Rapport> getAverageForStudent(@PathVariable Long studentId){
        double moyenne = reportServices.getAverageByStudent(studentId);
        return ResponseEntity.ok(new Rapport(moyenne));
    }
}
