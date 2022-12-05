package tn.esprit.persistance.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
	
	@Query("SELECT COUNT(c) FROM Contrat c JOIN Etudiant e ON e.idEtudiant = c.etudiant.idEtudiant "
			+ "WHERE e.nomE = :nom AND e.prenomE = :prenom AND c.archive = 0")
	public int countContratsByEtudiant(@Param("nom") String nom, @Param("prenom") String prenom);
	
	@Query("SELECT c FROM Contrat c WHERE c.dateDebutContrat > :dd AND c.dateFinContrat < :df AND c.archive = 0")
	public List<Contrat> retriveContratBetweenDate(@Param("dd") Date dd, @Param("df") Date df);
	
	@Query("SELECT COUNT(c) FROM Contrat c "
			+ "WHERE c.dateDebutContrat > :dd AND c.dateFinContrat < :df AND c.archive = 0")
	public Integer countContratBetweenTwoDates(@Param("dd") Date dd, @Param("df") Date df);
	
	@Query("SELECT c FROM Contrat c WHERE c.dateFinContrat = :alertDate")
	public List<Contrat> retrieveContratsGoingToEnd(@Param("alertDate") Date alertDate);
	
	@Transactional
	@Modifying
	@Query("UPDATE Contrat c SET c.archive = 1 WHERE c.dateFinContrat < :currentDate")
	public int updateContratArchive(@Param("currentDate") Date currentDate);
	
	@Query("SELECT COUNT(u.specialite), u.specialite FROM Contrat u GROUP BY u.specialite")
	public List<Object[]> getNbrSpecialite();
}
