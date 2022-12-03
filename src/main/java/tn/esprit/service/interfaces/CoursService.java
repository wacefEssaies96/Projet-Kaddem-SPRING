package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Cours;

public interface CoursService {
	public List<Cours> retrieveAllCours();
	public Cours updateCours(Cours c);
	public Cours addCours(Cours c);
	public Cours retrieveCours(Integer idCours);
	public void removeCours(Integer idCours);
}
