package com.dezzy.springboot.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class StudentServiceTest {

//    Which service we want to test
    @InjectMocks
    private StudentService service;

//    Declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_a_student(){
        StudentDto studentDto = new StudentDto(
                "John",
                "Doe",
                "example@gmail.com",
                1
        );
        Student student = new Student(
                "John",
                "Doe",
                "example@gmail.com",
                29
        );

//        Mock the calls
        when(studentMapper.toStudent(studentDto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(student);
        when(studentMapper.toStudentResponseDto(student))
                .thenReturn(new StudentResponseDto("John", "Doe", "example@gmail.com"));

//        When
        StudentResponseDto responseDto = service.saveStudent(studentDto);

//        Then
        assertEquals(studentDto.firstname(), responseDto.firstname());
        assertEquals(studentDto.lastname(), responseDto.lastname());
        assertEquals(studentDto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(studentDto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(student);
    }

    public void should_return_all_students() {
//
    }
}