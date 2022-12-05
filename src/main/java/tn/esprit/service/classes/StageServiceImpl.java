package tn.esprit.service.classes;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Stage;
import tn.esprit.persistance.repositories.StageRepository;
import tn.esprit.service.interfaces.StageService;

@Service
@Slf4j
public class StageServiceImpl implements StageService {
	@Autowired
	private StageRepository sr;

	@Override
	public List<Stage> retrieveAllStages() {
		List<Stage> l = this.sr.findAll();
		for(Stage s : l) {
			log.info("Stages : " + s.toString());
		}
		return l;
	}

	@Override
	public Stage updateStage(Stage se) {
		Stage s =  null;
		try {
			s = this.sr.save(se);
			log.info("Stage à été modifié avec succés !");
		}catch(EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return s;
	}

	@Override
	public Stage addStage(Stage se) {
		Stage s =  null;
		try {
			s = this.sr.save(se);
			log.info("Stage à été ajouté avec succés !");
		}catch(PersistenceException e) {
			log.error(e.getMessage());
		}
		return s;
	}

	@Override
	public Stage retrieveStage(Integer idStage) {
		Stage s =  null;
		try {
			s = sr.findById(idStage).get();
			log.info(s.toString());
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return s;
	}

	@Override
	public void removeStage(Integer idStage) {
		try {
    		sr.deleteById(idStage);
     		log.info("Stage supprimé ");
    	}catch(NoSuchElementException e) {
    		log.info("Echec de supprimer un Stage  :"+e.getMessage());
        }
	}

	@Override
	public List<Object[]> countByType() {
		// TODO Auto-generated method stub
		return this.sr.getNbrTypeStage();
	}
	@Override
	public Integer incrementNbrLike(Stage s) {
		int inc = s.getNbrLike();
		inc++;
		s.setNbrLike(inc);
		sr.save(s);
		return inc;
	}
}
