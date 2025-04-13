package com.api_etudiant.example.demo.repository;

import com.api_etudiant.example.demo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByStudentId(Long studentId);
    List<Notes> findByCoursId(Long coursId);
}