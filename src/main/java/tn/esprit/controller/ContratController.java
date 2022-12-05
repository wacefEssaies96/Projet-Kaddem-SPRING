package tn.esprit.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.entities.Contrat;
import tn.esprit.service.interfaces.ContratService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contrat")
public class ContratController {
	
	@Autowired
	private ContratService cs;
	
	@GetMapping("/display")
	public List<Contrat> displayAllContrats() {
		return this.cs.retrieveAllContrats();
	}
	
	@GetMapping("/display/contrat/{id}")
	public Contrat getContrat(@PathVariable("id") int id) {
		return this.cs.retrieveContrat(id);
	}
	
	@PostMapping("/ajouter")
	public Contrat addContrat(@RequestBody Contrat c) {
		return this.cs.addContrat(c);
	}
	
	@PutMapping("/modifier")
	public Contrat modifierContrat(@RequestBody Contrat contrat) {
		return this.cs.updateContrat(contrat);
	}
	
	@DeleteMapping("/supprimer/{id}")
    public void supprimerContratById(@PathVariable("id") int id) {
    	cs.removeContrat(id);
    }
	
	@PostMapping("/affect-contrat-etudiant/{nom}/{prenom}")
	public Contrat affectContratToEtudiant(@RequestBody Contrat ce,
			@PathVariable("nom")String nomE, @PathVariable("prenom") String prenomE) {
		return this.cs.affectContratToEtudiant(ce, nomE, prenomE);
	}

	@GetMapping("/get-chiffre-affaire/{startDate}/{endDate}")
	public float getChiffreAffaire(@PathParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return this.cs.getChiffreAffaireEntreDeuxDate(startDate, endDate);
	}
	
	@GetMapping("/contrats-valides/{startDate}/{endDate}")
	public Integer nbContratsValides(@PathParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return this.cs.nbContratsValides(startDate, endDate);
	}
	
	@GetMapping("/count-nbr-specialite")
	public List<Object[]> countNbrSpecialite() {
		 return this.cs.countBySpecialite();
	}
	
	@PutMapping("/incrementLikes")
	public Integer invcrementLikes(@RequestBody Contrat c) {
		return this.cs.incrementNbrLike(c);
	}

}
