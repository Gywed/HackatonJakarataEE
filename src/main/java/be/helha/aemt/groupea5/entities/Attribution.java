package be.helha.aemt.groupea5.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attribution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer anneeAcademique;
	private List<AA> aas;
	private List<Mission> missions;
	
	public Attribution() {
		// TODO Auto-generated constructor stub
	}

	public Attribution(Integer anneeAcademique, List<AA> aas, List<Mission> missions) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.aas = aas;
		this.missions = missions;
	}
}
