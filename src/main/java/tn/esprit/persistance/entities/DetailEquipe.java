package tn.esprit.persistance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "DetailEquipe")
public class DetailEquipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailEquipe")
	private int idDetailEquipe;
	
	private int salle;
	private String thematique;
	@Enumerated(EnumType.STRING)
	private Optiondetail opd;
	
	@JsonIgnore
	@OneToOne(mappedBy="detailEquipe")
	private Equipe equipe;

	@Override
	public String toString() {
		return "DetailEquipe [idDetailEquipe=" + idDetailEquipe + ", salle=" + salle + ", thematique=" + thematique
				+ "]";
	}

}
