package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.SectionDAO;
import be.helha.aemt.groupea5.entities.Section;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class SectionEJB 
{
	@EJB
	private SectionDAO dao;
	
	public Section find(Section e) 
	{
		return dao.find(e);
	}

	public List<Section> findAll() 
	{
		return dao.findAll();
	}
	
	public List<Section> findAllSorted() 
	{
		return dao.findAllSorted();
	}

	public Section add(Section e) 
	{
		return dao.add(e);
	}

	public Section delete(Section e) 
	{
		return dao.delete(e);
	}

	public Section update(Section e) 
	{
		return dao.update(e);
	}
}
