package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.persistance.entities.Stage;

public interface StageRepository extends JpaRepository<Stage, Integer>  {
	
	@Query("SELECT COUNT(u.typeStage), u.typeStage FROM Stage u GROUP BY u.typeStage")
	List<Object[]> getNbrTypeStage();
	
}
