package be.helha.aemt.groupea5.entities;


import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterAnnee")
public class AnneeAcademiqueConverter implements Converter<AnneeAcademique>{
	

	@Override
	  public AnneeAcademique getAsObject(FacesContext fc, UIComponent comp, String value) {
		String[] splittedString = value.split("\\+");
		AnneeAcademique a = new AnneeAcademique(splittedString[1]);
		a.setId(Integer.parseInt(splittedString[0]));
		return a;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, AnneeAcademique value) {
	      return value.getId() +"+"+ value.getAnneeAcademique();
	      
	  }

    

}
