package be.helha.aemt.groupea5.ejb;

import java.util.List;

import be.helha.aemt.groupea5.dao.AADAO;
import be.helha.aemt.groupea5.entities.AA;
import be.helha.aemt.groupea5.entities.AnneeAcademique;
import be.helha.aemt.groupea5.exception.WrongArgumentException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AAEJB {

	@EJB
	private AADAO dao;
	
	public AA find(AA e) {
		// TODO Auto-generated method stub
		return dao.find(e);
	}

	public List<AA> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	public List<AA> findNotAttribuedAA(){
		return dao.findNotAttribuedAA();
	}

	public List<AA> findByYear(AnneeAcademique ac){
		return dao.findByYear(ac);
	}

	public void add(AA e) throws WrongArgumentException {
		// TODO Auto-generated method stub
		dao.add(e);
	}

	public AA delete(AA e) {
		// TODO Auto-generated method stub
		return dao.delete(e);
	}

	public AA update(AA e) {
		// TODO Auto-generated method stub
		return dao.update(e);
	}
}
