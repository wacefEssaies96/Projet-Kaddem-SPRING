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

import tn.esprit.persistance.entities.Stage;
import tn.esprit.service.interfaces.StageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/stage")
public class StageController {
	@Autowired
	private StageService ss;
	
	@GetMapping("/display")
	public List<Stage> displayAllStages() {
		return this.ss.retrieveAllStages();
	}
	
	@GetMapping("/display/stage/{id}")
	public Stage getStage(@PathVariable("id") int id) {
		return this.ss.retrieveStage(id);
	}
	
	@PostMapping("/ajouter")
	public Stage addStage(@RequestBody Stage s) {
		return this.ss.addStage(s);
	}
	
	@PutMapping("/modifier")
	public Stage modifierStage(@RequestBody Stage stage) {
		return this.ss.updateStage(stage);
	}
	
	@DeleteMapping("/supprimer/{id}")
    public void supprimerStageById(@PathVariable("id") int id) {
    	this.ss.removeStage(id);
    }
	
	@GetMapping("/count-nbr-type")
	public List<Object[]> countNbrType() {
		 return this.ss.countByType();
	}
	
	@PutMapping("/incrementLikes")
	public Integer invcrementLikes(@RequestBody Stage s) {
		return this.ss.incrementNbrLike(s);
	}
}
