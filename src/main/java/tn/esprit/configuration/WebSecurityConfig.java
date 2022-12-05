package tn.esprit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.service.classes.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		try {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@Override
	protected void configure(HttpSecurity http){
		try {
			http.cors();
			http.csrf().disable();
			http.authorizeRequests()
			//.antMatchers("/etudiant/**").fullyAuthenticated()
		  	.antMatchers("**").permitAll()
		  	.and().httpBasic(); 
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
