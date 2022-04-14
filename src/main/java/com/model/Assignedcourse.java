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

    @Column(name = "result")
    private String Result;

    @Column(name = "studentname")
    private String StudentName;




    public Assignedcourse() {
    }

    public Assignedcourse(int id, String studetid, String courseSection, String courseName, String result, String studentName) {
        this.id = id;
        Studetid = studetid;
        CourseSection = courseSection;
        CourseName = courseName;
        Result = result;
        StudentName = studentName;
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


    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
}
