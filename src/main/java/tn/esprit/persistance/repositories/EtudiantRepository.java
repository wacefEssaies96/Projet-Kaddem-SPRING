package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	
	public Etudiant findByNomEAndPrenomE(@Param("nomE") String nomE, @Param("prenomE") String prenomE);
	
	@Transactional
	@Modifying
	@Query("UPDATE Etudiant e SET e.departement.idDepartement = :idD WHERE e.idEtudiant = :idE")
	public int updateEtudiantByDepartementIdDepartement(@Param("idD") int idD, @Param("idE") int idE);
	
	@Transactional
	@Modifying
	@Query("UPDATE Contrat c SET c.etudiant.idEtudiant = :idE WHERE c.idContrat = :idC")
	public int assignContratToEtudiant(@Param("idC") int idC, @Param("idE") int idE);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO equipe_etudiants VALUES (:idE, :idEt)", nativeQuery = true)
	public void assignEquipeToEtudiant(@Param("idE") int idE, @Param("idEt") int idEt);

}
