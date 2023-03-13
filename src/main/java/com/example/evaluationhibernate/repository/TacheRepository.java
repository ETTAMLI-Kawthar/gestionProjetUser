package com.example.evaluationhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluationhibernate.entity.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
