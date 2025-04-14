package com.api_etudiant.example.demo.services;

import org.springframework.stereotype.Service;
import com.api_etudiant.example.demo.entity.Notes;
import com.api_etudiant.example.demo.entity.Student;
import com.api_etudiant.example.demo.entity.Cours;
import com.api_etudiant.example.demo.repository.CoursRepository;
import com.api_etudiant.example.demo.repository.NotesRepository;
import com.api_etudiant.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesServices {
    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoursRepository coursRepository;

    public Notes createNotes(Long studentId, Long coursId, double value) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        Notes notes = new Notes();
        notes.setStudent(student);
        notes.setCours(cours);
        notes.setNote(value);

        return notesRepository.save(notes);
    }

    public Notes updateNotes(Long id, double value) {
        Notes notes = notesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notes non trouvées"));

        notes.setNote(value);
        return notesRepository.save(notes);
    }

    public void deleteNotes (Long id) {
        notesRepository.deleteById(id);
    }

    public List<Double> getNotesByStudent(Long studentId){
        List <Notes> notes = notesRepository.findByStudentId(studentId);
        List <Double> notesValues = new ArrayList<>();
        for (Notes note : notes) {
            notesValues.add(note.getNote());
        }
        return notesValues;
    }

    public List<Double> getNotesByCours(Long coursId){
        // return notesRepository.findByCoursId(coursId);
        List <Notes> notes = notesRepository.findByCoursId(coursId);
        List <Double> notesValues = new ArrayList<>();
        for (Notes note : notes) {
            notesValues.add(note.getNote());
        }
        return notesValues;
    }
}
