package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.helha.aemt.groupea5.dao.DepartementDAO;
import be.helha.aemt.groupea5.ejb.DepartementEJB;
import be.helha.aemt.groupea5.ejb.EnseignantEJB;
import be.helha.aemt.groupea5.ejb.UtilisateurEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Fraction;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.Role;
import be.helha.aemt.groupea5.entities.Utilisateur;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UtilisateurControl implements Serializable {
	
	@EJB
	private UtilisateurEJB beanUser;
	
	@EJB
	private DepartementEJB beanDep;
	
	private Utilisateur utilisateur = new Utilisateur();
	
	private String nom;
	private String prenom;
	private String email;
	private String password;	
	private String departement;
	private Role role;
	
	private List<Role> roles;
	
	private List<Departement> deps;
	
	private List<String> depsNom;
	
	
	public UtilisateurControl() {
		super();
		// TODO Auto-generated constructor stub
		roles = Arrays.asList(Role.values());
		
	}
	
	@PostConstruct
	public void init() {
		deps = beanDep.findAll();
	}
	
	public void clearData() {
		nom = "";
		prenom="";
		email="";
		password="";
		departement = "";
	}
	
	public List<Utilisateur> doFindAll() {
		return beanUser.findAll();
	}
	public void doAdd() {
		beanUser.add(new Utilisateur(nom, prenom, email, password,new Departement(departement, null, null), role));
	}
	public void doInformations() {
		utilisateur.setEmail(email);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setPassword(password);
		utilisateur.setRole(role);
		utilisateur.setDepartement(new Departement(departement, null, null));
	}

	public Utilisateur getutilisateur() {
		return utilisateur;
	}

	public void setutilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Departement> getDeps() {
		return deps;
	}

	public void setDeps(List<Departement> deps) {
		this.deps = deps;
	}

	public List<String> getDepsNom() {
		return depsNom;
	}

	public void setDepsNom(List<String> depsNom) {
		this.depsNom = depsNom;
	}
}
