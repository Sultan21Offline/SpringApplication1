package com.springapp.springapp1.controllers;

import com.springapp.springapp1.models.TableDB;
import com.springapp.springapp1.repo.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        Iterable<TableDB> tableDBS = tableRepository.findAll();
        model.addAttribute("table",tableDBS);
        return "home";
    }
    @PostMapping("/add")
    public String addTable(@RequestParam String name, Model model){
        TableDB tableDB = new TableDB(name);
        tableRepository.save(tableDB);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String removeTable(@PathVariable(value = "id") long id, Model model){
        TableDB tableDB = tableRepository.findById(id).orElseThrow();
        tableRepository.delete(tableDB);
        return "redirect:/";
    }

}