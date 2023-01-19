package be.helha.aemt.groupea5.entities;


import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterAA")
public class AAConverter implements Converter<AA>{
	

	@Override
	  public AA getAsObject(FacesContext fc, UIComponent comp, String value) {
		String[] splittedString = value.split("\\+");
		AA a = new AA(null, null, null, splittedString[1], null , null, null, null, null, null, null, null);
		a.setId(Integer.parseInt(splittedString[0]));
		return a;
	  }

	  @Override
	  public String getAsString(FacesContext fc, UIComponent comp, AA value) {
	      return value.getId() +"+"+ value.getCode();
	      
	  }

    

}
