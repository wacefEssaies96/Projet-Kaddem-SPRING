package tn.esprit.service.classes;

import java.util.List;


import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Club;
import tn.esprit.persistance.repositories.ClubRepository;
import tn.esprit.service.interfaces.ClubService;

@Service
@Slf4j
public class ClubServiceImpl implements ClubService{
	@Autowired
	ClubRepository clubRep;
	
	@Override
	public Club afficherClub(int id) {
		Club p = null ; 
		try {
			p = this.clubRep.findById(id).get();
			log.info(p.toString());
		} catch (EntityNotFoundException e2) {
			log.error(e2.getMessage()); }
		return p;
	}

	@Override
	public Club ajouterClub(Club p) {
		Club pp = null;
		try {
			pp = this.clubRep.save(p);
			log.info("Club a été ajouté avec succés !");
		} catch (PersistenceException e2) {
			log.error(e2.getMessage());
		}
		return pp;
	}

	@Override
	public Club modifierClub(Club newClub) {
		Club pp = null;
		try {
			pp = this.clubRep.save(newClub);
			log.info("Club a été mis à jour avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
		return pp;
	}

	@Override
	public void supprimerClub(int id) {
		try {
			this.clubRep.deleteById(id);
			log.info("Club a été supprimé avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());}
		
	}

	@Override
	public List<Club> chercherClubs() {
		List<Club> l = this.clubRep.findAll();
		for(Club p : l) {
			log.info("Club : " + p.toString());
		}
		return l;
	}
	

}
