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
@Table(name = "Projet")
public class Projet  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idprojet")
	private int idprojet;
	
	private String nomprojet;
	private String description;
	private int nbrLike;
		
	@Temporal(TemporalType.DATE)
	private Date datelimiteProjet;
	@Enumerated(EnumType.STRING) 
	private Evolution evolution;
	
	@Enumerated(EnumType.STRING) 
	private Matiere matiere;
	
	@JsonIgnore
	@ManyToMany
	private Set<Equipe> equipes;

	@Override
	public String toString() {
		return "Projet [idprojet=" + idprojet + ", nomprojet=" + nomprojet + ", description=" + description
				+ ", datelimiteProjet=" + datelimiteProjet + ", evolution=" + evolution + ", matiere=" + matiere + "]";
	}
   
}
