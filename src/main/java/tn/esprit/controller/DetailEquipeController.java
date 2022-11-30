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

import tn.esprit.persistance.entities.DetailEquipe;
import tn.esprit.service.interfaces.DetailEquipeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detailequipe")
public class DetailEquipeController {
	
	@Autowired
	private DetailEquipeService des;
	
	@GetMapping("/display")
	public List<DetailEquipe> displayAllDetailEquipes() {
		return this.des.retrieveAllDetailEquipes();
	}
	
	@GetMapping("/display/detailequipe/{id}")
	public DetailEquipe getDetailEquipe(@PathVariable("id") int id) {
		return this.des.retrieveDetailEquipe(id);
	}
	
	@PostMapping("/ajouter")
	public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe de) {
		return this.des.addDetailEquipe(de);
	}
	
	@PutMapping("/modifier")
	public DetailEquipe modifierDetailEquipe(@RequestBody DetailEquipe de) {
		return this.des.updateDetailEquipe(de);
	}

	@DeleteMapping("/supprimer/{id}")
    public void supprimerDetailEquipeById(@PathVariable("id") int id) {
    	des.removeDetailEquipe(id);
    }
	
}
