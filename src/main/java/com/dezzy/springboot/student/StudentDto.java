package com.dezzy.springboot.student;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
