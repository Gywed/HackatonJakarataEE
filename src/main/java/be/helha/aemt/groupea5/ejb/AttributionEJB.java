package be.helha.aemt.groupea5.ejb;

import java.util.List;
import be.helha.aemt.groupea5.dao.AttributionDAO;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AttributionEJB {

	@EJB
	private AttributionDAO dao;

	public List<Attribution> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	public List<Attribution> findByDate(AnneeAcademique e){
		return dao.findByDate(e);
	}

	public void add(Attribution e) {
		// TODO Auto-generated method stub
		dao.add(e);
	}

	public Attribution delete(Attribution e) {
		// TODO Auto-generated method stub
		return dao.delete(e);
	}

	public Attribution update(Attribution e) {
		// TODO Auto-generated method stub
		return dao.update(e);
	}
	
	public void attributeAA(Enseignant e, AA a) {
		dao.attributeAA(e, a);
	}
}
