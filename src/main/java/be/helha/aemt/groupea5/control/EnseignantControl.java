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
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
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
		bean.add(new Enseignant(nom, prenom, mail, remarque, attrs));
	}
	public void doInforamtions() {
		enseignant.setMail(mail);
		enseignant.setNom(nom);
		enseignant.setPrenom(prenom);
		enseignant.setRemarque(remarque);
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
