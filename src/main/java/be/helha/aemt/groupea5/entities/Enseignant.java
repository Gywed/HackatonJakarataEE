package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Enseignant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Attribution.class)
	private List<Attribution> attribution;
	
	public Enseignant() {
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String nom, String prenom, String mail, String remarque, List<Attribution> attribution) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.remarque = remarque;
		this.attribution = attribution;
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

	public List<Attribution> getAttribution() {
		return attribution;
	}

	public void setAttribution(List<Attribution> attribution) {
		this.attribution = attribution;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attribution, id, mail, nom, prenom, remarque);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		return Objects.equals(attribution, other.attribution) && Objects.equals(id, other.id)
				&& Objects.equals(mail, other.mail) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(remarque, other.remarque);
	}
	
}
