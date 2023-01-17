package be.helha.aemt.groupea5.ejb;

import be.helha.aemt.groupea5.dao.AnneeAcademiqueDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AnneeAcademiqueEJB {
	
	@EJB
	private AnneeAcademiqueDAO dao;

}
