package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import be.helha.aemt.groupea5.ejb.DepartementEJB;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.Section;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class DepartementControl implements Serializable
{
	@EJB
	private DepartementEJB beanGestion;
	
	private String nom;
	private List<Section> sections;
	private List<Mission> missions;
	
	private Departement selectedDepartement;
	private Departement newDepartement = new Departement();;

	
	
	public List<Departement> doFindAll() 
	{
		return beanGestion.findAll();
	}
	
	public Departement doAdd() 
	{
		return beanGestion.add(this.newDepartement);
	}
	
	
	public void actualiseDepartement(Departement departement) 
	{
	    selectedDepartement = departement;
	}
	
	public String getNom() 
	{
		return nom;
	}


	public void setNom(String nom) 
	{
		this.nom = nom;
	}


	public List<Section> getSections() 
	{
		return sections;
	}


	public void setSections(List<Section> sections) 
	{
		this.sections = sections;
	}


	public List<Mission> getMissions() 
	{
		return missions;
	}


	public void setMissions(List<Mission> missions) 
	{
		this.missions = missions;
	}


	public DepartementEJB getBeanGestion() 
	{
		return beanGestion;
	}


	public void setBeanGestion(DepartementEJB beanGestion) 
	{
		this.beanGestion = beanGestion;
	}


	public Departement getSelectedDepartement() 
	{
		return selectedDepartement;
	}


	public void setSelectedDepartement(Departement selectedDepartement) 
	{
		this.selectedDepartement = selectedDepartement;
	}

	public Departement getNewDepartement() 
	{
		return newDepartement;
	}

	public void setNewDepartement(Departement newDepartement) 
	{
		this.newDepartement = newDepartement;
	}
	
}
