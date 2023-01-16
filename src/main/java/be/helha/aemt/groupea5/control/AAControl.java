package be.helha.aemt.groupea5.control;

import java.io.Serializable;
import java.util.List;

import org.jboss.weld.context.ejb.Ejb;

import be.helha.aemt.groupea5.ejb.AAEJB;
import be.helha.aemt.groupea5.entities.AA;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AAControl implements Serializable {
	@Ejb
	private AAEJB beanGestion;
	
	public AAControl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<AA> doFindAll()
	{
		return beanGestion.findAll();
	}
			
	public void doAddAa() {
		beanGestion.add(new AA());
	}

}
