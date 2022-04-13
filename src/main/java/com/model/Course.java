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


    public Course() {
    }

    public Course(int id, String courseName, String coureseSection) {
        this.id = id;
        CourseName = courseName;
        CoureseSection = coureseSection;
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
}
