package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Cours;
import tn.esprit.persistance.repositories.CoursRepository;
import tn.esprit.service.interfaces.CoursService;

@Service
public class CoursServiceImpl implements CoursService{

	@Autowired
	CoursRepository courRep;
	
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

}
