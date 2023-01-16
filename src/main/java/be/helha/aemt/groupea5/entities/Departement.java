package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private List<Section> sections;
	private List<Mission> missions;
	
	
	public Departement() {
	}


	public Departement(Integer id, String nom, List<Section> sections, List<Mission> missions) {
		super();
		this.id = id;
		this.nom = nom;
		this.sections = sections;
		this.missions = missions;
	}
	
	
}
