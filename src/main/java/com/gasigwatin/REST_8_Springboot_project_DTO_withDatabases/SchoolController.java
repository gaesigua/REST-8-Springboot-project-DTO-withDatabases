package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School postSchoolDetails(
            @RequestBody SchoolDto schoolDto){

        var school = toSchool(schoolDto);

        var savedSchool = schoolRepository.save(school);

        return dto;

    }

    private School toSchool(SchoolDto dto){
       return new SchoolDto


    }




    @GetMapping("/schools")
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    @GetMapping("/schools/search/{school-id}")
    public School getOneSchool(
            @PathVariable("school-id") Integer schoolId){

        return schoolRepository.findById(schoolId).orElse(new School());

    }
}
