package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Projet;

public interface ProjetService {
	List<Projet> retrieveAllProjects();
	Projet addProjet (Projet p);
	Projet updateProjet (Projet p);
    Projet  retrieveProjet (Integer idprojet);
	void deleteprojet( Integer idprojet);

	public void assignProjetToEquipe (Integer idEquipe, Integer idprojet);
	public Integer incrementNbrLike(Projet p);

	public List<Projet> getProjetsOfEquipe(int idEquipe);

}
