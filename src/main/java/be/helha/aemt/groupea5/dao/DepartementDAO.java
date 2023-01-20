package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.Departement;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class DepartementDAO 
{
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;

	
	public DepartementDAO() 
	{
	
	}
	
	public Departement find(Departement e) 
	{
		TypedQuery<Departement> query = em.createNamedQuery("findDepartementByName",Departement.class);
		query.setParameter(1, e.getNom());
		List<Departement> list = query.getResultList();
		
		em.clear();
		
		return list.isEmpty() ? null : list.get(0);
	}
	
	public Departement findById(Departement e) 
	{
		TypedQuery<Departement> query = em.createNamedQuery("findDepartementById",Departement.class);
		query.setParameter(1, e.getId());
		List<Departement> list = query.getResultList();
		
		em.clear();
		
		return list.isEmpty() ? null : list.get(0);
	}
	
	
	
	public List<Departement> findAll() 
	{
		String strQuery="Select d from Departement d";
		TypedQuery<Departement> query = em.createQuery(strQuery,Departement.class);
		return query.getResultList();
	}
	
	public Departement add(Departement e) 
	{
		if (e == null) return null;
		
		if (e == find(e)) return null;
		
		return em.merge(e);
	}
	
	public Departement delete(Departement e) 
	{
		if (e == null) return null;
		
		Departement dbE = find(e);
		if (dbE == null) return null;
		
		em.remove(em.merge(dbE));
		
		return dbE;
	}

	public Departement update(Departement e) 
	{
		if (e == null) return null;
		
		Departement dbE = findById(e);
		
		e.setId(dbE.getId());
		
		return em.merge(e);
	}
}
