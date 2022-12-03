package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.entities.User;
import tn.esprit.service.classes.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	public User createNewUser(@RequestBody User user) {
		User u = null;
		User userExists = userService.findUserByUserName(user.getUserName());
		if (userExists == null) {
			u = userService.saveUser(user);	
		}
		return u;
	}
}
