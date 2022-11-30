package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.entities.TypeUniversite;
import tn.esprit.persistance.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="insert into universite_departements values(:idUniv, :idDep)", nativeQuery=true)
	public void updateAssignUniversityToDepartement (@Param("idUniv") Integer universiteId,@Param("idDep") Integer departementId) ;

	public Universite findBynomUnivIgnoreCase(String name);
	
	/*@Query("select u from Universite orderBy dateCreationUniv desc")
	public List<Universite> retriveAllUniversitiesByDateDesc();*/
	
	//@Query("FROM Universite WHERE typeuniv= :type")
	public List<Universite> findBytypeuniv(TypeUniversite type);
}
