package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO projet_equipes VALUES (:idP, :idE)", nativeQuery = true)
	public void updateassignProjetToEquipe(@Param("idP") int idP, @Param("idE") int idE);

	
}
