package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Utilisateur;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class UtilisateurDAO {
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;
	
	@EJB
	private DepartementDAO depDao;
	
	public UtilisateurDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur find(Utilisateur e) {
		TypedQuery<Utilisateur> query = em.createNamedQuery("findUserByEmail", Utilisateur.class);
		query.setParameter(1, e.getEmail());
		List<Utilisateur> list = query.getResultList();
		
		em.clear();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public Utilisateur findById(Utilisateur e) {
		TypedQuery<Utilisateur> query = em.createNamedQuery("findUserById", Utilisateur.class);
		query.setParameter(1, e.getId());
		List<Utilisateur> list = query.getResultList();
		
		em.clear();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		String strQuery="Select a from Utilisateur a";
		TypedQuery<Utilisateur> query = em.createQuery(strQuery,Utilisateur.class);
		return query.getResultList();
	}
	
	public Utilisateur add(Utilisateur e) {
		if (e == null) return null;
		if (e == find(e)) return null;
		Departement dep = depDao.find(e.getDepartement());
		
		if (dep != null)
			e.setDepartement(dep);
		
		return em.merge(e);
	}
	
	public Utilisateur delete(Utilisateur e) {
		if (e == null) return null;
		
		Utilisateur dbE = findById(e);
		if (dbE == null) return null;
		
		em.remove(em.merge(dbE));
		return dbE;
	}

	public Utilisateur update(Utilisateur e) {
		if (e == null) return null;
		Utilisateur dbE = findById(e);
		e.setId(dbE.getId());
		
		return em.merge(e);
				
	}
}
