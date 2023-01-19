package be.helha.aemt.groupea.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;
import org.primefaces.util.LangUtils;

import be.helha.aemt.groupea5.entities.Section;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("dtFilterView")
@ViewScoped
public class FilterView implements Serializable 
{

    

    private List<Section> departements;

    private List<Section> filteredDepartements;
    
    private List<Section> filterBy;
    

    private boolean globalFilterOnly;

    @PostConstruct
    public void init() 
    {
        globalFilterOnly = false;
        filterBy = new ArrayList<>();
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) 
    {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        
        if (LangUtils.isBlank(filterText)) 
        {
            return true;
        }
        
        int filterInt = getInteger(filterText);

        Section section = (Section) value;
        
        return section.getNom().toLowerCase().contains(filterText) 
        		|| section.getDepartement().getNom().toLowerCase().contains(filterText);
        
    }

    public void toggleGlobalFilter() 
    {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }

    private int getInteger(String string) 
    {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException ex) 
        {
            return 0;
        }
    }


    /*public List<FilterMeta> getFilterBy() 
    {
        return filterBy;
    }*/

    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) 
    {
        this.globalFilterOnly = globalFilterOnly;
    }

	public List<Section> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Section> departements) 
	{
		this.departements = departements;
	}

	public List<Section> getFilteredDepartements() 
	{
		return filteredDepartements;
	}

	public void setFilteredDepartements(List<Section> filteredDepartements) 
	{
		this.filteredDepartements = filteredDepartements;
	}

	public void setFilterBy(List<Section> filterBy) 
	{
		this.filterBy = filterBy;
	}
    
    
}
