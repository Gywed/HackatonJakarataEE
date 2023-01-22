package be.helha.aemt.groupea5.dao;

import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Attribution;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.UE;
import be.helha.aemt.groupea5.exception.AlreadyExistsException;
import be.helha.aemt.groupea5.exception.WrongMailException;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class EnseignantDAO {
	
	@PersistenceContext(unitName = "groupeA5-JTA")
	private EntityManager em;
	
	@EJB
	private AnneeAcademiqueDAO anneeDAO;

	public EnseignantDAO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public List<Enseignant> findAll(){
		String strUA="Select e from Enseignant e ";
		TypedQuery<Enseignant> queryA = em.createQuery(strUA, Enseignant.class);
		return queryA.getResultList();
	}
	
	public Enseignant find(Enseignant e) {
		TypedQuery<Enseignant> query = em.createQuery("Select e from Enseignant e where e.mail = ?1", Enseignant.class);
		query.setParameter(1, e.getMail());
		List<Enseignant> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}
	
	public Enseignant findById(Enseignant e) {
		TypedQuery<Enseignant> query = em.createQuery("Select e from Enseignant e where e.id = ?1", Enseignant.class);
		query.setParameter(1, e.getId());
		List<Enseignant> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<AA> findLessonsGrid(AnneeAcademique ac, Enseignant e){
		if(ac==null)
			ac = anneeDAO.findCurrentAndNextAcademicYear().get(0);
		if(e==null) return null;
		TypedQuery<AA> query = em.createQuery("Select aa from AA aa where aa.anneeAcademique.id = ?1 and aa in (Select aa from Enseignant e join e.attribution attr join attr.aas aa where e.id = ?2)", AA.class);
		query.setParameter(1, ac.getId());
		query.setParameter(2, e.getId());
		List<AA> result = query.getResultList();
		return result;
	}
	
	public Enseignant add(Enseignant e) throws AlreadyExistsException, WrongMailException {
		String pattern = "^\\S+@helha\\.be$";
		
		if (e==null) {
			return null;
		}
		
		if(!e.getMail().matches(pattern))
			throw new WrongMailException("L'adresse e-mail doit respecter le format : ******@helha.be");
		
		
		if (find(e) != null) {
			 throw new AlreadyExistsException("Cet e-mail est déjà utilisé");
		}
		return em.merge(e);

		
	}
	
	public Enseignant delete(Enseignant e) {
		if (e==null) {
			return null;
		}
		
		em.remove(find(e));
		
		return e;
	}
	
	public Enseignant update(Enseignant e) throws WrongMailException, AlreadyExistsException {
		String pattern = "^\\S+@helha\\.be$";
		if (e==null) return null;
		
		if(findById(e)==null) return null;
		
		if(!e.getMail().matches(pattern))
			throw new WrongMailException("L'adresse e-mail doit respecter le format : ******@helha.be");
		
		if (find(e) != null) {
			 throw new AlreadyExistsException("Cet e-mail est déjà utilisé");
		}
		
		return em.merge(e);
	
	}
	
	public void copyAttributionsToNextYear(Enseignant e) {
		AnneeAcademique currentYear = anneeDAO.findCurrentAndNextAcademicYear().get(0);
		AnneeAcademique nextYear = anneeDAO.findCurrentAndNextAcademicYear().get(1);
		Enseignant eDB = find(e);
		Attribution currentYearAttribution = (Attribution) eDB.getAttribution().stream().filter( attr -> attr.getAnneeAcademique().getAnneeAcademique().equals(currentYear.getAnneeAcademique()));
		Attribution newAttr = new Attribution(nextYear, new ArrayList<AA>(), new ArrayList<Mission>());
		for (AA aa : currentYearAttribution.getAas()) {
			UE ue = aa.getUe();
			UE newUE = new UE(nextYear, ue.getDepartement(), ue.getSection(), ue.getBloc(), ue.getCode(), ue.getIntitule(), ue.getCredit(), new ArrayList<AA>());
			AA newAA = new AA(nextYear, newUE, aa.getCode(), aa.getIntitule(), aa.getCredit(), aa.getHeure(), aa.getHeureQ1(), aa.getHeureQ2(), aa.getNombreGroupe(), aa.getNombreEtudiant(), aa.getFraction());
			newAttr.addAA(newAA);
		}
		for (Mission m : currentYearAttribution.getMissions()) {
			Mission newM = new Mission(nextYear, m.getIntitule(), m.getHeures());
			newAttr.addMission(newM);
		}
		e.addAttribution(newAttr);
		em.merge(e);
	}

}
