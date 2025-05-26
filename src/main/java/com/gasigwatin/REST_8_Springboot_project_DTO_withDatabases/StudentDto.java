package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

public record StudentDto(String firstName,
                         String lastName,
                         String email,
                         int age,
                         String creationDate,
                         Integer schoolId) {
}