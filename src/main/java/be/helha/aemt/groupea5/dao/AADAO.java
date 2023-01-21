package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.exception.WrongArgumentException;
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
	
	public List<AA> findNotAttribuedAA(){
		TypedQuery<AA> query = em.createNamedQuery("findNotAttribuedAA", AA.class);
		return query.getResultList();
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
	
	public List<AA> findByYear(AnneeAcademique ac){
		if(ac==null)
			ac = anneeDAO.findCurrentAndNextAcademicYear().get(0);
		String strQuery = "select aa from AA aa where aa.anneeAcademique.id = ?1 ";
		TypedQuery<AA> query = em.createQuery(strQuery,AA.class);

		query.setParameter(1, ac.getId());
		return query.getResultList();
	}
	
	public void add(AA e) throws WrongArgumentException {
		if (e == null) return;
		if (e == find(e)) return;
		
		if(e.getHeure()<1)
			throw new WrongArgumentException("Il faut au moins 1 heure par AA");
		
		if(e.getHeureQ1()+e.getHeureQ2() != e.getHeure())
			throw new WrongArgumentException("Les heures au Q1 et Q2 doivent égaler les heures totals");
		
		if(e.getCredit()<1)
			throw new WrongArgumentException("Il faut au moins 1 crédit par AA");
		
		if(e.getNombreGroupe()<1)
			throw new WrongArgumentException("Il faut au moins 1 groupe par AA");
		
		if(e.getNombreEtudiant()<1)
			throw new WrongArgumentException("Il faut au moins 1 étudiant par AA");
		
		AnneeAcademique dbAnnee = anneeDAO.find(e.getAnneeAcademique());
		if (dbAnnee != null)
			e.setAnneeAcademique(dbAnnee);
		
		if (e.getNombreGroupe() > 1)
			for (int i = 1; i <= e.getNombreGroupe() ; i++) {
				AA newAa = e.clone();
				newAa.setCode(e.getCode()+"-"+(char)(i + 96));
				em.merge(newAa);
			}
		else
			em.merge(e);
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
