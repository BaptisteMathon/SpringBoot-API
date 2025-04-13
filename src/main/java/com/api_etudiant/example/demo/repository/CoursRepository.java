package com.api_etudiant.example.demo.repository;

import com.api_etudiant.example.demo.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    
}
