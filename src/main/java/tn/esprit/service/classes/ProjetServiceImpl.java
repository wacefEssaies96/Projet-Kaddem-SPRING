package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Projet;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.ProjetRepository;
import tn.esprit.service.interfaces.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {
	
	//injection des dépendences de la couche repository
	@Autowired
	ProjetRepository projetRepo;
	
	@Autowired 
	EquipeRepository equiRepo;
	
	@Override
	public List<Projet> retrieveAllProjects() {
		return projetRepo.findAll();
	}

	@Override
	public Projet addProjet( Projet p) {
		projetRepo.save(p);
		return p;
	}

	@Override
	public Projet updateProjet(Projet p) {
		projetRepo.save(p);
		return p;
	}

	@Override
	public Projet retrieveProjet(Integer idprojet) {
		return projetRepo.findById(idprojet).get();
	}

	/*@Override 
	public void assignProjetToEquipe(Integer idEquipe, Integer idprojet) {
		Projet univ=projetRepo.findById(idEquipe).get();
		Equipe dep=equiRepo.findById(idProjet).get();
		Set<Departement> s=univ.getDepartements();
		s.add(dep);
		univ.setDepartements(s);
		univRepo.save(univ);*/
	
	public void assignProjetToEquipe(Integer idEquipe, Integer idProjet) {
		  projetRepo.updateassignProjetToEquipe(idEquipe, idProjet);
	}
	
	
	@Override
	public void deleteprojet(Integer idProjet) {
		projetRepo.deleteById(idProjet);
	}
	@Override
	public Integer incrementNbrLike(Projet p) {
		int inc = p.getNbrLike();
		inc++;
		p.setNbrLike(inc);
		projetRepo.save(p);
		return inc;
	}
}
