package be.helha.aemt.groupea5.control;

import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupea5.ejb.EnseignantEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EnseignantControl {
	
	@EJB
	private EnseignantEJB bean;
	
	private Enseignant enseignant;
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	private Attribution attribution;
	
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

	public Attribution getAttribution() {
		return attribution;
	}

	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}
	

}
