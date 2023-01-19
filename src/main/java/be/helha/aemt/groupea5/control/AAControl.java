package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import be.helha.aemt.groupea5.ejb.AAEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Fraction;
import be.helha.aemt.groupea5.entities.Utilisateur;
import be.helha.aemt.groupea5.exception.WrongArgumentException;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AAControl implements Serializable {
	
	@EJB
	private AAEJB beanGestion;
	
	private AA aa;
	
	private String anneeAcademique;
	private String code;
	private String intitule;
	private Integer credit;
	private Integer heure;
	private Integer heureQ1;
	private Integer heureQ2;
	private Integer nombreGroupe;
	private Integer nombreEtudiant;
	private Fraction fraction;
	
	private List<Fraction> fractions;
	
	private List<String> anneeAcademiques;
	
	public AAControl() {
		// TODO Auto-generated constructor stub
		fractions = Arrays.asList(Fraction.values());
	}
	
	public void clearData() {
		setAnneeAcademique(null);
		setCode("");
		setIntitule("");
		setCredit(0);
		setHeure(0);
		setHeureQ1(0);
		setHeureQ2(0);
		setNombreEtudiant(0);
		setNombreGroupe(0);
		setFraction(null);
	}
	
	public List<AA> doFindAll()
	{
		return beanGestion.findAll();
	}
			
	public void doAdd() {
		try {
			beanGestion.add(new AA(new AnneeAcademique(anneeAcademique),code,intitule,credit,heure,heureQ1,heureQ2,nombreGroupe,nombreEtudiant,fraction));
			clearData();
			showInfo("Ajout réussi");
		} catch (WrongArgumentException e) {
			// TODO Auto-generated catch block
			showError(e.getMessage());
		}
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
	
	public void showError(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erreur", message);
    }
	
	public void showInfo(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, "Info", message);
    }
	
	public String doDelete(AA aa) {
		beanGestion.delete(aa);
		clearData();
		return "aas?faces-redirect=true";
	}
	
	public void doSetInformation(AA aa) {
		setAa(aa);
		setAnneeAcademique(aa.getAnneeAcademique().toString());
		setCode(aa.getCode());
		setCredit(aa.getCredit());
		setFraction(aa.getFraction());
		setHeure(aa.getHeure());
		setHeureQ1(aa.getHeureQ1());
		setHeureQ2(aa.getHeureQ2());
		setIntitule(aa.getIntitule());
		setNombreEtudiant(aa.getNombreEtudiant());
		setNombreGroupe(aa.getNombreGroupe());
	}
	
	public String doUpdate() {
		aa.setAnneeAcademique(new AnneeAcademique(anneeAcademique));
		aa.setCode(code);
		aa.setCredit(credit);
		aa.setFraction(fraction);
		aa.setHeure(heure);
		aa.setHeureQ1(heureQ1);
		aa.setHeureQ2(heureQ2);
		aa.setIntitule(intitule);
		aa.setNombreEtudiant(nombreEtudiant);
		aa.setNombreGroupe(nombreGroupe);
		beanGestion.update(aa);
		clearData();
		return "aas?faces-redirect=true";
	}

	public AAEJB getBeanGestion() {
		return beanGestion;
	}

	public void setBeanGestion(AAEJB beanGestion) {
		this.beanGestion = beanGestion;
	}

	public String getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(String anneeAcademique) {
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

	public AA getAa() {
		return aa;
	}

	public void setAa(AA aa) {
		this.aa = aa;
	}

	public List<Fraction> getFractions() {
		return fractions;
	}

	public void setFractions(List<Fraction> fractions) {
		this.fractions = fractions;
	}

	public List<String> getAnneeAcademiques() {
		return anneeAcademiques;
	}

	public void setAnneeAcademiques(List<String> anneeAcademiques) {
		this.anneeAcademiques = anneeAcademiques;
	}
}
