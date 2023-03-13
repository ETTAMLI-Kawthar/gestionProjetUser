package com.example.evaluationhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluationhibernate.entity.Projet;
import com.example.evaluationhibernate.repository.ProjetRepository;
import com.example.evaluationhibernate.service.ProjetService;

@RestController
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    private ProjetService projetService;
    @Autowired
    private ProjetRepository projetRepo;

    @GetMapping("/getProjetSorted")
    public List<Projet> Recherche() {
        return projetRepo.findAll();
    }

    @PostMapping("/addProjetWithQuery")
    public void addProjetWithQuery(@RequestBody Projet projet) {
        projetService.saveProjetWithQuery(projet.getDescription(), projet.getTitre(), projet.getUtilisateur().getId());
    }

    @PostMapping("/addProjet")
    public void addProjet(@RequestBody Projet projet) {
        projetService.saveProjet(projet);
    }
}
