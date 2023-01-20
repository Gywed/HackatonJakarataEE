package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.exception.AlreadyExistsException;
import be.helha.aemt.groupea5.exception.WrongMailException;
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
		return result.isEmpty() ? null : result.get(0);
	}
	
	public Enseignant findById(Enseignant e) {
		TypedQuery<Enseignant> query = em.createQuery("Select e from Enseignant e where e.id = ?1", Enseignant.class);
		query.setParameter(1, e.getId());
		List<Enseignant> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}
	
	public Enseignant add(Enseignant e) throws AlreadyExistsException, WrongMailException {
		String pattern = "^\\S+@helha\\.be$";
		
		if (e==null) {
			return null;
		}
		
		if(!e.getMail().matches(pattern))
			throw new WrongMailException("L'adresse e-mail doit respecter le format : ******@helha.be");
		
		
		if (find(e) != null) {
			 throw new AlreadyExistsException("Cet enseignant existe déjà");
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
