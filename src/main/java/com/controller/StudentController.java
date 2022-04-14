package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/registration")
    public String StRegistration(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-reg";
    }

    @RequestMapping("/update")
    public String UpProfile(@RequestParam("stemail") String stemail,@RequestParam("stname") String stname, @RequestParam("Stid") String studentid, @RequestParam("stdept") String stdept, @RequestParam("stsession") String stsession, @RequestParam("stpass") String stpass, @RequestParam("stbgrp") String stbgrp,@RequestParam("stpk") int stpk,@RequestParam("stgender") String stgender,Model model) {
        Student reqstudent = new Student();
        reqstudent.setStudentName(stname);
        reqstudent.setStudentDept(stdept);
        reqstudent.setStudentSession(stsession);
        reqstudent.setStudentBgrp(stbgrp);
        reqstudent.setStudentGender(stgender);
        reqstudent.setId(stpk);
        reqstudent.setStudentpass(stpass);
        reqstudent.setStudentID(studentid);
        reqstudent.setStudentemaIL(stemail);
        studentService.update(reqstudent);

        Student student = studentService.getStudent(reqstudent);
        model.addAttribute("student", student);
        return "student-profile";
    }

    @RequestMapping("/createstudent")
    public String create(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/registration";
    }


    @RequestMapping("/stlogin")
    public String login(@RequestParam("studentid") String studentid, @RequestParam("password") String pass, Model model, HttpServletRequest request) {
        Student reqstudent = new Student();
        reqstudent.setStudentID(studentid);
        reqstudent.setStudentpass(pass);


        Student student = studentService.getStudent(reqstudent);
        if (student != null) {
            model.addAttribute("student", student);
            request.getSession().setAttribute("student", student);
            return "student-profile";
        } else {
            model.addAttribute("msg", "failed");
            return "redirect:/student/registration";
        }


    }

    @RequestMapping("/Courseregistration")
    public String tes(){

        return "Course-registration";
    }


    @RequestMapping("/Profile")
    public String Profile(){

        return "student-profile";
    }

}
