package com.test.studentCRUD.controller;

import com.test.studentCRUD.entity.StudentEntity;
import com.test.studentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String viewHomePage(ModelMap modelMap){
        List<StudentEntity> studentEntities = studentService.listAll();
        modelMap.addAttribute("listStudents", studentEntities);

        return "index";
    }

    @RequestMapping("/new")
    public String add(ModelMap modelMap){
        modelMap.addAttribute("student",new StudentEntity());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") StudentEntity student){
        studentService.save(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("new");
        StudentEntity std = studentService.get(id);
        mav.addObject("student", std);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") long id) {
        studentService.delete(id);
        return "redirect:/";
    }



}
