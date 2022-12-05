package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Stage;

public interface StageService {
	public List<Stage> retrieveAllStages();
	public Stage updateStage(Stage s);
	public Stage addStage(Stage s);
	public Stage retrieveStage(Integer idStage);
	public void removeStage(Integer idStage);
	public List<Object[]> countByType();
	public Integer incrementNbrLike(Stage s);

}
