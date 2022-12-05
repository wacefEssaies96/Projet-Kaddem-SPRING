package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.entities.User;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.persistance.repositories.UserRepository;
import tn.esprit.service.interfaces.EtudiantService;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	EtudiantRepository etudRep;
	
	@Autowired
	DepartementRepository departRep;
	
	@Autowired
	private UserRepository userRep;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public Etudiant afficherEtudiant(int id) {
		Etudiant e = null;
		try {
			e = this.etudRep.findById(id).get();
			log.info(e.toString());
		} catch (EntityNotFoundException e2) {
			log.error(e2.getMessage());
		}
		return e;
	}

	@Override
	public Etudiant ajouterEtudiant(Etudiant e) {
		Etudiant ee = null;
		try {
			ee = this.etudRep.save(e);
			log.info("Etudiant a été ajouté avec succés !");
		} catch (PersistenceException e2) {
			log.error(e2.getMessage());
		}
		return ee;
	}

	@Override
	public Etudiant modifierEtudiant(Etudiant newEtudiant) {
		Etudiant ee = null;
		try {
			ee = this.etudRep.save(newEtudiant);
			log.info("Etudiant a été mis à jour avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
		return ee;
	}

	@Override
	public void supprimerEtudiant(int id) {
		try {
			this.etudRep.deleteById(id);
			log.info("Etudiant a été supprimé avec succés !");
		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public List<Etudiant> chercherEtuduants() {
		List<Etudiant> l = this.etudRep.findAll();
		for(Etudiant e : l) {
			log.info("Etudiant : " + e.toString());
		}
		return l;
	}

	@Override
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
		try {
			this.etudRep.updateEtudiantByDepartementIdDepartement(departementId, etudiantId);
			log.info("Etudiant "+etudiantId+" à été affecté au departement "+departementId);

		} catch (PersistenceException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
		Etudiant e3 = null;
		try {
			e3 = this.ajouterEtudiant(e);
			this.etudRep.assignContratToEtudiant(idContrat, e3.getIdEtudiant());
			this.etudRep.assignEquipeToEtudiant(idEquipe, e3.getIdEtudiant());
			log.info("Ajout et l'affectation de l'etudiant à été faite avec succés !");
		} catch (Exception e2) {
			log.error(e2.getMessage());
		}
		return e3;
	}

	@Override
	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
		List<Etudiant> list = null;
		try {
			Departement d = this.departRep.findById(idDepartement).get();
			list = new ArrayList<>(d.getEtudiants());
			for(Etudiant e : list) {
				log.info(e.toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return list;
	}

	@Override
	public Etudiant addEtudiantAndUser(Etudiant e) {
		User u = new User();
		u.setEmail(e.getEmail());
		u.setUserName(e.getPrenomE());
		u.setRole("ETUDIANT");
		u.setPassword(bCryptPasswordEncoder.encode(e.getPassword()));
		u.setActive(true);
		User uu = this.userRep.save(u);
		e.setUser(uu);
		return this.etudRep.save(e);
	}

	@Override
	public List<Object[]> countBySexe() {
		// TODO Auto-generated method stub
		return this.etudRep.getNbrSexe();
	}
	
	@Override
	public Integer incrementNbrLike(Etudiant e) {
		int inc = e.getNbrLike();
		inc++;
		e.setNbrLike(inc);
		etudRep.save(e);
		return inc;
	}

}
