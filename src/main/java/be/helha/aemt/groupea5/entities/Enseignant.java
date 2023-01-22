package be.helha.aemt.groupea5.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Attribution.class, fetch = FetchType.EAGER, orphanRemoval = true)
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
	
	public void addAttribution(Attribution a) {
		attribution.add(a);
	}
	
	public void replaceAttribution(Attribution newA) {
		int index = -1;
		for (Attribution attr : attribution) {
			if(attr.getId() == newA.getId())
				index = attribution.indexOf(attr);
				
		}
		if(index!=-1)
			attribution.set(index, newA);
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
		return Objects.hash(id, mail, nom, prenom);
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
		return Objects.equals(id, other.id) && Objects.equals(mail, other.mail) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return nom + " " + prenom + " | " + mail;
	}
	
	
	
}
