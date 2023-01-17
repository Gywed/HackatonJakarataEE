package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.Attribution;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class AttributionDAO {

	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;
	
	public AttributionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public Attribution findById(Attribution e) {
		TypedQuery<Attribution> query = em.createNamedQuery("findAttributionById", Attribution.class);
		query.setParameter(1, e.getId());
		List<Attribution> list = query.getResultList();
		
		em.clear();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<Attribution> findAll() {
		// TODO Auto-generated method stub
		String strQuery="Select a from Attribution a";
		TypedQuery<Attribution> query = em.createQuery(strQuery,Attribution.class);
		return query.getResultList();
	}
	
	public Attribution add(Attribution e) {
		if (e == null) return null;
		return em.merge(e);
	}
	
	public Attribution delete(Attribution e) {
		if (e == null) return null;
		
		Attribution dbE = findById(e);
		if (dbE == null) return null;
		
		em.remove(em.merge(dbE));
		return dbE;
	}

	public Attribution update(Attribution e) {
		if (e == null) return null;
		Attribution dbE = findById(e);
		e.setId(dbE.getId());
		
		return em.merge(e);
				
	}
}
