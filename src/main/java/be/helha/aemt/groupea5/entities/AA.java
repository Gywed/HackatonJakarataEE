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
	@NamedQuery(name = "findAAByCode", query ="select a from AA a where a.code = ?1"),
	@NamedQuery(name = "findAAById", query ="select a from AA a where a.id = ?1")
})
public class AA implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = AnneeAcademique.class)
	private AnneeAcademique anneeAcademique;
	
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

	public AA(AnneeAcademique anneeAcademique, String code, String intitule, Integer credit, Integer heure, Integer heureQ1,
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getHeure() {
		return heure;
	}

	public void setHeure(Integer heure) {
		this.heure = heure;
	}

	public Integer getHeureQ1() {
		return heureQ1;
	}

	public void setHeureQ1(Integer heureQ1) {
		this.heureQ1 = heureQ1;
	}

	public Integer getHeureQ2() {
		return heureQ2;
	}

	public void setHeureQ2(Integer heureQ2) {
		this.heureQ2 = heureQ2;
	}

	public Integer getNombreGroupe() {
		return nombreGroupe;
	}

	public void setNombreGroupe(Integer nombreGroupe) {
		this.nombreGroupe = nombreGroupe;
	}

	public Integer getNombreEtudiant() {
		return nombreEtudiant;
	}

	public void setNombreEtudiant(Integer nombreEtudiant) {
		this.nombreEtudiant = nombreEtudiant;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AA other = (AA) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "AA [id="+id+", code=" + code + ", intitule=" + intitule + "]";
	}

	
	
}
