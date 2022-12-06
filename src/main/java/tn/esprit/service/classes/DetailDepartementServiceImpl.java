package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.DetailDepartement;
import tn.esprit.persistance.entities.Universite;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.DetailDepartementRepository;
import tn.esprit.persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.DetailDepartementService;

@Service
@Slf4j
public class DetailDepartementServiceImpl implements DetailDepartementService {

	@Autowired
	private DetailDepartementRepository ddr;
	
	@Override
	public List<DetailDepartement> retrieveAllDetailDepartements() {
		List<DetailDepartement> l = this.ddr.findAll();
		for(DetailDepartement dd : l) {
			log.info("DetailDepartement :" + dd.toString());
		}
		return l;
	}

	@Override
	public DetailDepartement updateDetailDepartement(DetailDepartement dd) {
		DetailDepartement ddepart = null; 
		try {
			ddepart = this.ddr.save(dd);
			log.info("Detail Departmenet mis à jour avec succés !");
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return ddepart;
	}

	@Override
	public DetailDepartement addDetailDepartement(DetailDepartement dd) {
		DetailDepartement ddepart = null;
		try {
			ddepart = this.ddr.save(dd);
			log.info("DetailDepartement ajouté avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
		return ddepart;
	}

	@Override
	public DetailDepartement retrieveDetailDepartement(Integer idDetailDepartement) {
		DetailDepartement dd = null;
		try {
			dd = this.ddr.findById(idDetailDepartement).get();
			log.info(dd.toString());
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return dd;
	}

	@Override
    public void removeDetailDepartement(Integer idDetailDepartement) {
    	try {
    		ddr.deleteById(idDetailDepartement);
     		log.info("DetailDepartement supprimé ");
    	}catch(NoSuchElementException e) {
    		log.info("Echec de supprimer un DetailDepartement  :"+e.getMessage());
        }
        
    }

}
