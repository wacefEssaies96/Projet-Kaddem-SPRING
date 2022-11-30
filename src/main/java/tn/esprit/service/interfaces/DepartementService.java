package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Departement;

public interface DepartementService {
	public List<Departement> retrieveAllDepartements();
	public Departement updateDepartement(Departement d);
	public Departement addDepartement(Departement d);
	public Departement retrieveDepartement(Integer idDepartement);
	public void removeDepartement(Integer idDepartement);
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
