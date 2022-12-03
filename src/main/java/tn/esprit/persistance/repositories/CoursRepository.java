package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer>{

}
