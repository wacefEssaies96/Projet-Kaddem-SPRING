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

import tn.esprit.persistance.entities.Equipe;
import tn.esprit.service.interfaces.EquipeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/equipe")
public class EquipeController {
	
	@Autowired
	private EquipeService es;
	
	@GetMapping("/display")
	public List<Equipe> displayAllEquipes() {
		return this.es.retrieveAllEquipes();
	}
	
	@GetMapping("/display/equipe/{id}")
	public Equipe getEquipe(@PathVariable("id") int id) {
		return this.es.retrieveEquipe(id);
	}
	
	@PostMapping("/ajouter")
	public Equipe addEquipe(@RequestBody Equipe e) {
		return this.es.addEquipe(e);
	}
	
	@PutMapping("/modifier")
	public Equipe modifierEquipe(@RequestBody Equipe e) {
		return this.es.updateEquipe(e);
	}

	@DeleteMapping("/supprimer/{id}")
    public void supprimerEquipeById(@PathVariable("id") int id) {
    	es.removeEquipe(id);
    }
	
	@GetMapping("/count-nbr-niveau")
	public List<Object[]> countNbrNiveau() {
		 return this.es.countByNiveau();
	}
	
	@PutMapping("/incrementLikes")
	public Integer invcrementLikes(@RequestBody Equipe e) {
		return this.es.incrementNbrLike(e);
	}
	
}
