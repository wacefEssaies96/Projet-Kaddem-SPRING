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

import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.service.interfaces.EtudiantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	EtudiantService etudServ;
	
	@GetMapping("/display")
	public List<Etudiant> displayAllStudents() {
		return this.etudServ.chercherEtuduants();
	}
	
	@GetMapping("/display/etudiant/{id}")
	public Etudiant getStudent(@PathVariable("id") int id) {
		return this.etudServ.afficherEtudiant(id);
	}
	
	@PostMapping("/ajouter")
	public Etudiant addStudent(@RequestBody Etudiant e) {
		return this.etudServ.addEtudiantAndUser(e);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void removeEtudiant(@PathVariable("id") int id) {
		this.etudServ.supprimerEtudiant(id);
	}
	
	@PutMapping("/modifier")
	public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
		return etudServ.modifierEtudiant(etudiant);
	}
	
	@GetMapping("/get-etudiants-departement/{idDepartement}")
	public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") int idDepartement){
		return this.etudServ.getEtudiantsByDepartement(idDepartement);
	}
	
	@GetMapping("/assign-etudiant-departement/{etudiantId}/{departementId}")
	public void assignEtudiantToDepartement(@PathVariable("etudiantId") int eId,
			@PathVariable("departementId") int dId) {
		this.etudServ.assignEtudiantToDepartement(eId, dId);
	}
	
	@PostMapping("/add-assign-etudiant-equipe-contrat/{idContrat}/{idEquipe}")
	public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,
			@PathVariable("idContrat") int idContrat, @PathVariable("idEquipe") int idEquipe) {
		return this.etudServ.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
	}
	
	@GetMapping("/count-nbr-sexe")
	public List<Object[]> countNbrSexe() {
		 return this.etudServ.countBySexe();
	}
	
	@PutMapping("/incrementLikes")
	public Integer invcrementLikes(@RequestBody Etudiant e) {
		return this.etudServ.incrementNbrLike(e);
	}
	
}
