package be.helha.aemt.groupea5.entities;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Fraction.class)
public class FractionConverter implements Converter<Fraction>{

	@Override
	public Fraction getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		for (Fraction option : Fraction.values()) {
            if (option.getValeur().equals(value)) {
                return option;
            }
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Fraction value) {
		// TODO Auto-generated method stub
		if (value instanceof Fraction) {
            return value.getValeur();
        } else {
            return null;
        }
	}

}
