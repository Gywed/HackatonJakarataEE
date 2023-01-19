package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnneeAcademique implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String anneeAcademique;

	public AnneeAcademique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnneeAcademique(String anneeAcademique) {
		super();
		this.anneeAcademique = anneeAcademique;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(String anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(anneeAcademique);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnneeAcademique other = (AnneeAcademique) obj;
		return Objects.equals(anneeAcademique, other.anneeAcademique);
	}

	@Override
	public String toString() {
		return anneeAcademique;
	}
	

}
