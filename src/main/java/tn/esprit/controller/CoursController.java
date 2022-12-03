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

import tn.esprit.persistance.entities.Cours;
import tn.esprit.service.interfaces.CoursService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cours")
public class CoursController {

	@Autowired
	CoursService courServ;
	
	@GetMapping("/displayAllCours")
	public List<Cours> displayAllCours () {
		return courServ.retrieveAllCours();
	}
	
	@GetMapping("/displayCours/{idCour}")
	public Cours displayCours (@PathVariable("idCour") int idCour) {
		return courServ.retrieveCours(idCour);
	}
	
	@PostMapping("/addCours")
	public Cours addCours(@RequestBody Cours c) {
		return courServ.addCours(c);
	}
	
	@PutMapping("/updateCours")
	public Cours updateCours (@RequestBody Cours c) {
		return  courServ.updateCours(c);
	}
	
	@DeleteMapping("/deleteCours/{idCours}")
	public void DeleteCours(@PathVariable("idCours") int coursId) {
		courServ.removeCours(coursId);
	}
}
