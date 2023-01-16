package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, missions, nom, sections);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departement other = (Departement) obj;
		return Objects.equals(id, other.id) && Objects.equals(missions, other.missions)
				&& Objects.equals(nom, other.nom) && Objects.equals(sections, other.sections);
	}
	
	
}
