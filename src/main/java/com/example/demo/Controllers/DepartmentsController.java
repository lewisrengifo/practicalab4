package com.example.demo.Controllers;

import com.example.demo.Entity.Departments;
import com.example.demo.Repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping("")
    public String listaDeparts(Model model){
        List<Departments> allDeparts = departmentsRepository.findAll();
        model.addAttribute("listDepartments", allDeparts);
        return "departments/lista";

    }
}
