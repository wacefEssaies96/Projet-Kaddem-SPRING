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

import tn.esprit.persistance.entities.Club;

import tn.esprit.service.interfaces.ClubService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/club")
public class ClubController {
	
	@Autowired
	ClubService clubServ;
	
	@GetMapping("/display")
	public List<Club> displayAllClub() {
		return this.clubServ.chercherClubs();
	}
	
	@GetMapping("/display/club/{id}")
	public Club getClub(@PathVariable("id") int id) {
		return this.clubServ.afficherClub(id);
	}
	
	@PostMapping("/ajouter")
	public Club addClub(@RequestBody Club p) {
		return this.clubServ.ajouterClub(p);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void removeClub(@PathVariable("id") int id) {
		this.clubServ.supprimerClub(id);
	}
	
	@PutMapping("/modifier")
	public Club modifierClub(@RequestBody Club club) {
		return clubServ.modifierClub(club);
	}}