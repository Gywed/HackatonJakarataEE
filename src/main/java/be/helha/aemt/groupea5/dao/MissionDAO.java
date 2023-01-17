package be.helha.aemt.groupea5.dao;

import java.util.List;


import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class MissionDAO {
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;

	public MissionDAO() {
	}
	public List<Mission> findAll() {
		// TODO Auto-generated method stub
		String strQuery="Select m from Mission m";
		TypedQuery<Mission> query = em.createQuery(strQuery,Mission.class);
		return query.getResultList();
	}
	public Mission find(Mission m) {
		if(m==null)return null;
		String strQuery = "select m from Mission m where m.intitule = ?2 "
				+ "and m.anneeAcademique = ?3 "
				+ "and m.heures = ?4";
		TypedQuery<Mission> query = em.createQuery(strQuery,Mission.class);

		query.setParameter(2, m.getIntitule());
		query.setParameter(3, m.getAnneeAcademique());
		query.setParameter(4, m.getHeures());
		List<Mission> list = query.getResultList();
		if(list.size()==0)
			return null;
		Mission res = list.get(0);
		
		return res;
	}
	
	public Mission add(Mission m) {
		if(m==null)
			return null;
		
		return em.merge(m);
	}
	
	public Mission delete(Mission m) {
		if(m==null)
			return null;
		Mission mASupp = find(m);
		if(mASupp==null)return null;
		em.remove(mASupp);
		return mASupp;
		
	}
	
	public Mission findById(Mission m) {
		if (m==null) {
			return null;
		}
		Mission res = em.find(Mission.class, m.getId());
		
		return res;
	}
	

	public Mission update(Mission m) {
		if (m==null) {
			return null;
		}
		Mission mFound = findById(m);
		m.setId(mFound.getId());
		return em.merge(m);
	}
}
