package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;
import be.helha.aemt.groupea5.ejb.AttributionEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AttributionControl implements Serializable {
	
	@EJB
	private AttributionEJB beanGestion;
	
	private String enseignant;
	private AA aa;
	private Mission mission;
	
	private boolean multiple;
	
	private List<AA> selectedAAs;
	private List<Mission> selectedMissions;

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
}
