package tn.esprit.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.User;
import tn.esprit.persistance.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User findUserByUserName(String unserName) {
		return this.userRep.findByUserName(unserName);
	}
	
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		return this.userRep.save(user);
	}
}
