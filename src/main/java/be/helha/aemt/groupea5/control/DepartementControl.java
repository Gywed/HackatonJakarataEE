package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import be.helha.aemt.groupea5.ejb.DepartementEJB;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Departement;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class DepartementControl implements Serializable
{
	@EJB
	private DepartementEJB beanGestion;
	
	private Departement selectedDepartement;
	private Departement newDepartement = new Departement();

	
	
	public List<Departement> doFindAll() 
	{
		return beanGestion.findAll();
	}
	
	public Departement doAdd() 
	{
		Departement departement = beanGestion.add(this.newDepartement);
		
		//clear the last insert
		newDepartement = null;
		
		return departement;
	}
	
	
	public void actualiseDepartement(Departement departement) 
	{
	    selectedDepartement = departement;
	}
	
	public String doDelete(Departement e) 
	{
		beanGestion.delete(e);
		
		return "Departement/manageDepartements.xhtml?faces-redirect=true"; 
	}
	
	public String doUpdate() 
	{
		System.out.println("salut");
		System.out.println(selectedDepartement.getNom());
		System.out.println(selectedDepartement.getId());
		
		beanGestion.update(selectedDepartement);
		return "Departement/manageDepartements.xhtml?faces-redirect=true";
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
		if(newDepartement==null)
		{
			newDepartement = new Departement();
		}
		return newDepartement;
	}

	public void setNewDepartement(Departement newDepartement) 
	{
		this.newDepartement = newDepartement;
	}
	
}
