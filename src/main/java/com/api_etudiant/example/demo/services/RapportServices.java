package com.api_etudiant.example.demo.services;


import org.springframework.stereotype.Service;
import com.api_etudiant.example.demo.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.api_etudiant.example.demo.entity.Notes;
import java.util.List;
@Service
public class RapportServices {
    @Autowired
    private NotesRepository notesRepository;

    public double getAverageByCourse(Long courseId){
        List <Notes> grades = notesRepository.findByCoursId(courseId);
        if(grades.isEmpty()){
            throw new RuntimeException("Aucune note trouvée pour ce cours");
        }

        double total = 0;
        for  (Notes note : grades) {
            total += note.getNote();
        }

        return total / grades.size();
    }

    public double getAverageByStudent(Long studentId){
        List <Notes> grades = notesRepository.findByStudentId(studentId);

        if(grades.isEmpty()){
            throw new RuntimeException("Aucune note trouvée pour cet étudiant");
        }

        double total = 0;
        for  (Notes note : grades) {
            total += note.getNote();
        }
    
        return total / grades.size();
    }

}
