package com.lap2.springdataapi.service;

import com.lap2.springdataapi.model.Student;
import com.lap2.springdataapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long Id) {
        Student student = studentRepository.findById(Id).get();
        if(student == null)
            throw new RuntimeException("Didn't find student id: " + Id);
        return student;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student studentDB = studentRepository.findById(id).get();
        studentDB.setName(student.getName());
        studentDB.setAddress(student.getAddress());
        studentDB.setAge(student.getAge());
        studentDB.setEmail(student.getEmail());
        studentDB.setClassName(student.getClassName());
        return studentDB;
    }
}
