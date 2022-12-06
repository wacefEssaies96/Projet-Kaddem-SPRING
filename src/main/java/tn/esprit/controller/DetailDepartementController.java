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

import tn.esprit.persistance.entities.DetailDepartement;
import tn.esprit.service.interfaces.DetailDepartementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detaildepartement")
public class DetailDepartementController {
	
	@Autowired
	DetailDepartementService dds;
	
	@GetMapping("/display")
	public List<DetailDepartement> retrieveAllDetailDepartements() {
		return this.dds.retrieveAllDetailDepartements();
	}
	
	@GetMapping("/display/detaildepartement/{id}")
	public DetailDepartement getDetailDepartement(@PathVariable("id") int id) {
		return this.dds.retrieveDetailDepartement(id);
	}
	
	@PostMapping("/ajouter")
	public DetailDepartement addDetailDepartement(@RequestBody DetailDepartement dd) {
		return this.dds.addDetailDepartement(dd);
	}
	
	@PutMapping("/modifier")
	public DetailDepartement modifierDetailDepartement(@RequestBody DetailDepartement dd) {
		return this.dds.updateDetailDepartement(dd);
	}
	
	@DeleteMapping("/supprimer/{id}")
    public void supprimerDetailDepartementById(@PathVariable("id") int id) {
    	dds.removeDetailDepartement(id);
    }
	
}
