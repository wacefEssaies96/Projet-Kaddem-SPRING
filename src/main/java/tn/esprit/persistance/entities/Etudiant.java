package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEtudiant")
	private Integer idEtudiant; 
	private String nomE;
	private String prenomE;
	private String sexe;
	private String password;
	private String email;
	private int nbrLike;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Enumerated(EnumType.STRING)
	private Option op;
	
	@JsonIgnore
	@ManyToOne
	private Departement departement;
	
	@JsonIgnore
	@OneToMany(mappedBy="etudiant")
	private Set<Contrat> contrats;
	
	@JsonIgnore
	@OneToMany(mappedBy="etudiant")
	private Set<Stage> stages;
	
	@JsonIgnore
	@ManyToMany(mappedBy="etudiants")
	private Set<Equipe> equipe;
	
	@OneToOne
	private User user;

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomE=" + nomE + ", prenomE=" + prenomE + ", sexe=" + sexe
				+ ", password=" + password + ", email=" + email + ", dateNaissance=" + dateNaissance + "]";
	}
	
}