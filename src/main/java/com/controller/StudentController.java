package com.controller;

import com.model.Course;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Student student=new Student();
        model.addAttribute("student",student);
        return "student-reg";
    }


    @RequestMapping("/createstudent")
    public String create(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/registration";
    }
}
