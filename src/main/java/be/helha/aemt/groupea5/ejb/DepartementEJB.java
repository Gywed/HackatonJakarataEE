package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.DepartementDAO;
import be.helha.aemt.groupea5.entities.Departement;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class DepartementEJB 
{
	@EJB
	private DepartementDAO dao;
	
	public Departement find(Departement e) 
	{
		return dao.find(e);
	}

	public List<Departement> findAll() 
	{
		return dao.findAll();
	}

	public Departement add(Departement e) 
	{
		return dao.add(e);
	}

	public Departement delete(Departement e) 
	{
		return dao.delete(e);
	}

	public Departement update(Departement e) 
	{
		return dao.update(e);
	}
}
