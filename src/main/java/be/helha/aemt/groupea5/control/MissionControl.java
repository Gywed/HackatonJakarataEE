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
	
	
	public List<Mission> doFindAll() {
		return bean.fetchAll();
	}
	
	public List<Mission> doFindByYear(AnneeAcademique ac){
		return bean.findByYear(ac);
	}
	
	public void doAdd() {
		bean.add(new Mission(new AnneeAcademique(anneeAcademique),intitule,heures));
		clearData();
	}
	
	public String doDelete(Mission mission) {
		bean.delete(mission);
		clearData();
		return "Mission?faces-redirect=true";
	}


	public void doSetInformation(Mission mission) {

		setMission(mission);
		setAnneeAcademique(mission.getAnneeAcademique().getAnneeAcademique());
		setIntitule(mission.getIntitule());
		setHeures(mission.getHeures());
	}
	
	public String doUpdate() {
		mission.setAnneeAcademique(new AnneeAcademique(anneeAcademique));
		bean.update(mission);
		clearData();
		return "Mission.xhtml?faces-redirect=true";
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

	
	
}
