package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import be.helha.aemt.groupea5.ejb.SectionEJB;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.Section;


@Named
@ViewScoped
public class SectionControl implements Serializable
{
	@EJB
	private SectionEJB beanGestion;
	
	/*private Departement departement;*/

	private Section selectedSection = new Section(new Departement(), "", null);
	private Section newSection = new Section(new Departement(), "", null);
	private boolean disableSelectItem;
	
	public List<Section> doFindAll() 
	{
		return beanGestion.findAll();
	}
	
	public Section doAdd() 
	{
	
		return beanGestion.add(newSection);
	}
	
	public void goToUpdateSection(Section section) 
	{
		selectedSection =null;
	    selectedSection = section;
	}

	public SectionEJB getBeanGestion() {
		return beanGestion;
	}

	public void setBeanGestion(SectionEJB beanGestion) 
	{
		this.beanGestion = beanGestion;
	}

	/*public Departement getDepartement() 
	{
		return departement;
	}

	public void setDepartement(Departement departement) 
	{
		this.departement = departement;
	}*/


	public Section getSelectedSection() 
	{
		return selectedSection;
	}

	public void setSelectedSection(Section selectedSection) 
	{
		this.selectedSection = selectedSection;
	}

	public Section getNewSection() 
	{
		return newSection;
	}

	public void setNewSection(Section newSection) 
	{
		this.newSection = newSection;
	}

	public boolean isDisableSelectItem() 
	{
		return disableSelectItem;
	}

	public void setDisableSelectItem(boolean disableSelectItem) 
	{
		this.disableSelectItem = disableSelectItem;
	}
	

	
}