package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAttributionById", query ="select a from Attribution a where a.id = ?1"),
	@NamedQuery(name = "findAttributionByDate",
	query ="select a from Attribution a where a.anneeAcademique = ?1")
})
public class Attribution implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private AnneeAcademique anneeAcademique;
	@OneToMany(targetEntity = AA.class, fetch = FetchType.EAGER)
	private List<AA> aas;
	@OneToMany(targetEntity = Mission.class, fetch = FetchType.EAGER)
	private List<Mission> missions;
	
	public Attribution() {
		// TODO Auto-generated constructor stub
	}

	public Attribution(AnneeAcademique anneeAcademique, List<AA> aas, List<Mission> missions) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.aas = aas;
		this.missions = missions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AnneeAcademique getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public List<AA> getAas() {
		return aas;
	}

	public void setAas(List<AA> aas) {
		this.aas = aas;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aas, anneeAcademique, id, missions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribution other = (Attribution) obj;
		return Objects.equals(aas, other.aas) && Objects.equals(anneeAcademique, other.anneeAcademique)
				&& Objects.equals(id, other.id) && Objects.equals(missions, other.missions);
	}
	
	public void addAA(AA newAa) {
		aas.add(newAa);
	}
	
	public void addMission(Mission newMission) {
		missions.add(newMission);
	}

	@Override
	public String toString() {
		return anneeAcademique + " | aas=" + aas + " | missions=" + missions;
	}
	
	
}
