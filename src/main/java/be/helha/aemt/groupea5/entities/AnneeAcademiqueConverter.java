package be.helha.aemt.groupea5.entities;


import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterAnnee")
public class AnneeAcademiqueConverter implements Converter<AnneeAcademique>{
	

	@Override
	  public AnneeAcademique getAsObject(FacesContext fc, UIComponent comp, String value) {
		AnneeAcademique a = new AnneeAcademique(value);
		return a;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, AnneeAcademique value) {
	      return value.getAnneeAcademique();
	      
	  }

    

}
