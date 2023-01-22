package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findUserByEmail", query ="select u from Utilisateur u where u.email = ?1"),
	@NamedQuery(name = "findUserById", query ="select u from Utilisateur u where u.id = ?1")
})
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	@ManyToOne(targetEntity = Departement.class)
	private Departement departement;
	
	@Enumerated(EnumType.STRING)
	private Role role;
		
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom, String email, String password, Departement departement, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.departement = departement;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departement, email, id, nom, password, prenom, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(departement, other.departement) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Objects.equals(password, other.password) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(role, other.role);
	}
	
	
}
