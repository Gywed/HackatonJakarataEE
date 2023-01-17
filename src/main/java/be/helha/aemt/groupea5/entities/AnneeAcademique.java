package be.helha.aemt.groupea5.entities;

import java.io.Serializable;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeAcademique == null) ? 0 : anneeAcademique.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (anneeAcademique == null) {
			if (other.anneeAcademique != null)
				return false;
		} else if (!anneeAcademique.equals(other.anneeAcademique))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
