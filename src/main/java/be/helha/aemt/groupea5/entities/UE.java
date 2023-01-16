package be.helha.aemt.groupea5.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer anneeAcademique;
	private Departement departement;
	private Section section;
	private Integer bloc;
	private String code;
	private String intitule;
	private Integer credit;
	private List<AA> aas;
	
	public UE() {
		// TODO Auto-generated constructor stub
	}

	public UE(Integer anneeAcademique, Departement departement, Section section, Integer bloc, String code,
			String intitule, Integer credit, List<AA> aas) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.departement = departement;
		this.section = section;
		this.bloc = bloc;
		this.code = code;
		this.intitule = intitule;
		this.credit = credit;
		this.aas = aas;
	}
}
