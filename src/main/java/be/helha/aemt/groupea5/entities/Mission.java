package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findNotAttribuedMission", 
			query ="select m from Mission m where m not in (Select mm from Attribution attri join attri.missions mm)")
})
public class Mission implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = AnneeAcademique.class)
	private AnneeAcademique anneeAcademique;
	private String intitule;
	private int heures;
	
	
	public Mission() {
	}


	public Mission(AnneeAcademique anneeAcademique, String intitule, int heures) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.intitule = intitule;
		this.heures = heures;
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


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public int getHeures() {
		return heures;
	}


	public void setHeures(int heures) {
		this.heures = heures;
	}


	@Override
	public int hashCode() {
		return Objects.hash(anneeAcademique, heures, id, intitule);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		return intitule.equals(other.getIntitule());
	}


	@Override
	public String toString() {
		return "Mission [id=" + id + ", anneeAcademique=" + anneeAcademique + ", intitule=" + intitule + ", heures="
				+ heures + "]";
	}
	
	
	

}
