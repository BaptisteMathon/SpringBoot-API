package com.api_etudiant.example.demo.repository;

import com.api_etudiant.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}