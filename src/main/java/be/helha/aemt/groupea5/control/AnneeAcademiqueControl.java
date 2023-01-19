package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import be.helha.aemt.groupea5.ejb.AnneeAcademiqueEJB;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AnneeAcademiqueControl implements Serializable{
	
	@EJB
	private AnneeAcademiqueEJB bean;

	public AnneeAcademiqueControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<AnneeAcademique> doFindCurrentAndNextAcademicYear(){
		return bean.findCurrentAndNextAcademicYear();
	}

}
