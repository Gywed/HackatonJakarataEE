package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.EnseignantDAO;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Mission;
import be.helha.aemt.groupea5.entities.UE;
import be.helha.aemt.groupea5.exception.AlreadyExistsException;
import be.helha.aemt.groupea5.exception.WrongMailException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class EnseignantEJB {

	@EJB
	private EnseignantDAO daoEnseignant;
	
	public List<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return daoEnseignant.findAll();
	}
	
	public List<AA> findLessonsGrid(Enseignant e){
		return daoEnseignant.findLessonsGrid(e);
	}
	
	public List<Mission> findMissions(Enseignant e){
		return daoEnseignant.findMissions(e);
	}

	public Enseignant add(Enseignant e) throws AlreadyExistsException, WrongMailException {
		// TODO Auto-generated method stub
		return daoEnseignant.add(e);
	}

	public Enseignant delete(Enseignant e) {
		// TODO Auto-generated method stub
		return daoEnseignant.delete(e);
	}

	public Enseignant find(Enseignant e) {
		// TODO Auto-generated method stub
		return daoEnseignant.find(e);
	}

	public Enseignant update(Enseignant e) throws WrongMailException, AlreadyExistsException {
		// TODO Auto-generated method stub
		return daoEnseignant.update(e);
	}

	public void copyAttributionsToNextYear(Enseignant e) {
		daoEnseignant.copyAttributionsToNextYear(e);
	}
}
