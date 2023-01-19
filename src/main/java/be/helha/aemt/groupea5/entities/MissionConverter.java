package be.helha.aemt.groupea5.entities;


import be.helha.aemt.groupea5.dao.MissionDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterMission")
public class MissionConverter implements Converter<Mission>{
	

	@Override
	  public Mission getAsObject(FacesContext fc, UIComponent comp, String value) {
		String[] splittedString = value.split("\\+");
		System.out.println("value : " + value);
		AnneeAcademique annee = new AnneeAcademique(splittedString[2]);
		annee.setId(Integer.parseInt(splittedString[1]));
		Mission m = new Mission(annee, splittedString[3], Integer.parseInt(splittedString[4]));
		m.setId(Integer.parseInt(splittedString[0]));
		System.out.println("mission " + m);
        return m;
//		System.out.println("dao : " + dao);
//		Mission m = new Mission();
//		System.out.println("value converter : " + value);
//		m.setId(Integer.parseInt(value));
//		System.out.println("mission ID : " + m.getId());
//		
//	     Mission dbM = dao.findById(m);
//	      return dbM;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, Mission value) {
	      return value.getId() +"+"+ value.getAnneeAcademique().getId() +"+"+ value.getAnneeAcademique().getAnneeAcademique() +"+"+ value.getIntitule() +"+"+ value.getHeures(); 
	      //return value.getId().toString();
	      
	  }

    

}
