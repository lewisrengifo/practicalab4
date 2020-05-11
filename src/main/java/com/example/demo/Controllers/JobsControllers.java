package com.example.demo.Controllers;

import com.example.demo.Entity.Jobs;
import com.example.demo.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/jobs")
public class JobsControllers {
    @Autowired
    JobsRepository jobsRepository;
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("listajobs", jobsRepository.findAll());
        return "jobs/lista";
    }
    @GetMapping("/crear")
    public String crear(@ModelAttribute("jobs")Jobs jobs){
        return "jobs/form";
    }
    @GetMapping("/guardar")
    public String guardar(@ModelAttribute("jobs") Jobs jobs, RedirectAttributes redirectAttributes){
        if (){
            redirectAttributes.addFlashAttribute("msg", "trabajo creado correctamente");

        } else{
            redirectAttributes.addFlashAttribute("msg", "trabajo actualizado correctamente");
        }
        jobsRepository.save(jobs);
        return "redirect:/jobs/listar";
    }
    @
    public String editar(@ModelAttribute("jobs") Jobs jobs, Model model, @RequestParam("id") int id){
        Optional<Jobs> optionalJobs = jobsRepository.findById(id);
        if (optionalJobs.isPresent()){
            jobs = optionalJobs.get();
        }
    }
}
