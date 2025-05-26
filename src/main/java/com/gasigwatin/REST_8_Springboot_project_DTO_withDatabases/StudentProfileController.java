package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentProfileController {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @PostMapping("/students/bio")
    public StudentProfile postStudentProfileDetails(
            @RequestBody StudentProfile studentProfile){

        return studentProfileRepository.save(studentProfile);

    }
}