package be.helha.aemt.groupea5.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public List<AnneeAcademique> findCurrentAndNextAcademicYear(){
		List<AnneeAcademique> anneeAcademiques = new ArrayList<>();
		List<AnneeAcademique> anneeAcademiquesDB = new ArrayList<>();
		
		SimpleDateFormat y = new SimpleDateFormat("yyyy");
		SimpleDateFormat m = new SimpleDateFormat("MM");
		
		Date date = new Date();
		
		int annee = Integer.parseInt(y.format(date));
		int mois = Integer.parseInt(m.format(date));
		if (mois < 03) {
			anneeAcademiques.add(new AnneeAcademique( annee-1 + " - " + annee));
			int anneePro = annee + 1;
			anneeAcademiques.add(new AnneeAcademique( annee + " - " + anneePro));
		} else {
			int anneePro = annee + 1;
			anneeAcademiques.add(new AnneeAcademique( annee + " - " + anneePro));
			
			int anneeEncorePro = anneePro + 1;
			anneeAcademiques.add(new AnneeAcademique( anneePro + " - " + anneeEncorePro));
		}
		
		for (AnneeAcademique anneeAcademique : anneeAcademiques) {
			if (find(anneeAcademique) == null) {
				add(anneeAcademique);
			}
			anneeAcademiquesDB.add(find(anneeAcademique));
		}
		return anneeAcademiquesDB;
	}
	
	public AnneeAcademique add(AnneeAcademique a) {
		if (a==null) {
			return null;
		}
		
		if (find(a) != null) {
			return null;
		}
		return em.merge(a);

		
	}
	
	public AnneeAcademique delete(AnneeAcademique a) {
		if (a==null) {
			return null;
		}
		
		em.remove(find(a));
		
		return a;
	}
	
	public AnneeAcademique update(AnneeAcademique a) {
		if (a==null) return null;
		
		AnneeAcademique dbE = find(a);
		if(dbE==null) return null;
		a.setId(dbE.getId());
		
		return em.merge(a);
	
	}

}
