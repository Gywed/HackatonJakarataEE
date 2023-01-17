package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.UEDAO;
import be.helha.aemt.groupea5.entities.UE;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class UEEJB {
	
	@EJB
	private UEDAO daoUE;
	
	public List<UE> findAll(){
		return daoUE.findAll();
	}

}
