package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController{

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //LET'S CREATE (ENTER) NEW STUDENTS

    @PostMapping("/students")
    public StudentResponseDto postStudentDetails(
            @RequestBody StudentDto studentDto){

        var student = toStudent(studentDto);

        var savedStudent = studentRepository.save(student);

        return toStudentResponseDto(savedStudent);
    }

    //LET'S CREATE A METHOD THAT WILL ALLOW US TO ENTER ENTRIES, WITHOUT NEEDING TO USE ALL THE FIELDS.


    private Student toStudent(StudentDto dto){

        var student = new Student();
        var school = new School();

        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setAge(dto.age());
        student.setCreationDate(dto.creationDate());

        school.setId(dto.schoolId());

        //Now we need to set the object of type schoolId (the last parameter in the StudentDto record), and then link it to the student object

        student.setSchool(school);

        return student;
    }


    // LET'S CREATE A REPRESENTATION THAT WE CAN EXPOSE TO THE REST Client WITH JUST The First name and Last name of the Student


    private StudentResponseDto toStudentResponseDto(Student student){

        return new StudentResponseDto(student.getFirstName(), student.getLastName());
    }


    //LET'S RETRIEVE ALL STUDENTS

    @GetMapping("/students")
    public List<Student> retrieveAllStudents(){
        return studentRepository.findAll();
    }



    //LET'S RETRIEVE ONE STUDENT, USING THEIR ID

    @GetMapping("/students/{student-id}")
    public Student retrieveOneStudentById(
            @PathVariable("student-id") Integer studentId){

        return studentRepository.findById(studentId).orElse(new Student());
    }


    //LET'S RETRIEVE A STUDENT (IT COULD BE MORE THAN ONE STUDENT) USING THEIR FIRST NAME


    @GetMapping("/students/search/{student-firstname}")
    public List<Student> retrieveOneStudentBy(
            @PathVariable("student-firstname") String studentFirstName){

        return studentRepository.findAllByFirstNameContaining(studentFirstName);

    }

    //LET'S DELETE ONE STUDENT

    @DeleteMapping("/student/search/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneStudent (@PathVariable ("student-id") Integer studentId){

        studentRepository.deleteById(studentId);
    }
}