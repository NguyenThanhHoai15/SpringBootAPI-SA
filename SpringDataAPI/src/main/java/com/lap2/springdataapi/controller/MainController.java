package com.lap2.springdataapi.controller;

import com.lap2.springdataapi.model.Student;
import com.lap2.springdataapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PostMapping("/students/{id}")
    public void delStudent(@PathVariable("id") Long id){
        studentService.delStudent(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
