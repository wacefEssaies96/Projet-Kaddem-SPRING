package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Universite")
public class Universite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idUniv")
	private int idUniv;
	
	private String nomUniv;
	private String descriptionUniv;
	private String imgUniv;
	private int nbrLike;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationUniv;
	
	@Enumerated(EnumType.STRING)
	private TypeUniversite typeuniv;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Departement> departements;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Cours> cours;

	@Override
	public String toString() {
		return "Universite [idUniv=" + idUniv + ", nomUniv=" + nomUniv + ", descriptionUniv=" + descriptionUniv
				+ ", dateCreationUniv=" + dateCreationUniv + ", typeuniv=" + typeuniv + "]";
	}

}
