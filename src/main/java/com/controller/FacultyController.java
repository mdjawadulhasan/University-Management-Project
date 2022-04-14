package com.controller;

import com.model.Course;
import com.model.Faculty;
import com.service.CourseService;
import com.service.FacultyService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/faculty")
public class FacultyController {


    private final FacultyService facultyService;
    private final CourseService courseService;

    public FacultyController(FacultyService facultyService, CourseService courseService) {
        this.facultyService = facultyService;
        this.courseService = courseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/registration")
    public String StRegistration(Model model) {
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);
        return "faculty-reg";
    }


    @RequestMapping("/createfaculty")
    public String create(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.save(faculty);
        return "redirect:/faculty/registration";
    }

    @RequestMapping("/ftlogin")
    public String login(@RequestParam("fctid") String fctid, @RequestParam("password") String pass, Model model, HttpServletRequest request) {
        Faculty reqfaculty = new Faculty();
        reqfaculty.setFacultyId(fctid);
        reqfaculty.setFacultyPass(pass);


        Faculty faculty = facultyService.getFaculty(reqfaculty);

        if (faculty != null) {
            request.getSession().setAttribute("faculty", faculty);
            return "faculty-profile";
        } else {
            model.addAttribute("msg", "failed");
            return "redirect:/faculty/registration";
        }
    }


    @RequestMapping("/Profile")
    public String Profile() {
        return "faculty-profile";
    }

    @RequestMapping("/Allcourse")
    public String list(ModelMap model, HttpServletRequest request) {
        List<Course> courses = new ArrayList<>();

        courses = courseService.getAll();
        model.addAttribute("courses", courses);

        List<Course> scourses = new ArrayList<>();
        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        scourses = courseService.SelectedCourse(f.getFacultyName());
        model.addAttribute("scourses", scourses);
        return "Course-Adding";
    }


    @RequestMapping("/Addcourse")
    public String Addcourse(@RequestParam("courseid") int id,HttpServletRequest request){

        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        courseService.Addfaculty(id,f.getFacultyName());
        return "redirect:/faculty/Allcourse";
    }


    @RequestMapping("/removecourse")
    public String delete(@RequestParam("courseid") int id,HttpServletRequest request) {
        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        courseService.Removefaculty(id,f.getFacultyName());
        return "redirect:/faculty/Allcourse";
    }

}