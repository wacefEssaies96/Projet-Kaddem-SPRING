package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.TypeUniversite;
import tn.esprit.persistance.entities.Universite;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.UniversiteService;

@Service
public class UniversiteServiceImpl implements UniversiteService {
	
	//injection des dépendences de la couche repository
		@Autowired
		UniversiteRepository univRepo;
		
		@Autowired 
		DepartementRepository depRepo;
		
		@Override
		public List<Universite> retrieveAllUniversites() {
			return univRepo.findAll();
		}

		@Override
		public Universite addUniversite(Universite u) {
			univRepo.save(u);
			return u;
		}

		@Override
		public Universite updateUniversite(Universite u) {
			univRepo.save(u);
			return u;
		}

		@Override
		public Universite retrieveUniversite(Integer idUniversite) {
			return univRepo.findById(idUniversite).get();
		}

		/*@Override
		public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
			Universite univ=univRepo.findById(idUniversite).get();
			Departement dep=depRepo.findById(idDepartement).get();
			Set<Departement> s=univ.getDepartements();
			s.add(dep);
			univ.setDepartements(s);
			univRepo.save(univ);
		}*/

		@Override
		public void assignUniversiteToDepartementjpql(Integer idUniversite, Integer idDepartement) {
			univRepo.updateAssignUniversityToDepartement(idUniversite, idDepartement);
		}

		@Override
		public void deleteUniversite(Integer idUniver) {
			univRepo.deleteById(idUniver);
		}

		@Override
		public Universite getUniversiteByName(String name) {
			return univRepo.findBynomUnivIgnoreCase(name);
		}

		@Override
		public List<Universite> getUniversiteByType(TypeUniversite type) {
			return univRepo.findBytypeuniv(type);
		}

		@Override
		public void assignUniversiteToCoursjpql(Integer idUniversite, Integer idCours) {
			univRepo.updateAssignUniversityToCours(idUniversite, idCours);
		}

		@Override
		public List<Object[]> countByType() {
			return this.univRepo.getNbrTypeUniv();
		}

		/*@Override
		public List<Universite> getUniversitesByDateDesc() {
			return univRepo.;
		}*/
		@Override
		public Integer incrementNbrLike(Universite u) {
			int inc = u.getNbrLike();
			inc++;
			u.setNbrLike(inc);
			univRepo.save(u);
			return inc;
		}

}
