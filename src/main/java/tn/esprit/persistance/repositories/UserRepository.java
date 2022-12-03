package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
}
