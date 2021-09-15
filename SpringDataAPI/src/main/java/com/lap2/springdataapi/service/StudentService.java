package com.lap2.springdataapi.service;

import com.lap2.springdataapi.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(Long Id);
    public void addStudent(Student student);
    public void delStudent(Long id);
    public Student updateStudent(Long id, Student student);
}
