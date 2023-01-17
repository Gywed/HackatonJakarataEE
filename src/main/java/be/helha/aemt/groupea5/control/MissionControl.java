package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import be.helha.aemt.groupea5.ejb.MissionEJB;
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
	private int anneeAcademique;
	private String intitule;
	private int heures;
	
	
	public List doFindAll() {
		return bean.fetchAll();
	}
	
	public void doAdd() {
		bean.add(new Mission(anneeAcademique,intitule,heures));
		clearData();
	}
	
	public void doDelete(Mission mission) {
		bean.delete(mission);
		clearData();
	}

	public String doGoToUpdate(Mission mission) {
		setMission(mission);
		return "updateMission.xhtml?faces-redirect=true";
	}
	
	public String doUpdate() {
		bean.update(mission);
		clearData();
		return "listMission.xhtml?faces-redirect=true";
	}
	
	public void clearData() {
		setMission(null);
		setAnneeAcademique(0);
		setIntitule(null);
		setHeures(0);
	}
	
	
	
	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public int getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(int anneeAcademique) {
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
