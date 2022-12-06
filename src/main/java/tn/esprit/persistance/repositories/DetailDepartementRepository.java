package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.persistance.entities.DetailDepartement;

public interface DetailDepartementRepository extends JpaRepository<DetailDepartement, Integer>{
	
}
