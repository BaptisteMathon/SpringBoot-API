package com.api_etudiant.example.demo.controller;


import com.api_etudiant.example.demo.entity.Notes;
import com.api_etudiant.example.demo.services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/grades")
public class NotesController {

    @Autowired
    private NotesServices notesServices;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Double>> getNotesByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(notesServices.getNotesByStudent(studentId));
    }

    @GetMapping("/cours/{coursId}")
    public ResponseEntity<List<Double>> getNotesByCours(@PathVariable Long coursId) {
        return ResponseEntity.ok(notesServices.getNotesByCours(coursId));
    }

    @PostMapping
    public ResponseEntity<Notes> createNotes(@RequestBody NotesDTO dto) {
        Notes notes = notesServices.createNotes(dto.studentId, dto.coursId, dto.value);
        return ResponseEntity.ok(notes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNotes(@PathVariable Long id, @RequestBody NotesUpdateDTO body) {
        Notes notes = notesServices.updateNotes(id, body.getValue());
        return ResponseEntity.ok(notes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotes(@PathVariable Long id) {
        notesServices.deleteNotes(id);
        return ResponseEntity.noContent().build();
    }
}
