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

import tn.esprit.persistance.entities.TypeUniversite;
import tn.esprit.persistance.entities.Universite;
import tn.esprit.service.interfaces.UniversiteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/universite")
public class UniversiteController {
	
	@Autowired
	UniversiteService univerServ;
	
	@GetMapping("/displayUniversites")
	public List<Universite> displayAllUniversites () {
		return univerServ.retrieveAllUniversites();
	}
	
	@GetMapping("/displayUniversite/{id}")
	public Universite displayUniversite (@PathVariable("id") int id) {
		return univerServ.retrieveUniversite(id);
	}
	
	@PostMapping("/addUniversite")
	public Universite addUniversite(@RequestBody Universite u) {
		return univerServ.addUniversite(u);
	}
	
	@PutMapping("/updateUniversite")
	public Universite updateUniversite (@RequestBody Universite u) {
		return  univerServ.updateUniversite(u);
	}

	/*@GetMapping("/assignUnivDep/{idUniv}/{idDep}")
	public void AffectUniverToDepart(@PathVariable("idUniv") int universiteId,@PathVariable("idDep") int departementId) {
		univerServ.assignUniversiteToDepartement(universiteId, departementId);
	}*/
	
	@GetMapping("/assignUnivDepJpql/{idUniv}/{idDep}")
	public void AffectUniverToDepartjpql(@PathVariable("idUniv") int universiteId,@PathVariable("idDep") int departementId) {
		univerServ.assignUniversiteToDepartementjpql(universiteId, departementId);
	}
	
	@GetMapping("/assignUnivCourJpql/{idUniv}/{idCour}")
	public void AffectUniverToCoursjpql(@PathVariable("idUniv") int universiteId,@PathVariable("idCour") int coursId) {
		univerServ.assignUniversiteToCoursjpql(universiteId, coursId);
	}
	
	@DeleteMapping("/deleteUniversite/{idUniv}")
	public void DeleteUniver(@PathVariable("idUniv") int universiteId) {
		univerServ.deleteUniversite(universiteId);
	}
	
	@GetMapping("/displayUniversiteByName/{name}")
	public Universite displayUniversiteByName (@PathVariable("name") String nom) {
		return univerServ.getUniversiteByName(nom);
	}
	
	@GetMapping("/displayUniversiteByType/{type}")
	public List<Universite> displayUniversiteByType (@PathVariable("type") TypeUniversite type) {
		return univerServ.getUniversiteByType(type);
	}
	
	/*@GetMapping("/displayUniversitesOrderByDate")
	public List<Universite> displayAllUniversitesOrderByDate () {
		return univerServ.getUniversitesByDateDesc();
	}*/

}
