package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import be.helha.aemt.groupea5.ejb.SectionEJB;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Section;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class SectionControl implements Serializable
{
	@EJB
	private SectionEJB beanGestion;
	private String departement;
	private String nom;
	private Section selectedSection = new Section(new Departement(), "", null);
	
	public List<Section> doFindAll() 
	{
		return beanGestion.findAll();
	}
	
	public List<Section> doFindAllSorted() 
	{
		return beanGestion.findAllSorted();
	}
	
	public Section doAdd() 
	{
		Section SectiontoAdd = new Section(new Departement(departement,null,null), nom, null);
		return beanGestion.add(SectiontoAdd);
	}
	
	public void goToUpdateSection(Section section) 
	{
		selectedSection =null;
	    selectedSection = section;
	}
	
	public String doDelete(Section e) 
	{
		beanGestion.delete(e);
		
		return "Section/manageV2?faces-redirect=true"; 
	}
	
	

	public SectionEJB getBeanGestion() 
	{
		return beanGestion;
	}

	public void setBeanGestion(SectionEJB beanGestion) 
	{
		this.beanGestion = beanGestion;
	}

	public String getDepartement() 
	{
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
		
	}

	public Section getSelectedSection() 
	{
		return selectedSection;
	}

	public void setSelectedSection(Section selectedSection) 
	{
		this.selectedSection = selectedSection;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	
}