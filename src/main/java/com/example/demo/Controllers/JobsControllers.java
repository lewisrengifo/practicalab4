package com.example.demo.Controllers;

import com.example.demo.Entity.Jobs;
import com.example.demo.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/jobs")
public class JobsControllers {
    @Autowired
    JobsRepository jobsRepository;
    @GetMapping("/lista")
    public String listar(Model model){
        model.addAttribute("listajobs", jobsRepository.findAll());
        return "Jobs/lista";
    }
    @GetMapping("/crear")
    public String crear(@ModelAttribute("jobs")Jobs jobs){
        return "Jobs/form";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("jobs") Jobs jobs, RedirectAttributes redirectAttributes){
        if (jobs.getJob_id()==null){
            redirectAttributes.addFlashAttribute("msg", "trabajo creado correctamente");

        } else{
            redirectAttributes.addFlashAttribute("msg", "trabajo actualizado correctamente");
        }
        jobsRepository.save(jobs);
        return "redirect:/jobs/lista";
    }
    @GetMapping("/editar")
    public String editar(@ModelAttribute("jobs") Jobs jobs, Model model, @RequestParam("id") String id) {
        Optional<Jobs> optionalJobs = jobsRepository.findById(id);
        if (optionalJobs.isPresent()) {
            jobs = optionalJobs.get();
            model.addAttribute("jobs", jobs);
            return "jobs/form";
        } else {
            return "redirect:/jobs/lista";
        }
    }
    public String borrar(Model model, RedirectAttributes redirectAttributes, @RequestParam("id") String id){
        Optional<Jobs> optionalJobs= jobsRepository.findById(id);
        if (optionalJobs.isPresent()){
            jobsRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("msg","trabajo borrado correctamente");
        }
        return "redirect:/jobs/lista";
    }
}
