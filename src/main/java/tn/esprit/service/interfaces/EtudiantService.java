package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Etudiant;

public interface EtudiantService {
	public Etudiant afficherEtudiant(int id);
	public Etudiant ajouterEtudiant(Etudiant e);
	public Etudiant modifierEtudiant(Etudiant newEtudiant);
	public void supprimerEtudiant(int id);
	public List<Etudiant> chercherEtuduants();
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId);
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement);
	public Etudiant addEtudiantAndUser(Etudiant e);
	public List<Object[]> countBySexe();
	public Integer incrementNbrLike(Etudiant e);

}
