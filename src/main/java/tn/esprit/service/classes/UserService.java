package tn.esprit.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.entities.User;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.persistance.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	EtudiantRepository etudRep;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User findUserByUserName(String unserName) {
		return this.userRep.findByUserName(unserName);
	}
	
	public Etudiant saveUser(Etudiant e) {
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
}
