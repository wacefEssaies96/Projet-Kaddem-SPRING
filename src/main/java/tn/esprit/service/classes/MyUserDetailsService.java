package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userService.findUserByUserName(username);
		List<GrantedAuthority> authorities = getUserAuthority();
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(),user.getPassword(),user.isActive(),true, true, true, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(){
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("ETUDIANT"));
		return new ArrayList<>(roles);
	}

}
