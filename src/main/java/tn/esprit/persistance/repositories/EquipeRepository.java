package tn.esprit.persistance.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.persistance.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
	
	@Query("SELECT e,COUNT(et) FROM Equipe e"
			+ " JOIN e.etudiants et"
			+ " JOIN Contrat c ON c.etudiant.idEtudiant = et.idEtudiant"
			+ " WHERE e.niveau != 'EXPERT'"
			+ " AND c.archive = 0"
			+ " AND c.dateDebutContrat < :date"
			+ " GROUP BY e"
			+ " HAVING COUNT(et) > 2")
	public List<Equipe> retrieveEquipe(@Param("date") Date date);
	
	@Query("SELECT COUNT(u.niveau), u.niveau FROM Equipe u GROUP BY u.niveau")
	List<Object[]> getNbrNiveau();

}
