package be.helha.aemt.groupea.services;

import be.helha.aemt.groupea5.entities.Departement;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("departementValidator")
public class DepartementValidator implements Validator<Departement>
{
	@Override
	public void validate(FacesContext context, UIComponent component, Departement value) throws ValidatorException 
	{
		if (value == null) 
        {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sélectionnez un département valide", "Sélectionnez un département valide"));
        }
	}
}
