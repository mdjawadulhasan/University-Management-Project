package com.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crsid")
    private int id;


    @NotNull(message = "Coursename can not be empty")
    @Column(name = "coursename")
    private String CourseName;

    @NotNull(message = "Coursesection can not be empty")
    @Column(name = "coursesection")
    private String CoureseSection;


    @Column(name = "faculty")
    private String FacultyName;


    public Course() {
    }

    public Course(int id, String courseName, String coureseSection, String facultyName) {
        this.id = id;
        CourseName = courseName;
        CoureseSection = coureseSection;
        FacultyName = facultyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCoureseSection() {
        return CoureseSection;
    }

    public void setCoureseSection(String coureseSection) {
        CoureseSection = coureseSection;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }
}
