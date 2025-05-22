package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining (String studentFirstName);

}
