package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.TypeUniversite;
import tn.esprit.persistance.entities.Universite;

public interface UniversiteService {
	List<Universite> retrieveAllUniversites();
	Universite addUniversite (Universite u);
	Universite updateUniversite (Universite u);
	Universite retrieveUniversite (Integer idUniversite);
	void deleteUniversite(Integer idUniver);
	//public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
	public void assignUniversiteToDepartementjpql (Integer idUniversite, Integer idDepartement);
	
	public void assignUniversiteToCoursjpql (Integer idUniversite, Integer idCours);
	
	public Universite getUniversiteByName(String name);
	//public List<Universite> getUniversitesByDateDesc();
	public List<Universite> getUniversiteByType(TypeUniversite type);
	
	public List<Object[]> countByType();
	public Integer incrementNbrLike(Universite u);

}
