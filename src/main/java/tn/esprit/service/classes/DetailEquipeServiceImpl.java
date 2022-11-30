package tn.esprit.service.classes;


import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.DetailEquipe;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.service.interfaces.DetailEquipeService;

@Slf4j
@Service
public class DetailEquipeServiceImpl implements DetailEquipeService {
	
    @Autowired
    DetailEquipeRepository der;

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipes() {
    	List<DetailEquipe> l = this.der.findAll();
    	for(DetailEquipe de : l) {
			log.info("DetailEquipe :"+de.toString());
		}
        return l;
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe de) {
    	DetailEquipe de1=null;
    	try {
    		de1=this.der.save(de);
     		log.info("DetailEquipe à été mis à jour avec succés ! ");
    	}catch(EntityNotFoundException e) {
    		log.info(e.getMessage());
        }
        return de1;
    }
    
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe de) {
    	DetailEquipe de1=null;
    	try {
    		de1=this.der.save(de);
     		log.info("DetailEquipe à ajouté avec succés ! ");
    	}catch(EntityNotFoundException e) {
    		log.info(e.getMessage());
        }
        return de1;
    }
    
    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
    	DetailEquipe de=null;
        try {
    		de=this.der.findById(idDetailEquipe).get();
    		log.info(de.toString());
    	} catch(NoSuchElementException e) {
        	log.info(e.getMessage());
    	}
    	return de;
    }
    
    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
    	try {
    		der.deleteById(idDetailEquipe);
     		log.info("DetailEquipe supprimé ");
    	}catch(NoSuchElementException e) {
    		log.info("Echec de supprimer un DetailEquipe  :"+e.getMessage());
        }
        
    }



   
    
}
