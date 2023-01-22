package be.helha.aemt.groupea5.control;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class NavigationControl implements Serializable{
	
	public String doLogin() {
		return "/login.xhtml?faces-redirect=true";
	}
}
