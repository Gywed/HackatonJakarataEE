package be.helha.aemt.groupea5.converters;

import java.util.List;

import be.helha.aemt.groupea5.ejb.DepartementEJB;
import be.helha.aemt.groupea5.entities.Departement;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "departementConverter")
public class DepartementConverter implements Converter<Departement>
{
	@EJB
    private DepartementEJB departementEJB;
	
	
	@Override
	public Departement getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if (value == null || value.isEmpty()) 
		{
		    return null;
		}
		
		System.out.println("le nom du dep :"+value);
	
	
		Departement dep = departementEJB.find(new Departement(value,null,null));
		
		System.out.println("Le dep de d: "+dep);
		
		return dep;
	}

  

	@Override
	public String getAsString(FacesContext context, UIComponent component, Departement value) 
	{
		 if (value == null) 
		 {
	            return "";
	     }
		 
	     return ((Departement) value).getNom();
	}
}
