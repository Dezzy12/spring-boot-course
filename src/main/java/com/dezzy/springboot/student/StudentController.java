package com.dezzy.springboot.student;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto studentDto
    ) {
        return this.studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return this.studentService.findAllStudent();
    }
    @GetMapping("/students/{id}")
    public StudentResponseDto findStudentById(
            @PathVariable Integer id
    ) {
        return this.studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("student-name") String name
    ) {
        return this.studentService.findStudentByName(name);
    }
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        this.studentService.delete(id);
    }
}