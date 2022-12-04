package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Stage;

public interface StageRepository extends JpaRepository<Stage, Integer>  {
	
}
