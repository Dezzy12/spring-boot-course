package com.dezzy.springboot;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ) {
        return repository.save(student);
    }
    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return repository.findAll();
    }
    @GetMapping("/students/{id}")
    public Student findStudentById(
            @PathVariable Integer id
    ) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String name
    ) {
        return repository.findAllByFirstnameContaining(name);
    }
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repository.deleteById(id);
    }
}
