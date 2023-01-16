package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Section implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String departement;
	private String nom;
	private List<Mission> missions;
	
	
	
	public Section() {
	}


	public Section(Integer id, String departement, String nom, List<Mission> missions) {
		super();
		this.id = id;
		this.departement = departement;
		this.nom = nom;
		this.missions = missions;
	}
	
	
}
