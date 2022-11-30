package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.DetailEquipe;

public interface DetailEquipeService {

    public List<DetailEquipe> retrieveAllDetailEquipes();
    public DetailEquipe addDetailEquipe(DetailEquipe de);
    public DetailEquipe updateDetailEquipe(DetailEquipe de);
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe);
	public void removeDetailEquipe(Integer idDetailEquipe);
}
