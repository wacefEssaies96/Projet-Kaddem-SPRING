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

import tn.esprit.persistance.entities.Projet;

import tn.esprit.service.interfaces.ProjetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projet")
public class ProjetController {
	
	@Autowired
	ProjetService proServ;
	
	@GetMapping("/display")
	public List<Projet> displayAllprojects () {
		return proServ.retrieveAllProjects();
	}
	
	@GetMapping("/display/projet/{idProjet}")
	public Projet displayProjet(@PathVariable("idProjet") int idProjet) {
		return proServ.retrieveProjet(idProjet);
	}
	
	@PostMapping("/ajouter")
	public Projet addProjet(@RequestBody Projet p) {
		return proServ.addProjet(p);
	}
	
	@PutMapping("/modifier")
	public Projet updateProjet (@RequestBody Projet p) {
		return  proServ.updateProjet(p);
	}

	@GetMapping("/assignProToEquipe/{idProjet}/{idEquipe}")
	public void AffecterProjetToEquipe(@PathVariable("idProjet") int projetId,@PathVariable("idEquipe") int equipeId) {
		proServ.assignProjetToEquipe(projetId, equipeId);
	}
	
	/*@GetMapping("/assignUnivDepJpql/{idUniv}/{idDep}")
	public void AffectUniverToDepartjpql(@PathVariable("idUniv") int universiteId,@PathVariable("idDep") int departementId) {
		proServ.assignUniversiteToDepartementjpql(universiteId, departementId);
	}*/
	
	@DeleteMapping("/supprimer/{idPro}")
	public void DeleteProjeT(@PathVariable("idPro") int ProjetId) {
		proServ.deleteprojet(ProjetId);
	}
	
	/*@GetMapping("/displayUniversitesOrderByDate")
	public List<Universite> displayAllUniversitesOrderByDate () {
		return univerServ.getUniversitesByDateDesc();
	}*/
	
	@PutMapping("/incrementLikes")
	public Integer invcrementLikes(@RequestBody Projet p) {
		return this.proServ.incrementNbrLike(p);
	}

}

