package be.helha.aemt.groupea5.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enseignant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	private Attribution attribution;
	
	public Enseignant() {
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String nom, String prenom, String mail, String remarque, Attribution attribution) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.remarque = remarque;
		this.attribution = attribution;
	}
}
