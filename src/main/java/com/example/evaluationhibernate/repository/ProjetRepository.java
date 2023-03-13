package com.example.evaluationhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.evaluationhibernate.entity.Projet;

import jakarta.transaction.Transactional;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO projet (description, titre, id_user) VALUES(:description, :titre, :utilisateurId)", nativeQuery = true)
    void saveProjetWithQuery(@Param("description") String description, @Param("titre") String titre,
            @Param("utilisateurId") int utilisateurId);

}
