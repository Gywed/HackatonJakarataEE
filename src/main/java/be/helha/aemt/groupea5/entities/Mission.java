package be.helha.aemt.groupea5.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mission implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int anneeAcademique;
	private String intitule;
	private int heures;
	
	
	public Mission() {
	}


	public Mission(Integer id, int anneeAcademique, String intitule, int heures) {
		super();
		this.id = id;
		this.anneeAcademique = anneeAcademique;
		this.intitule = intitule;
		this.heures = heures;
	}
	
	

}
