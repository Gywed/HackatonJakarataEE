package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import be.helha.aemt.groupea5.ejb.AttributionEJB;
import be.helha.aemt.groupea5.ejb.EnseignantEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AttributionControl implements Serializable {
	
	@EJB
	private AttributionEJB beanGestion;
	
	@EJB
	private EnseignantEJB beanEnseignant;
	
	private String selectedTeacher;
	private Enseignant onGoingEnseignant;
	private String enseignant;
	private AA aa;
	private Mission mission;
	
	private boolean multiple;
	
	private List<AA> selectedAAs;
	private List<Mission> selectedMissions;
	private List<AA> teacherAAs;
	private List<Mission> teacherMissions;
	private List<Attribution> teacherAttributions;

	private List<String> anneeAcademiques;
	
	public AttributionControl() {
		// TODO Auto-generated constructor stub
	}
	
	public void clearData() {
		enseignant = null;
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
	
	public void onTeacherChangeAA() {
		onGoingEnseignant = beanEnseignant.find(new Enseignant(null, null, selectedTeacher, null, null));
		teacherAAs = new ArrayList<>();
		if (onGoingEnseignant != null)
		{
			teacherAttributions = onGoingEnseignant.getAttribution();
			for (Attribution attribution : teacherAttributions)
				teacherAAs.addAll(attribution.getAas());
		}
	}
	
	public void onTeacherChangeMission() {
		onGoingEnseignant = beanEnseignant.find(new Enseignant(null, null, selectedTeacher, null, null));
		teacherMissions = new ArrayList<>();
		if (onGoingEnseignant != null)
		{
			teacherAttributions = onGoingEnseignant.getAttribution();
			for (Attribution attribution : teacherAttributions)
				teacherMissions.addAll(attribution.getMissions());
		}
	}
	
	public void doRemoveAa(AA aa) {
		for (Attribution attri : onGoingEnseignant.getAttribution()) {
			attri.getAas().removeIf(a -> a.getId() == aa.getId());
		}
		teacherAAs.removeIf(a -> a.getId() == aa.getId());
		
		beanGestion.removeAttribution(onGoingEnseignant);
	}
	
	public void doRemoveMission(Mission mission) {
		for (Attribution attri : onGoingEnseignant.getAttribution()) {
			attri.getMissions().removeIf(m -> m.getId() == mission.getId());
		}
		teacherMissions.removeIf(m -> m.getId() == mission.getId());
		
		beanGestion.removeAttribution(onGoingEnseignant);
	}
	
	public void doSetInformationAA(AA aa, boolean multiple) {
		setAa(aa);
		setMultiple(multiple);
	}
	
	public void doSetInformationMission(Mission m, boolean multiple) {
		setMission(m);
		setMultiple(multiple);
	}
	
	public String doAttributeAA() {
		Enseignant e = new Enseignant();
		e.setId(Integer.parseInt(enseignant));
		e.setMail("not Null");
		if (multiple) {
			for (AA a : selectedAAs) {
				beanGestion.attributeAA(e, a);
			}
		}
		else
			beanGestion.attributeAA(e, aa);
		clearData();
		return "attributeAAs?faces-redirect=true";
	}
	
	public String doAttributeMission() {
		Enseignant e = new Enseignant();
		e.setId(Integer.parseInt(enseignant));
		e.setMail("not Null");
		if (multiple) {
			for (Mission m : selectedMissions) {
				beanGestion.attributeMission(e, m);
			}
		}
		else
			beanGestion.attributeMission(e, mission);
		clearData();
		return "attributeMissions?faces-redirect=true";
	}

	public AttributionEJB getBeanGestion() {
		return beanGestion;
	}

	public void setBeanGestion(AttributionEJB beanGestion) {
		this.beanGestion = beanGestion;
	}


	public AA getAa() {
		return aa;
	}

	public void setAa(AA aa) {
		this.aa = aa;
	}

	public String getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	public List<String> getAnneeAcademiques() {
		return anneeAcademiques;
	}

	public void setAnneeAcademiques(List<String> anneeAcademiques) {
		this.anneeAcademiques = anneeAcademiques;
	}

	public List<AA> getSelectedAAs() {
		return selectedAAs;
	}

	public void setSelectedAAs(List<AA> selectedAAs) {
		this.selectedAAs = selectedAAs;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public List<Mission> getSelectedMissions() {
		return selectedMissions;
	}

	public void setSelectedMissions(List<Mission> selectedMissions) {
		this.selectedMissions = selectedMissions;
	}

	public String getSelectedTeacher() {
		return selectedTeacher;
	}

	public void setSelectedTeacher(String selectedTeacher) {
		this.selectedTeacher = selectedTeacher;
	}

	public List<AA> getTeacherAAs() {
		return teacherAAs;
	}

	public void setTeacherAAs(List<AA> teacherAAs) {
		this.teacherAAs = teacherAAs;
	}

	public List<Mission> getTeacherMissions() {
		return teacherMissions;
	}

	public void setTeacherMissions(List<Mission> teacherMissions) {
		this.teacherMissions = teacherMissions;
	}
}
