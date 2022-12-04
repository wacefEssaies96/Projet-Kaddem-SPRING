package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Club;


public interface ClubService {
	public Club afficherClub(int id);
	public  Club ajouterClub(Club p);
	public  Club modifierClub(Club newClub);
	public void supprimerClub(int id);
	public List<Club> chercherClubs();
}
