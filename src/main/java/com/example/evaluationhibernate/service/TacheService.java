package com.example.evaluationhibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.evaluationhibernate.entity.Projet;
import com.example.evaluationhibernate.entity.Tache;
import com.example.evaluationhibernate.repository.ProjetRepository;
import com.example.evaluationhibernate.repository.TacheRepository;

@Service
public class TacheService {

    @Autowired
    TacheRepository tacheRepository;

    @Autowired
    ProjetRepository projetRepository;

    // méthodes Rechercher() avec un tri asc by ID:
    public List<Tache> findByOrderByIdAsc() {
        return tacheRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // méthode qui permet d’ajouter une tache à un projet existant:
    public void addTacheToProjet(int projetId, Tache tache) throws Exception {
        Optional<Projet> optionalProjet = projetRepository.findById(projetId);
        if (optionalProjet.isPresent()) {
            Projet projet = optionalProjet.get();
            tache.setProjet(projet);
            tacheRepository.save(tache);
        } else {
            throw new Exception("Projet with id " + projetId + " not found");
        }
    }

    // méthode qui permet de supprimer tous les tâches:
    public void deleteAllTachesByProjetId(int projetId) throws Exception {
        Optional<Projet> optionalProjet = projetRepository.findById(projetId);
        if (optionalProjet.isPresent()) {
            Projet projet = optionalProjet.get();
            List<Tache> taches = projet.getTache();
            tacheRepository.deleteAll(taches);
        } else {
            throw new Exception("Projet with id " + projetId + " not found");
        }
    }

    public Tache saveTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Tache getTacheById(int id) {
        return tacheRepository.findById(id).orElse(null);
    }

    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }

    public Tache updateTache(Tache tache) {
        Tache tacheExist = getTacheById(tache.getId());
        tacheExist.setTitre(tache.getTitre());
        tacheExist.setDeccription(tache.getDeccription());
        tacheExist.setProjet(tache.getProjet());
        return tacheRepository.save(tacheExist);
    }

    public void deleteTache(int id) {
        tacheRepository.deleteById(id);
    }

}
