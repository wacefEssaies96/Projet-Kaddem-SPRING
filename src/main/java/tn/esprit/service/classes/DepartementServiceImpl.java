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
import tn.esprit.persistance.entities.Universite;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.DepartementService;

@Service
@Slf4j
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementRepository dr;
	
	@Autowired
	private UniversiteRepository ur;
	
	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> l = this.dr.findAll();
		for(Departement d : l) {
			log.info("Departement :" + d.toString());
		}
		return l;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		Departement depart = null; 
		try {
			depart = this.dr.save(d);
			log.info("Departmenet mis à jour avec succés !");
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return depart;
	}

	@Override
	public Departement addDepartement(Departement d) {
		Departement depart = null;
		try {
			depart = this.dr.save(d);
			log.info("Departmenet ajouté avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
		return depart;
	}

	@Override
	public Departement retrieveDepartement(Integer idDepartement) {
		Departement d = null;
		try {
			d = this.dr.findById(idDepartement).get();
			log.info(d.toString());
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return d;
	}

	@Override
    public void removeDepartement(Integer idDepartement) {
    	try {
    		dr.deleteById(idDepartement);
     		log.info("Departement supprimé ");
    	}catch(NoSuchElementException e) {
    		log.info("Echec de supprimer un Departement  :"+e.getMessage());
        }
        
    }

	@Override
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
		List<Departement> list = null;
		try {
			Universite u = this.ur.findById(idUniversite).get();
			list = new ArrayList<>(u.getDepartements());
			for(Departement d : list) {
				log.info(d.toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return list;
	}

}
