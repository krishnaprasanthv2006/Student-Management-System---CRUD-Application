package com.example.studentmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // READ - Get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // CREATE - Add a student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // UPDATE - Update a student
    @PutMapping("/students/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        student.setId(id);
        return studentRepository.save(student);
    }

    // DELETE - Delete a student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }
}