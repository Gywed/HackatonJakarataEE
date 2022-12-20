package be.helha.aemt.groupea5.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String departement;
	private String role;
		
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom, String email, String password, String departement, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.departement = departement;
		this.role = role;
	}
}
