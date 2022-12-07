package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Cours;
import tn.esprit.persistance.entities.Universite;
import tn.esprit.persistance.repositories.CoursRepository;
import tn.esprit.persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.CoursService;

@Service
public class CoursServiceImpl implements CoursService{

	@Autowired
	CoursRepository courRep;
	@Autowired
	UniversiteRepository univRepo;
	
	@Override
	public List<Cours> retrieveAllCours() {
		return courRep.findAll();
	}

	@Override
	public Cours updateCours(Cours c) {
		courRep.save(c);
		return c;
	}

	@Override
	public Cours addCours(Cours c) {
		courRep.save(c);
		return c;
	}

	@Override
	public Cours retrieveCours(Integer idCours) {
		return courRep.findById(idCours).get();
	}

	@Override
	public void removeCours(Integer idCours) {
		courRep.deleteById(idCours);
	}

	@Override
	public List<Cours> getCoursOfUniversite(int idUniv) {
		Universite u = univRepo.getById(idUniv);
		ArrayList<Cours> l = new ArrayList<Cours>(u.getCours());
		return l;
	}

}
