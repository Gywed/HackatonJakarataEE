package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UE implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = AnneeAcademique.class)
	private AnneeAcademique anneeAcademique;
	
	@OneToOne(targetEntity = Departement.class)
	private Departement departement;
	
	@OneToOne(targetEntity = Section.class)
	private Section section;
	
	private Integer bloc;
	private String code;
	private String intitule;
	private Integer credit;
	
	@OneToMany(mappedBy = "ue", cascade = CascadeType.ALL,targetEntity = AA.class)
	private List<AA> aas;
	
	public UE() 
	{

	}

	public UE(AnneeAcademique anneeAcademique, Departement departement, Section section, Integer bloc, String code,
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
	
	/**
	 * Add an AA in the AA's list
	 */
	public Boolean addAA(AA aa) {
		if(aas.contains(aa))
			return false;
		return aas.add(aa);
	}
	
	/**
	 * Add a range of AAs in AAs list
	 * @return true if the range has been added
	 */
	public boolean addAllAA(List<AA> aaRange) {
		for (AA aa : aaRange) {
			if(aas.contains(aa))
				return false;
		}
		return aas.addAll(aaRange);
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getBloc() {
		return bloc;
	}

	public void setBloc(Integer bloc) {
		this.bloc = bloc;
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

	public List<AA> getAas() {
		return aas;
	}

	public void setAas(List<AA> aas) {
		this.aas = aas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aas, anneeAcademique, bloc, code, credit, departement, id, intitule, section);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UE other = (UE) obj;
		return Objects.equals(aas, other.aas) && Objects.equals(anneeAcademique, other.anneeAcademique)
				&& Objects.equals(bloc, other.bloc) && Objects.equals(code, other.code)
				&& Objects.equals(credit, other.credit) && Objects.equals(departement, other.departement)
				&& Objects.equals(id, other.id) && Objects.equals(intitule, other.intitule)
				&& Objects.equals(section, other.section);
	}

	@Override
	public String toString() {
		return "UE [id=" + id + ", anneeAcademique=" + anneeAcademique + ", departement=" + departement + ", section="
				+ section + ", bloc=" + bloc + ", code=" + code + ", intitule=" + intitule + ", credit=" + credit
				+ ", aas=" + aas + "]";
	}
	
	
}
