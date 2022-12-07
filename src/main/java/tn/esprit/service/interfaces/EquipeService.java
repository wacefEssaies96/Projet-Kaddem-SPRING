package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Equipe;

public interface EquipeService {
	public List<Equipe> retrieveAllEquipes();
	public Equipe updateEquipe(Equipe e);
	public Equipe addEquipe(Equipe e);
	public Equipe retrieveEquipe(Integer idEquipe);
	public void removeEquipe(Integer idEquipe);
	
	public List<Object[]> countByNiveau();
	public Integer incrementNbrLike(Equipe e);
	public List<Equipe> retrieveEquipesOfStudent(int idEtudiant);
	public List<Equipe> getEquipesOfProjet(int idprojet);

	public void faireEvoluerEquipes();

}
