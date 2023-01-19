package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.MissionDAO;
import be.helha.aemt.groupea5.entities.Mission;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class MissionEJB {

	@EJB
	private MissionDAO daoMission;
	
	public List<Mission> fetchAll(){
		return daoMission.findAll();
	}
	
	public Mission find(Mission m) {
		return daoMission.find(m);
	}
	
	public Mission findById(Mission m) {
		return daoMission.findById(m);
	}
	
	public Mission add(Mission m) {
		return daoMission.add(m);
	}
	
	public Mission delete(Mission m) {
		return daoMission.delete(m);
	}
	
	public Mission update(Mission m) {
		return daoMission.update(m);
	}
}
