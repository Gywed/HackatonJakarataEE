package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.AnneeAcademiqueDAO;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AnneeAcademiqueEJB {
	
	@EJB
	private AnneeAcademiqueDAO dao;
	
	public List<AnneeAcademique> findAll(){
		return dao.findAll();
	}

	public AnneeAcademique find(AnneeAcademique a) {
		return dao.find(a);
	}
	
	public AnneeAcademique add(AnneeAcademique a) {
		return dao.add(a);
	}
	
	public AnneeAcademique delete(AnneeAcademique a) {
		return dao.delete(a);
	}
	
	public AnneeAcademique updtae(AnneeAcademique a) {
		return dao.update(a);
	}
}
