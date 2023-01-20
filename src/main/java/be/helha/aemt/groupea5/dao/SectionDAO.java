package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Section;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class SectionDAO 
{
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;
	
	@EJB
	private DepartementDAO depDao;

	
	public SectionDAO() 
	{
	
	}
	
	public Section find(Section section) 
	{
		TypedQuery<Section> query = em.createNamedQuery("findDepartementByName",Section.class);
		query.setParameter(1, section.getNom());
		List<Section> list = query.getResultList();
		
		em.clear();
		
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<Section> findAll() 
	{
		String strQuery="Select s from Section s";
		TypedQuery<Section> query = em.createQuery(strQuery,Section.class);
		return query.getResultList();
	}
	
	public List<Section> findAllSorted() 
	{
		String strQuery="Select s from Section s ORDER BY s.nom";
		TypedQuery<Section> query = em.createQuery(strQuery,Section.class);
		return query.getResultList();
	}
	
	public Section add(Section e) 
	{
		if (e == null) return null;
		
		if (e == find(e)) return null;
		
		Departement dep = depDao.find(e.getDepartement());
		
		if(dep!=null)
		{
			e.setDepartement(dep);
		}
		
		return em.merge(e);
	}
	
	public Section delete(Section e) 
	{
		if (e == null) return null;
		
		Section dbE = find(e);
		
		if (dbE == null) return null;
		
		em.remove(em.merge(dbE));
		
		return dbE;
	}

	public Section update(Section e) 
	{
		if (e == null) return null;
		
		Section dbE = find(e);
		
		e.setId(dbE.getId());
		
		return em.merge(e);
	}
}