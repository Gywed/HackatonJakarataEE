package be.helha.aemt.groupea5.dao;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EnseignantDAO {
	
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em; 

}
