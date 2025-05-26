package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}