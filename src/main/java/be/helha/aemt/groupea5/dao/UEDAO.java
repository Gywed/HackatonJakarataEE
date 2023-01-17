package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.UE;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class UEDAO {
	
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;

	public UEDAO() {
		super();
	}
	
	public List<UE> findAll(){
		String strUA="Select ue from UE ue ";
		TypedQuery<UE> queryA = em.createQuery(strUA, UE.class);
		return queryA.getResultList();
	}
	

}
