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
	
	public UE find(UE ue) {
		return daoUE.find(ue);
	}
	
	public UE add(UE ue) {
		return daoUE.add(ue);
	}
	
	public UE delete(UE ue) {
		return daoUE.delete(ue);
	}
	
	public UE updtae(UE ue) {
		return daoUE.update(ue);
	}

}
