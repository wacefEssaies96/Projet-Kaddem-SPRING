package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "Departement")
public class Departement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDepartement")
	private int idDepartement;
	
	private String nomDepart;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER ,mappedBy="departement")
	private Set<Etudiant> etudiants;

	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepart=" + nomDepart + "]";
	}

}
