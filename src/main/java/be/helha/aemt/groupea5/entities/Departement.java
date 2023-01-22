package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "findDepartementByName", query ="select d from Departement d where d.nom = ?1"),
	@NamedQuery(name = "findDepartementById", query ="select d from Departement d where d.id = ?1")
})
public class Departement implements Serializable, Comparable<Departement>
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	@OneToMany(targetEntity = Section.class,fetch=FetchType.EAGER, orphanRemoval = true)
	private List<Section> sections;
	@ManyToMany(targetEntity = Mission.class,fetch=FetchType.EAGER)
	private List<Mission> missions;
	
	
	public Departement() {
	}


	public Departement(String nom, List<Section> sections, List<Mission> missions) {
		super();
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
		return Objects.hash(nom);
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
		return Objects.equals(nom, other.nom);
	}


	@Override
	public String toString() 
	{
		return nom;
	}


	@Override
	public int compareTo(Departement o) 
	{
		 return this.getNom().compareTo(o.getNom());
	}
}
