package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import be.helha.aemt.groupea5.ejb.UtilisateurEJB;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Role;
import be.helha.aemt.groupea5.entities.Utilisateur;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UtilisateurControl implements Serializable {
	
	@EJB
	private UtilisateurEJB beanUser;
	
	private Utilisateur utilisateur = new Utilisateur();
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String oldPassword;
	private String departement;
	private Role role;
	
	private List<Role> roles;
	
	private List<Departement> deps;
	
	public UtilisateurControl() {
		super();
		// TODO Auto-generated constructor stub
		roles = Arrays.asList(Role.values());
	}
	
	public void clearData() {
		nom = "";
		prenom="";
		email="";
		password="";
		oldPassword = "";
		departement = "";
		role = null;
	}
	
	public String doDelete(Utilisateur utilisateur) {
		beanUser.delete(utilisateur);
		clearData();
		return "utilisateurs?faces-redirect=true";
	}
	
	public String doUpdate() {
		utilisateur.setDepartement(new Departement(departement,null,null));
		utilisateur.setEmail(email);
		utilisateur.setPrenom(prenom);
		utilisateur.setNom(nom);
		utilisateur.setRole(role);
		if (password == null)
			utilisateur.setPassword(oldPassword);
		else
			utilisateur.setPassword(password);
		beanUser.update(utilisateur);
		clearData();
		return "utilisateurs?faces-redirect=true";
	}
	
	public List<Utilisateur> doFindAll() {
		return beanUser.findAll();
	}
	
	public void doAdd() {
		beanUser.add(new Utilisateur(nom, prenom, email, password,new Departement(departement, null, null), role));
	}
	
	public void doSetInformation(Utilisateur utilisateur) {
		setutilisateur(utilisateur);
		setEmail(utilisateur.getEmail());
		setNom(utilisateur.getNom());
		setPrenom(utilisateur.getPrenom());
		setOldPassword(utilisateur.getPassword());
		setPassword("");
		setRole(utilisateur.getRole());
		setDepartement(utilisateur.getDepartement().getNom());
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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
}
