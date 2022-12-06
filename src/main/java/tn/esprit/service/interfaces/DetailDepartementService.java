package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.DetailDepartement;

public interface DetailDepartementService {
	public List<DetailDepartement> retrieveAllDetailDepartements();
	public DetailDepartement updateDetailDepartement(DetailDepartement d);
	public DetailDepartement addDetailDepartement(DetailDepartement d);
	public DetailDepartement retrieveDetailDepartement(Integer idDetailDepartement);
	public void removeDetailDepartement(Integer idDetailDepartement);
}
