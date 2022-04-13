package com.controller;

import com.model.Course;
import com.service.CourseService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    @RequestMapping("/Admin")
    public String Adhome() {

        return "Admin-home";
    }

    @RequestMapping("/login")
    public String Login() {

        return "adminlogin";
    }




    @RequestMapping("/loginvalidate")
    public String LoginValidate(@RequestParam("uname") String uname,@RequestParam("psw") String pass,Model model) {
        String username = "admin";
        String password = "123";
        if (username.equals(uname) && pass.equals(password))
        {
            model.addAttribute("admin", "success");
            return "Admin-home";
        }
        else{
            model.addAttribute("admin", "failed");
            return "adminlogin";

        }
    }

    @RequestMapping("/Addcourse")
    public String list(Model model) {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAll();
        model.addAttribute("courses", courses);
        return "course-list";
    }


    @RequestMapping("/course-create-form")
    public String courseCreateForm(Model model) {
        Course course = new Course();
        model.addAttribute("course",course);
        return "create-course-form";
    }

    @RequestMapping("/createcourse")
    public String create(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/admin/Addcourse";
    }



    @RequestMapping("/course-update")
    public String userUpdateForm(@RequestParam("courseid") int id, Model model) {
        Course course = courseService.get(id);
        model.addAttribute("course", course);
        return "course-update-form";
    }

    @RequestMapping("/updatecourse")
    public String update(@ModelAttribute("course") Course course) {
        courseService.update(course);
        return "redirect:/admin/Addcourse";
    }


    @RequestMapping("/deletecourse")
    public String delete(@RequestParam("courseid") int id) {
        courseService.delete(id);
        return "redirect:/admin/Addcourse";
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
        return "course-list";
    }
}
