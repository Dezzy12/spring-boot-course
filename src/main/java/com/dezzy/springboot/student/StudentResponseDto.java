package com.dezzy.springboot.student;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {

}
