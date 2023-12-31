package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.EnseignantDAO;
import be.helha.aemt.groupea5.dao.UtilisateurDAO;
import be.helha.aemt.groupea5.entities.Enseignant;
import be.helha.aemt.groupea5.entities.Utilisateur;
import be.helha.aemt.groupea5.exception.PasswordHashingException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

@Stateful
public class UtilisateurEJB {

	@EJB
	private UtilisateurDAO daoUtilisateur;
	
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return daoUtilisateur.findAll();
	}

	public Utilisateur add(Utilisateur e) throws PasswordHashingException {
		// TODO Auto-generated method stub
		return daoUtilisateur.add(e);
	}

	public Utilisateur delete(Utilisateur e) {
		// TODO Auto-generated method stub
		return daoUtilisateur.delete(e);
	}

	public Utilisateur find(Utilisateur e) {
		// TODO Auto-generated method stub
		return daoUtilisateur.find(e);
	}

	public Utilisateur update(Utilisateur e, boolean changed) throws PasswordHashingException {
		// TODO Auto-generated method stub
		return daoUtilisateur.update(e, changed);
	}

}
