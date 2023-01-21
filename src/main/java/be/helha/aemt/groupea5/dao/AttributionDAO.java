package be.helha.aemt.groupea5.dao;

import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
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
	
	@EJB
	private EnseignantDAO enseignantDao;
	
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
	
	public List<Attribution> findByDate(AnneeAcademique e) {
		TypedQuery<Attribution> query = em.createNamedQuery("findAttributionByDate", Attribution.class);
		query.setParameter(1, e);
		return query.getResultList();
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
	
	public void attributeAA(Enseignant e, AA a) {
		if (e == null || a == null) return;
		
		Enseignant dbE = enseignantDao.findById(e);
		if (dbE.getAttribution() != null)
			for (Attribution attri : dbE.getAttribution()) {
				if (attri.getAnneeAcademique().getId() == a.getAnneeAcademique().getId()) {
					attri.addAA(a);
					em.persist(attri);
					return;
				}
			}
		Attribution newAttri = new Attribution(a.getAnneeAcademique(), new ArrayList<AA>(), new ArrayList<Mission>());
		newAttri.addAA(a);
		
		dbE.addAttribution(newAttri);
		em.merge(dbE);
	}
	
	public void attributeMission(Enseignant e, Mission m) {
		if (e == null || m == null) return;
		
		Enseignant dbE = enseignantDao.findById(e);
		if (dbE.getAttribution() != null)
			for (Attribution attri : dbE.getAttribution()) {
				if (attri.getAnneeAcademique().getId() == m.getAnneeAcademique().getId()) {
					attri.addMission(m);
					em.persist(attri);
					return;
				}
			}
		Attribution newAttri = new Attribution(m.getAnneeAcademique(), new ArrayList<AA>(), new ArrayList<Mission>());
		newAttri.addMission(m);
		
		dbE.addAttribution(newAttri);
		em.merge(dbE);
	}
}
