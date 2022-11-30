package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.service.interfaces.DepartementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/departement")
public class DepartementController {
	
	@Autowired
	DepartementService ds;
	
	@GetMapping("/display")
	public List<Departement> displayAllContrats() {
		return this.ds.retrieveAllDepartements();
	}
	
	@GetMapping("/display/departement/{id}")
	public Departement getDepartement(@PathVariable("id") int id) {
		return this.ds.retrieveDepartement(id);
	}
	
	@PostMapping("/ajouter")
	public Departement addDepartement(@RequestBody Departement d) {
		return this.ds.addDepartement(d);
	}
	
	@PutMapping("/modifier")
	public Departement modifierDepartement(@RequestBody Departement d) {
		return this.ds.updateDepartement(d);
	}
	
	@DeleteMapping("/supprimer/{id}")
    public void supprimerDepartementById(@PathVariable("id") int id) {
    	ds.removeDepartement(id);
    }
	
	@GetMapping("/get-departements-universite/{idUniversite}")
	public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniversite")int idUniversite) {
		return this.ds.retrieveDepartementsByUniversite(idUniversite);
	}
	
}
