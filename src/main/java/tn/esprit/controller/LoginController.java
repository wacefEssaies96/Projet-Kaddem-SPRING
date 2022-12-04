package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.service.classes.MyUserDetailsService;
import tn.esprit.service.classes.UserService;
import tn.esprit.util.TokenUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
	/*@GetMapping("/login")
	public String login(){
		return "authenticated successfully" ;
	}*/
	@Autowired
	private MyUserDetailsService userService;
	@Autowired
	private UserService us;
	@Autowired
	private AuthenticationManager authenticationManager;
 
	@RequestMapping(value = "/authenticate/{username}/{password}", method = { RequestMethod.GET })
	public String authenticate(@PathVariable("username") String username, @PathVariable("password") String password) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = this.authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = this.userService.loadUserByUsername(username);
			log.info(TokenUtil.createToken(userDetails).toString());
			
			return this.us.findUserByUserName(username).getRole();
 
		} catch (BadCredentialsException bce) {
			log.error(bce.getMessage());
			return "null";
 
		} catch (Exception e) {
			log.error(e.getMessage());
			return "null";
		}
 
	}

}
