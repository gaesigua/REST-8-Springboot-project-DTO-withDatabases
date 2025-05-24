package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity(name = "School Table")
public class School{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "School Name", length = 255)
    private String schoolName;


    @Column(name = "School Type", length = 20)
    private String schoolType;

    @Column(name = "Founded", length = 4)
    private int foundedDate;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Student student;



    public School(){}


    public School(String schoolName, String schoolType, int foundedDate){
        this.schoolName = schoolName;
        this.schoolType = schoolType;
        this.foundedDate = foundedDate;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }

    public void setSchoolType(String schoolType){
        this.schoolType = schoolType;
    }

    public String getSchoolType(){
        return schoolType;
    }

    public void setFoundedDate(int foundedDate){
        this.foundedDate = foundedDate;
    }

    public int getFoundedDate(){
        return foundedDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}