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
		AnneeAcademique annee = new AnneeAcademique(splittedString[2]);
		annee.setId(Integer.parseInt(splittedString[1]));
		Mission m = new Mission(annee, splittedString[3], Integer.parseInt(splittedString[4]));
		m.setId(Integer.parseInt(splittedString[0]));
        return m;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, Mission value) {
	      return value.getId() +"+"+ value.getAnneeAcademique().getId() +"+"+ value.getAnneeAcademique().getAnneeAcademique() +"+"+ value.getIntitule() +"+"+ value.getHeures(); 
	      
	  }

    

}
