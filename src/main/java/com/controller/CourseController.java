package com.controller;

import com.model.Course;
import com.model.User;
import com.service.CourseService;
import com.service.UserService;
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
@RequestMapping("/user")
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
        return "redirect:/user/Addcourse";
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
        return "redirect:/user/Addcourse";
    }


    /*






    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(name = "searchValue", required = false) String firstname, Model model) {
        List<User> users = new ArrayList<>();
        if (firstname == null) {
            users = userService.getAll();
        } else {
            users = userService.getAll(firstname);
        }
        model.addAttribute("users", users);
        return "user-list";
    }*/
}
