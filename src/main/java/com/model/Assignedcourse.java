package com.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assignedcourses")
public class Assignedcourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ascid")
    private int id;


    @Column(name = "studentid")
    private String Studetid;

    @Column(name = "coursesection")
    private String CourseSection;

    @Column(name = "coursename")
    private String CourseName;


    public Assignedcourse() {
    }

    public Assignedcourse(int id, String studetid, String courseSection, String courseName) {
        this.id = id;
        Studetid = studetid;
        CourseSection = courseSection;
        CourseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudetid() {
        return Studetid;
    }

    public void setStudetid(String studetid) {
        Studetid = studetid;
    }

    public String getCourseSection() {
        return CourseSection;
    }

    public void setCourseSection(String courseSection) {
        CourseSection = courseSection;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
