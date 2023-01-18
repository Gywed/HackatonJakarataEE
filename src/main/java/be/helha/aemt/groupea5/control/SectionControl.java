package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import be.helha.aemt.groupea5.ejb.SectionEJB;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.Section;


@Named
@SessionScoped
public class SectionControl implements Serializable
{
	@EJB
	private SectionEJB beanGestion;
	
	private Departement departement;
	private String nom;
	private List<Mission> missions;
	private Section selectedSection = null;
	private Section newSection = new Section(new Departement(), "", null);
	
	public List<Section> doFindAll() 
	{
		return beanGestion.findAll();
	}
	
	public Section doAdd() 
	{
		Section e = new Section(this.departement, this.nom, this.missions);
		return beanGestion.add(e);
	}
	
	public void goToUpdateSection(Section section) 
	{
	    selectedSection = section;
	}

	public SectionEJB getBeanGestion() {
		return beanGestion;
	}

	public void setBeanGestion(SectionEJB beanGestion) {
		this.beanGestion = beanGestion;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) 
	{
		this.missions = missions;
	}

	public Section getSelectedSection() {
		return selectedSection;
	}

	public void setSelectedSection(Section selectedSection) 
	{
		this.selectedSection =null;
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
	

	
	
	
	
	

	
	
}