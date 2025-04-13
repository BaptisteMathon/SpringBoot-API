package com.api_etudiant.example.demo.controller;

import com.api_etudiant.example.demo.entity.Student;
import com.api_etudiant.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
// import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class StudentController {
    // private List<Student> students = new ArrayList<>();

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List <Student> getAllStudents() {
        // return students;
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@Valid @PathVariable Long id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            if(studentDetails.getPrenom() != null) {
                student.setPrenom(studentDetails.getPrenom());
            }

            if(studentDetails.getNom() != null) {
                student.setNom(studentDetails.getNom());
            }

            if(studentDetails.getEmail() != null) {
                student.setEmail(studentDetails.getEmail());
            }

            if(studentDetails.getAge() != null) {
                student.setAge(studentDetails.getAge());
            }

            studentRepository.save(student);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        boolean exists = studentRepository.existsById(id);
        if(exists) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}