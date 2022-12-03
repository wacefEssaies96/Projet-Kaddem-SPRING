package tn.esprit.persistance.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority{
	
	ADMIN,ETUDIANT;
	
	@Override
	public String getAuthority() {
		return "ROLE : " + name();
	}

}
