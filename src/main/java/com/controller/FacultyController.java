package com.controller;

import com.model.Faculty;
import com.service.FacultyService;
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
@RequestMapping("/faculty")
public class FacultyController {


   private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
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
        Faculty reqfaculty=new Faculty();
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

}
