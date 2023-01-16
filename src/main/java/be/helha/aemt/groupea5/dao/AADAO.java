package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
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
	
	public AADAO() {
		// TODO Auto-generated constructor stub
	}
	
	public AA find(AA e) {
		TypedQuery<AA> query = em.createNamedQuery("findByCode", AA.class);
		query.setParameter(1, e.getCode());
		List<AA> list = query.getResultList();
		
		em.clear();
		
		return list.isEmpty() ? null : list.get(0);
	}
}
