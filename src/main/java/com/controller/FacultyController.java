package com.controller;

import com.model.Assignedcourse;
import com.model.Course;
import com.model.Faculty;
import com.service.AssignedcourseService;
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
    private final AssignedcourseService assignedcourseService;

    public FacultyController(FacultyService facultyService, CourseService courseService, AssignedcourseService assignedcourseService) {
        this.facultyService = facultyService;
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

        Faculty f = (Faculty) request.getSession().getAttribute("faculty");

        courses = courseService.getavailable(f.getFacultyName());
        model.addAttribute("courses", courses);

        List<Course> scourses = new ArrayList<>();

        scourses = courseService.SelectedCourse(f.getFacultyName());
        model.addAttribute("scourses", scourses);
        return "Course-Adding";
    }


    @RequestMapping("/Addcourse")
    public String Addcourse(@RequestParam("courseid") int id, HttpServletRequest request) {

        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        courseService.Addfaculty(id, f.getFacultyName());
        return "redirect:/faculty/Allcourse";
    }


    @RequestMapping("/removecourse")
    public String delete(@RequestParam("courseid") int id, HttpServletRequest request) {
        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        courseService.Removefaculty(id, f.getFacultyName());
        return "redirect:/faculty/Allcourse";
    }


    @RequestMapping("/Mycourses")
    public String courselist(ModelMap model, HttpServletRequest request) {
        List<Course> scourses = new ArrayList<>();
        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        scourses = courseService.SelectedCourse(f.getFacultyName());
        model.addAttribute("scourses", scourses);
        return "Faculty-courses";
    }


    @RequestMapping("/studentlist")
    public String studentlist(@RequestParam("cname") String cname, @RequestParam("section") String section, ModelMap model, HttpServletRequest request) {


        List<Assignedcourse> stcourses = new ArrayList<>();
        stcourses = assignedcourseService.getStudentList(cname, section);
        model.addAttribute("stcourses", stcourses);
        return "Student-list";

    }


    @RequestMapping("/Gradesubmit")
    public String GradeSubmit(ModelMap model, HttpServletRequest request) {
        List<Course> scourses = new ArrayList<>();
        Faculty f = (Faculty) request.getSession().getAttribute("faculty");
        scourses = courseService.SelectedCourse(f.getFacultyName());
        model.addAttribute("scourses", scourses);
        return "Allsections";
    }


    @RequestMapping("/Allstudents")
    public String Allstudentlist(@RequestParam("cname") String cname, @RequestParam("section") String section, ModelMap model, HttpServletRequest request) {


        List<Assignedcourse> stcourses = new ArrayList<>();
        stcourses = assignedcourseService.getStudentList(cname, section);
        model.addAttribute("stcourses", stcourses);
        return "Gradelist";

    }

    @RequestMapping("/markup")
    public String markupdate(@RequestParam("courseid") int id, Model model) {
        Assignedcourse assignedcourse = assignedcourseService.get(id);
        model.addAttribute("assignedcourse", assignedcourse);
        return "Setmarks";
    }


    @RequestMapping("/updatemarks")
    public String update(@RequestParam("marks") String marks, @RequestParam("id") int id) {
        System.out.println(marks);
        System.out.println(id);
        assignedcourseService.UpdateMarks(id, marks);
        return "redirect:/faculty/Gradesubmit";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/faculty/registration";
    }

}
