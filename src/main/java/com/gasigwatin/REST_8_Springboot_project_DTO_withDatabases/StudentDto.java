package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

public record StudentDto(String firstName,
                         String lastName,
                         String email,
                         int age,
                         String creationDate,
                         Integer schoolId) {
}
