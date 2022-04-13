package com.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stid")
    private String StudentID;

    @Column(name = "stname")
    private String StudentName;


    @Column(name = "stdept")
    private String StudentDept;


    @Column(name = "stsession")
    private String StudentSession;

    @Column(name = "stgender")
    private String StudentGender;

    @Column(name = "stbloodgroup")
    private String StudentBgrp;

    @Column(name = "stisactive")
    private int StudentIsActive;


    @Column(name = "stemail")
    private String StudentemaIL;


    @Column(name = "stpass")
    private String  Studentpass;



    public Student() {
    }

    public Student(int id, String studentID, String studentName, String studentDept, String studentSession, String studentGender, String studentBgrp, int studentIsActive, String studentemaIL, String studentpass) {
        this.id = id;
        StudentID = studentID;
        StudentName = studentName;
        StudentDept = studentDept;
        StudentSession = studentSession;
        StudentGender = studentGender;
        StudentBgrp = studentBgrp;
        StudentIsActive = studentIsActive;
        StudentemaIL = studentemaIL;
        Studentpass = studentpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentDept() {
        return StudentDept;
    }

    public void setStudentDept(String studentDept) {
        StudentDept = studentDept;
    }

    public String getStudentSession() {
        return StudentSession;
    }

    public void setStudentSession(String studentSession) {
        StudentSession = studentSession;
    }

    public String getStudentGender() {
        return StudentGender;
    }

    public void setStudentGender(String studentGender) {
        StudentGender = studentGender;
    }

    public String getStudentBgrp() {
        return StudentBgrp;
    }

    public void setStudentBgrp(String studentBgrp) {
        StudentBgrp = studentBgrp;
    }

    public int getStudentIsActive() {
        return StudentIsActive;
    }

    public void setStudentIsActive(int studentIsActive) {
        StudentIsActive = studentIsActive;
    }

    public String getStudentemaIL() {
        return StudentemaIL;
    }

    public void setStudentemaIL(String studentemaIL) {
        StudentemaIL = studentemaIL;
    }

    public String getStudentpass() {
        return Studentpass;
    }

    public void setStudentpass(String studentpass) {
        Studentpass = studentpass;
    }
}
