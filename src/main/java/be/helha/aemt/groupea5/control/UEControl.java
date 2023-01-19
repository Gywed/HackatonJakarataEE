package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupea5.ejb.UEEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Section;
import be.helha.aemt.groupea5.entities.UE;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


@Named
@SessionScoped
public class UEControl implements Serializable{

	@EJB
	private UEEJB bean;
	
	private UE ue;
	private String anneeAcademique;
	private String departement;
	private String section;
	private Integer bloc;
	private String code;
	private String intitule;
	private Integer credit;
	private List<AA> aas = new ArrayList<>();
	
	public void clearData() {
		setUe(null);
		setAnneeAcademique(null);
		setDepartement(null);
		setSection(null);
		setBloc(null);
		setCode(null);
		setIntitule(null);
		setCredit(null);
		setAas(new ArrayList<>());
	}
	
	public List doFindAll() {
		return bean.findAll();
	}
	
	public void doAdd() {
		System.out.println("ALED");
		System.out.println(anneeAcademique);
		System.out.println(departement);
		System.out.println(section);
		System.out.println(bloc);
		System.out.println(code);
		System.out.println(intitule);
		System.out.println(credit);
		System.out.println(aas);
		bean.add(new UE( new AnneeAcademique(anneeAcademique), new Departement(departement,null,null), new Section(null ,section,null), bloc, code, intitule, credit, aas));
//		bean.add(new UE(null, null, null, 0, null, null, 0, null));
		clearData();
		
	}


	
	
	
	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	public String getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(String anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
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
	
	
	
}
