package be.helha.aemt.groupea5.control;

import be.helha.aemt.groupea5.ejb.EnseignantEJB;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
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
	
	public EnseignantControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
