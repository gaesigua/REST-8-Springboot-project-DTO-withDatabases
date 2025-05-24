package com.gasigwatin.REST_8_Springboot_project_DTO_withDatabases;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "First Name", length = 50)
    private String firstName;


    @Column(name = "Last Name", length = 50)
    private String lastName;


    @Column(name = "Age", length = 3)
    private int age;


    @Column(name = "Grade", length = 1)
    private char grade;


    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Creation Date", updatable = false)
    private String creationDate;


    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


    public Student(){}

    public Student(String firstName, String lastName, int age, char grade, String email, String creationDate){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.creationDate = creationDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public char getGrade() {
        return grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}