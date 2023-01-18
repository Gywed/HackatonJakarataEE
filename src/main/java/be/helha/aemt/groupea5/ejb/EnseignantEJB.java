package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.EnseignantDAO;
import be.helha.aemt.groupea5.entities.Enseignant;
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

	public Enseignant add(Enseignant e) {
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

	public Enseignant update(Enseignant e) {
		// TODO Auto-generated method stub
		return daoEnseignant.update(e);
	}

}
