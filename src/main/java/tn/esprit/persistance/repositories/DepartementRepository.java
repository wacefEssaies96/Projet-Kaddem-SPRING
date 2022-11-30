package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	
}
