package tn.esprit.service.classes;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Equipe;
import tn.esprit.persistance.entities.Niveau;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.service.interfaces.EquipeService;

@Service
@Slf4j
public class EquipeServiceImpl implements EquipeService {
	
	@Autowired
	private EquipeRepository er;
	
	@Override
	public List<Equipe> retrieveAllEquipes() {
		List<Equipe> l = this.er.findAll();
		for(Equipe e : l) {
			log.info("Equipe : " + e.toString());
		}
		return l;
	}

	@Override
	public Equipe updateEquipe(Equipe e) {
		Equipe equi = null;
		try {
			equi = this.er.save(e);
			log.info("Equipe à été mis à jour avec succés !");

		} catch (EntityNotFoundException e2) {
			log.error(e2.getMessage());
		}
		return equi;
	}

	@Override
	public Equipe addEquipe(Equipe e) {
		Equipe equi = null;
		try {
			equi = this.er.save(e);
			log.info("Equipe à été ajouté avec succés !");
		} catch (PersistenceException e2) {
			log.error(e2.getMessage());
		}
		return equi;
	}

	@Override
	public Equipe retrieveEquipe(Integer idEquipe) {
		Equipe e = null;
		try {
			e = this.er.findById(idEquipe).get();
			log.info(e.toString());
		} catch (EntityNotFoundException e2) {
			log.error(e2.getMessage());
		}
		return e;
	}
	
	 @Override
	    public void removeEquipe(Integer idEquipe) {
	    	try {
	    		er.deleteById(idEquipe);
	     		log.info("Equipe supprimé ");
	    	}catch(NoSuchElementException e) {
	    		log.info("Echec de supprimer un Equipe  :"+e.getMessage());
	        }
	        
	    }

	@Scheduled(cron = "0 30 14 * * *" )
	@Override
	public void faireEvoluerEquipes() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		List<Equipe> l = this.er.retrieveEquipe(calendar.getTime());
		for(Equipe e : l) {
			if (e.getNiveau().toString() == "JUNIOR") {
				e.setNiveau(Niveau.SENIOR);
			}
			else {
				e.setNiveau(Niveau.EXPERT);
			}
			this.er.save(e);
			log.info("Equipe : "+e.getIdEquipe()+" a été évolué !");
		}
	}

	@Override
	public List<Object[]> countByNiveau() {
		// TODO Auto-generated method stub
		return this.er.getNbrNiveau();
	}
	
	@Override
	public Integer incrementNbrLike(Equipe e) {
		int inc = e.getNbrLike();
		inc++;
		e.setNbrLike(inc);
		er.save(e);
		return inc;
	}

}
