package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "Contrat")
public class Contrat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private int idContrat;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebutContrat;
	
	@Temporal(TemporalType.DATE)
	private Date dateFinContrat;
	
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	
	private boolean archive;
	
	private int montantContrat;
	
	private int nbrLike;
	
	@JsonIgnore
	@ManyToOne
	private Etudiant etudiant;

	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + ", dateDebutContrat=" + dateDebutContrat + ", dateFinContrat="
				+ dateFinContrat + ", specialite=" + specialite + ", archive=" + archive + ", montantContrat="
				+ montantContrat + "]";
	}
	
}
