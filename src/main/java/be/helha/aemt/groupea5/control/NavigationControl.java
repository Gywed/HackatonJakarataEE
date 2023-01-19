package be.helha.aemt.groupea5.control;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class NavigationControl implements Serializable{
	
	private String nom;
	
	public String doSec() {
		return "sec?faces-redirect=true";
	}
	
	public String doLogin() {
		System.out.println("ALED");
		return "login?faces-redirect=true";
	}
	
	public String doDep() {
		return "dep?faces-redirect=true";
	}
	
	public String doDom() {
		return "dom?faces-redirect=true";
	}
	
	public String doAddAA() {
		return "AA/addAA?faces-redirect=true";
	}
	
	public String doListAA() {
		return "AA/listAA?faces-redirect=true";
	}
	
	public String doListSections()
	{
		return "Section/manageSections?faces-redirect=true;";
	}
	

	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
