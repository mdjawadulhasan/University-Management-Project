package com.controller;

import com.model.Assignedcourse;
import com.model.Course;
import com.model.Student;
import com.service.AssignedcourseService;
import com.service.CourseService;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final AssignedcourseService assignedcourseService;


    public StudentController(StudentService studentService, CourseService courseService, AssignedcourseService assignedcourseService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.assignedcourseService = assignedcourseService;
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
    public String UpProfile(@RequestParam("stemail") String stemail,@RequestParam("stname") String stname, @RequestParam("Stid") String studentid, @RequestParam("stdept") String stdept, @RequestParam("stsession") String stsession, @RequestParam("stpass") String stpass, @RequestParam("stbgrp") String stbgrp,@RequestParam("stpk") int stpk,@RequestParam("stgender") String stgender,Model model,HttpServletRequest request) {
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
        reqstudent.setStudentIsActive(1);
        studentService.update(reqstudent);

        Student student = studentService.getStudent(reqstudent);
        System.out.println(student.getStudentName());


        request.getSession().setAttribute("student", student);
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

    @RequestMapping("/Offeredcourses")
    public String list(ModelMap model,HttpServletRequest request) {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAll();
        model.addAttribute("courses", courses);

        Student s= (Student) request.getSession().getAttribute("student");
        System.out.println(s.getStudentID());

        List<Assignedcourse> assignedcourses = new ArrayList<>();
        assignedcourses = assignedcourseService.getAll(s.getStudentID());
        model.addAttribute("assignedcourses", assignedcourses);
        return "Course-registration";
    }


    @RequestMapping("/searchcourse")
    public String search(@RequestParam(name = "searchValue", required = false) String coursename, Model model) {
        List<Course> courses = new ArrayList<>();
        if (coursename == null) {
            courses = courseService.getAll();
        } else {
            courses = courseService.getAll(coursename);
        }
        model.addAttribute("courses", courses);
        return "Course-registration";
    }



    @RequestMapping("/registercourse")
    public String RegisterCourse (@RequestParam("courseid") int id,HttpServletRequest request){
        Course course = courseService.get(id);



        Student s= (Student) request.getSession().getAttribute("student");

        Assignedcourse assignedcourse=new Assignedcourse();
        assignedcourse.setCourseName(course.getCourseName());
        assignedcourse.setCourseSection(course.getCoureseSection());
        assignedcourse.setStudetid(s.getStudentID());
        assignedcourse.setStudentName(s.getStudentName());
       assignedcourseService.save(assignedcourse);
        return "redirect:/student/Offeredcourses";
    }


    @RequestMapping("/deletecourse")
    public String delete(@RequestParam("courseid") int id) {
        assignedcourseService.delete(id);
        return "redirect:/student/Offeredcourses";
    }

    @RequestMapping("/seeresult")
    public String result(ModelMap model,HttpServletRequest request) {
        Student s= (Student) request.getSession().getAttribute("student");
        System.out.println(s.getStudentID());

        List<Assignedcourse> assignedcourses = new ArrayList<>();
        assignedcourses = assignedcourseService.getAll(s.getStudentID());
        model.addAttribute("assignedcourses", assignedcourses);
        return "ViewResult";

    }

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/student/registration";
    }

}
