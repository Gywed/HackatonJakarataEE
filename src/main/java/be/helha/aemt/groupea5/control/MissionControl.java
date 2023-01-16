package be.helha.aemt.groupea5.control;

import java.util.List;

import be.helha.aemt.groupea5.ejb.MissionEJB;
import jakarta.ejb.EJB;

public class MissionControl {

	@EJB
	private MissionEJB bean;
	
	public List doFindAll() {
		return bean.fetchAll();
	}
}
