package com.api_etudiant.example.demo.controller;

public class NotesDTO {
    public Long studentId;
    public Long coursId;
    public double value;

    public NotesDTO() {}

    public NotesDTO(Long studentId, Long coursId, double value) {
        this.studentId = studentId;
        this.coursId = coursId;
        this.value = value;
    }

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getCoursId() {
        return coursId;
    }
    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}