package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.Enseignant;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class EnseignantDAO {
	
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;

	public EnseignantDAO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public List<Enseignant> findAll(){
		String strUA="Select e from Enseignant e ";
		TypedQuery<Enseignant> queryA = em.createQuery(strUA, Enseignant.class);
		return queryA.getResultList();
	}
	
	public Enseignant find(Enseignant e) {
		TypedQuery<Enseignant> query = em.createQuery("Select e from Enseignant e where e.mail = ?1", Enseignant.class);
		query.setParameter(1, e.getMail());
		List<Enseignant> result = query.getResultList();
		System.out.println(result);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public Enseignant add(Enseignant e) {
		if (e==null) {
			return null;
		}
		
		if (find(e) != null) {
			return null;
		}
		return em.merge(e);

		
	}
	
	public Enseignant delete(Enseignant e) {
		if (e==null) {
			return null;
		}
		
		em.remove(find(e));
		
		return e;
	}
	
	public Enseignant update(Enseignant e) {
		if (e==null) return null;
		
		Enseignant dbE = find(e);
		if(dbE==null) return null;
		e.setId(dbE.getId());
		
		return em.merge(e);
	
	}

}
