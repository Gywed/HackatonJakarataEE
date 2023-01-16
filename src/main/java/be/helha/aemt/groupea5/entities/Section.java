package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(departement, id, missions, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return Objects.equals(departement, other.departement) && Objects.equals(id, other.id)
				&& Objects.equals(missions, other.missions) && Objects.equals(nom, other.nom);
	}
	
	
}