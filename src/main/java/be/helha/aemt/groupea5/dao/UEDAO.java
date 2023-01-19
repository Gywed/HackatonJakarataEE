package be.helha.aemt.groupea5.dao;

import java.util.List;

import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Departement;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Section;
import be.helha.aemt.groupea5.entities.UE;
import jakarta.ejb.EJB;
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
	
	@EJB
	private DepartementDAO depDao;
	
	@EJB
	private SectionDAO secDAO;
	
	@EJB
	private AnneeAcademiqueDAO anneeDAO;
	
	public UEDAO() {
		super();
	}
	
	public List<UE> findAll(){
		String strUA="Select ue from UE ue ";
		TypedQuery<UE> queryA = em.createQuery(strUA, UE.class);
		return queryA.getResultList();
	}
	
	public UE find(UE ue) {
		TypedQuery<UE> query = em.createQuery("Select ue from UE ue where ue.code = ?1", UE.class);
		query.setParameter(1, ue.getCode());
		List<UE> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	} 
	
	public UE add(UE ue) {
		if (ue==null) return null;
		if (find(ue) != null) return null;
		if (ue == find(ue)) return null;
		AnneeAcademique annee = anneeDAO.find(ue.getAnneeAcademique());
		Departement dep = depDao.find(ue.getDepartement());
		Section sec = secDAO.find(ue.getSection());
		
		if(annee!=null)ue.setAnneeAcademique(annee);
		if(dep!=null)ue.setDepartement(dep);
		if(sec!=null)ue.setSection(sec);

		
		
		return em.merge(ue);
	}
	
	public UE delete(UE ue) {
		if (ue==null) {
			return null;
		}
		
		em.remove(find(ue));
		
		return ue;
	}
	
	public UE update(UE ue) {
		if (ue==null) return null;
		
		UE dbE = find(ue);
		if(dbE==null) return null;
		ue.setId(dbE.getId());
		
		return em.merge(ue);
	
	}
	
	

}
