package tn.esprit.persistance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "DetailDepartement")
public class DetailDepartement implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailDepartement")
	private int idDetailDepartement;
	private int nombreClasses;
	private int nombreEtages;
	

	@JsonIgnore
	@OneToOne(mappedBy="detailDepartement")
	private Departement departement;
	
	@Override
	public String toString() {
		return "DetailDepartement [idDetailDepartement=" + idDetailDepartement + ", nombreClasses=" + nombreClasses
				+ ", nombreEtages=" + nombreEtages + "]";
	}

	
	
	
	

}
