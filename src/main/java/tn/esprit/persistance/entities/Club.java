package tn.esprit.persistance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@NoArgsConstructor


@Table(name = "Club")
public class Club {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClub")
	private Integer idClub; 
	
	private String nomClub;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeCreation;
	
	private String image;

	
}
