package com.example.evaluationhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluationhibernate.entity.Tache;
import com.example.evaluationhibernate.repository.TacheRepository;
import com.example.evaluationhibernate.service.TacheService;

@RestController
@RequestMapping("/tache")
public class TacheController {

    @Autowired
    private TacheService tacheService;
    @Autowired
    private TacheRepository tacheRepo;

    @PostMapping("/addTache")
    public void addTacheToProjet(@PathVariable int projetId, @RequestBody Tache tache) throws Exception {
        tacheService.addTacheToProjet(projetId, tache);
    }

    @GetMapping("/getTache")
    public List<Tache> Recherche() {
        return tacheRepo.findAll();
    }

    @DeleteMapping("/deleteTache/{id}")
    public String deleteUtilisateur(@PathVariable("id") int id) throws Exception {
        tacheService.deleteAllTachesByProjetId(id);
        return "Tache deleted";
    }
}