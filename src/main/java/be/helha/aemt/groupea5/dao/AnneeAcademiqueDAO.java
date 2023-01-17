package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Enseignant;
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

}
