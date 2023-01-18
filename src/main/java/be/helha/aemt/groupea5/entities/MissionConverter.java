package be.helha.aemt.groupea5.entities;


import be.helha.aemt.groupea5.dao.MissionDAO;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter(value = "converterMission")
public class MissionConverter implements Converter<Mission>{
	
	@EJB
	private MissionDAO dao;
	

	public MissionConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	  public Mission getAsObject(FacesContext fc, UIComponent comp, String value) {
		System.out.println("dao : " + dao);
		Mission m = new Mission();
		System.out.println("value converter : " + value);
		m.setId(Integer.parseInt(value));
		System.out.println("mission ID : " + m.getId());
		
	     Mission dbM = dao.findById(m);
	      return dbM;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, Mission value) {
	      return ((Mission) value).getId().toString();
	  }

    

}
