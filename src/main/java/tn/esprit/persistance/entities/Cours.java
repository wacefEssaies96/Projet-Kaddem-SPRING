package tn.esprit.persistance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idCour")
	private int idCour;
	private int codeCour;
	private String intituleCour;
	
	@Enumerated(EnumType.STRING)
	private TypeCours typeCour;

	@Override
	public String toString() {
		return "Cours [idCour=" + idCour + ", codeCour=" + codeCour + ", intituleCour=" + intituleCour + ", typeCour="
				+ typeCour + "]";
	}
	
}
