package com.model;


import javax.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ftid")
    private int id;


    @Column(name = "ftname")
    private String FacultyName;

    @Column(name = "facultyid")
    private String FacultyId;


    @Column(name = "ftemail")
    private String FacultyEmail;


    @Column(name = "ftpass")
    private String FacultyPass;


    @Column(name = "ftdept")
    private String FacultyDept;


    @Column(name = "ftdesig")
    private String FacultyDeisg;


    public Faculty() {
    }

    public Faculty(int id, String facultyName, String facultyId, String facultyEmail, String facultyPass, String facultyDept, String facultyDeisg) {
        this.id = id;
        FacultyName = facultyName;
        FacultyId = facultyId;
        FacultyEmail = facultyEmail;
        FacultyPass = facultyPass;
        FacultyDept = facultyDept;
        FacultyDeisg = facultyDeisg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getFacultyEmail() {
        return FacultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        FacultyEmail = facultyEmail;
    }

    public String getFacultyPass() {
        return FacultyPass;
    }

    public void setFacultyPass(String facultyPass) {
        FacultyPass = facultyPass;
    }

    public String getFacultyDept() {
        return FacultyDept;
    }

    public void setFacultyDept(String facultyDept) {
        FacultyDept = facultyDept;
    }

    public String getFacultyDeisg() {
        return FacultyDeisg;
    }

    public void setFacultyDeisg(String facultyDeisg) {
        FacultyDeisg = facultyDeisg;
    }
}
