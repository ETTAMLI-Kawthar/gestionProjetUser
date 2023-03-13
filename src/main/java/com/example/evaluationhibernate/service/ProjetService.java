package com.example.evaluationhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.evaluationhibernate.entity.Projet;
import com.example.evaluationhibernate.repository.ProjetRepository;

@Service
public class ProjetService {

    @Autowired
    ProjetRepository projetRepository;

    // méthodes Rechercher() avec un tri asc by ID:
    public List<Projet> Recherche() {
        return projetRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // méthode qui permet de persister un projet en utilisant une requête nommé:
    public void saveProjetWithQuery(String description, String titre, int utilisateurId) {
        projetRepository.saveProjetWithQuery(description, titre, utilisateurId);
    }

    public Projet saveProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    public Projet getProjetById(int id) {
        return projetRepository.findById(id).orElse(null);
    }

    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    public Projet updateProjet(Projet projet) {
        Projet projetExist = getProjetById(projet.getId());
        projetExist.setTitre(projet.getTitre());
        projetExist.setDescription(projet.getDescription());
        projetExist.setTache(projet.getTache());
        projetExist.setUtilisateur(projet.getUtilisateur());
        return projetRepository.save(projetExist);
    }

    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }

}
