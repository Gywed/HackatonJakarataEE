package be.helha.aemt.groupea5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer anneeAcademique;
	private String code;
	private String intitule;
	private Integer credit;
	private Integer heure;
	private Integer heureQ1;
	private Integer heureQ2;
	private Integer nombreGroupe;
	private Integer nombreEtudiant;
	private Fraction fraction;
	
	public AA() {
		// TODO Auto-generated constructor stub
	}

	public AA(Integer anneeAcademique, String code, String intitule, Integer credit, Integer heure, Integer heureQ1,
			Integer heureQ2, Integer nombreGroupe, Integer nombreEtudiant, Fraction fraction) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.code = code;
		this.intitule = intitule;
		this.credit = credit;
		this.heure = heure;
		this.heureQ1 = heureQ1;
		this.heureQ2 = heureQ2;
		this.nombreGroupe = nombreGroupe;
		this.nombreEtudiant = nombreEtudiant;
		this.fraction = fraction;
	}
}
