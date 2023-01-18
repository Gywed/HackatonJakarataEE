package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.helha.aemt.groupea5.ejb.MissionEJB;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class MissionControl implements Serializable{

	@EJB
	private MissionEJB bean;
	
	private Mission mission;
	private String anneeAcademique;
	private String intitule;
	private int heures;
	
	private List<String> anneeAcademiques;
	private SimpleDateFormat y;
	private SimpleDateFormat m;

	private int mois;
	private int annee;
	
	
	
	public MissionControl() {
		// TODO Auto-generated constructor stub
anneeAcademiques = new ArrayList<>();
		
		y = new SimpleDateFormat("yyyy");
		m = new SimpleDateFormat("MM");
		
		Date date = new Date();
		
		annee = Integer.parseInt(y.format(date));
		mois = Integer.parseInt(m.format(date));
		if (mois < 03) {
			anneeAcademiques.add(annee-1 + " - " + annee);
			int anneePro = annee + 1;
			anneeAcademiques.add(annee + " - " + anneePro);
		} else {
			int anneePro = annee + 1;
			anneeAcademiques.add(annee + " - " + anneePro);
			
			int anneeEncorePro = anneePro + 1;
			anneeAcademiques.add(anneePro + " - " + anneeEncorePro);
		}
	}
	
	
	
	public List doFindAll() {
		return bean.fetchAll();
	}
	
	public void doAdd() {
		bean.add(new Mission(new AnneeAcademique(anneeAcademique),intitule,heures));
		clearData();
	}
	public void doTest() {
		System.out.println(intitule);
	}
	
	public String doDelete(Mission mission) {
		bean.delete(mission);
		clearData();
		return "listMission?faces-redirect=true";
	}

	public String doGoToUpdate(Mission mission) {
		setMission(mission);
		setAnneeAcademique(anneeAcademique);
		setIntitule(intitule);
		setHeures(heures);
		return "updateMission.xhtml?faces-redirect=true";
	}
	
	public String doUpdate() {
		mission.setAnneeAcademique(new AnneeAcademique(anneeAcademique));
		bean.update(mission);
		clearData();
		return "listMission.xhtml?faces-redirect=true";
	}
	
	public void clearData() {
		setMission(null);
		setAnneeAcademique(null);
		setIntitule(null);
		setHeures(0);
	}
	
	
	
	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(String anneeAcademique) {
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

	public List<String> getAnneeAcademiques() {
		return anneeAcademiques;
	}

	public void setAnneeAcademiques(List<String> anneeAcademiques) {
		this.anneeAcademiques = anneeAcademiques;
	}

	public SimpleDateFormat getY() {
		return y;
	}

	public void setY(SimpleDateFormat y) {
		this.y = y;
	}

	public SimpleDateFormat getM() {
		return m;
	}

	public void setM(SimpleDateFormat m) {
		this.m = m;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
}
