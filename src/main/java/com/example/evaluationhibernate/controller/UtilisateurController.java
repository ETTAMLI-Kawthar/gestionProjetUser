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

import com.example.evaluationhibernate.entity.Utilisateur;
import com.example.evaluationhibernate.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService urilisateurService;

    @GetMapping("/getUtilisateurSorted")
    public List<Utilisateur> Recherche() {
        return urilisateurService.Recherche();
    }

    @GetMapping("/GetAllUtilisateur")
    public List<Utilisateur> getAllUtilisateur() {
        return urilisateurService.getAllUtilisateur();
    }

    @PostMapping("/addUtilisateur")
    public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
        urilisateurService.savetUtilisateur(utilisateur);
    }

    @GetMapping("/getUtilisateurByID/{id}")
    public Utilisateur getUtilisateurbyId(@PathVariable("id") int id) {
        return urilisateurService.getUtilisateurById(id);
    }

    @DeleteMapping("/deleteUtilisateur/{id}")
    public String deleteUtilisateur(@PathVariable("id") int id) throws Exception {
        urilisateurService.deleteUtilisateurById(id);
        return "Utilisateur deleted";
    }

}
