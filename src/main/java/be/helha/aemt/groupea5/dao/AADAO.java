package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class AADAO {

	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;
	
	@EJB
	private AnneeAcademiqueDAO anneeDAO;
	
	public AADAO() {
		// TODO Auto-generated constructor stub
	}
	
	public AA find(AA e) {
		TypedQuery<AA> query = em.createNamedQuery("findAAByCode", AA.class);
		query.setParameter(1, e.getCode());
		List<AA> list = query.getResultList();
		
		em.clear();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public AA findById(AA e) {
		TypedQuery<AA> query = em.createNamedQuery("findAAById", AA.class);
		query.setParameter(1, e.getId());
		List<AA> list = query.getResultList();
		
		em.clear();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<AA> findAll() {
		// TODO Auto-generated method stub
		String strQuery="Select a from AA a";
		TypedQuery<AA> query = em.createQuery(strQuery,AA.class);
		return query.getResultList();
	}
	
	public AA add(AA e) {
		if (e == null) return null;
		if (e == find(e)) return null;
		
		AnneeAcademique dbAnnee = anneeDAO.find(e.getAnneeAcademique());
		if (dbAnnee != null)
			e.setAnneeAcademique(dbAnnee);
		
		
		return em.merge(e);
	}
	
	public AA delete(AA e) {
		if (e == null) return null;
		
		AA dbE = findById(e);
		if (dbE == null) return null;
		
		em.remove(em.merge(dbE));
		return dbE;
	}

	public AA update(AA e) {
		if (e == null) return null;
		AA dbE = findById(e);
		e.setId(dbE.getId());
		
		return em.merge(e);
				
	}
}
