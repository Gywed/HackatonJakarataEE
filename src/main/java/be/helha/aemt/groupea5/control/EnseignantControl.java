package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupea5.dao.AnneeAcademiqueDAO;
import be.helha.aemt.groupea5.ejb.AnneeAcademiqueEJB;
import be.helha.aemt.groupea5.ejb.EnseignantEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.exception.AlreadyExistsException;
import be.helha.aemt.groupea5.exception.WrongMailException;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EnseignantControl implements Serializable {
	
	@EJB
	private EnseignantEJB bean;
	
	private Enseignant enseignant = new Enseignant();
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	
	private AnneeAcademique anneeAcademique;
	private List<AA> aas = new ArrayList<>();
	private List<Mission> missions = new ArrayList<>();
	
	public EnseignantControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void clearData() {
		nom = "";
		prenom="";
		mail="";
		remarque="";
		aas.clear();
		missions.clear();
	}
	
	public List<Enseignant> doFindAll() {
		return bean.findAll();
	}
	public void doAdd() {
		Attribution attr = new Attribution(anneeAcademique, aas, missions);
		List<Attribution> attrs = new ArrayList<>();
		attrs.add(attr);
		try {
			bean.add(new Enseignant(nom, prenom, mail, remarque, attrs));
			clearData();
			showInfo("Ajout réussi");
		} catch (AlreadyExistsException | WrongMailException e) {
			// TODO Auto-generated catch block
			showError(e.getMessage());
		}
		
	}
	
	public void doDelete(Enseignant e) {
		bean.delete(e);
	}
	
	public void doSetInformations(Enseignant e) {
		setMail(e.getMail());
		setNom(e.getNom());
		setPrenom(e.getPrenom());
		setRemarque(e.getMail());
		setEnseignant(e);
		System.out.println(mail);
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

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public AnneeAcademique getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public List<AA> getAas() {
		return aas;
	}

	public void setAas(List<AA> aas) {
		this.aas = aas;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

}
