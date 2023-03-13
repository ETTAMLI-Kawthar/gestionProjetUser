package com.example.evaluationhibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.evaluationhibernate.entity.Projet;
import com.example.evaluationhibernate.entity.Utilisateur;
import com.example.evaluationhibernate.repository.ProjetRepository;
import com.example.evaluationhibernate.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ProjetRepository projetRepository;

    // méthodes Rechercher() avec un tri asc by ID:
    public List<Utilisateur> Recherche() {
        return utilisateurRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // méthode qui permet la suppression d’un utilisateur:
    public void deleteUtilisateurById(int utilisateurId) throws Exception {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(utilisateurId);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            List<Projet> projets = utilisateur.getProjet();
            projetRepository.deleteAll(projets);
            utilisateurRepository.delete(utilisateur);
        } else {
            throw new Exception("Utilisateur with id " + utilisateurId + " not found");
        }
    }

    public Utilisateur savetUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }
}
