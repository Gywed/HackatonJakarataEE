package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AnneeAcademique;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class AnneeAcademiqueDAO {
	
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;

	public AnneeAcademiqueDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<AnneeAcademique> findAll(){
		String strUA="Select e from AnneeAcademique e ";
		TypedQuery<AnneeAcademique> queryA = em.createQuery(strUA, AnneeAcademique.class);
		return queryA.getResultList();
	}
	
	public AnneeAcademique find(AnneeAcademique a) {
		TypedQuery<AnneeAcademique> query = em.createQuery("Select a from AnneeAcademique a where a.anneeAcademique = ?1", AnneeAcademique.class);
		query.setParameter(1, a.getAnneeAcademique());
		List<AnneeAcademique> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}

}
