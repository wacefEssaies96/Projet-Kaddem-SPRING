package tn.esprit.service.interfaces;

import java.util.Date;
import java.util.List;

import tn.esprit.persistance.entities.Contrat;

public interface ContratService {
	public List<Contrat> retrieveAllContrats();
	public Contrat updateContrat(Contrat ce);
	public Contrat addContrat(Contrat ce);
	public Contrat retrieveContrat(Integer idContrat);
	public void removeContrat(Integer idContrat);
	
	public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
	public List<Object[]> countBySpecialite();
	public Integer incrementNbrLike(Contrat c);
	public List<Contrat> retrieveContratsOfStudent(int idEtudiant);
	
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
	public String retrieveAndUpdateStatusContrat();
	public Integer nbContratsValides(Date startDate, Date endDate);
	
}
