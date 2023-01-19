package be.helha.aemt.groupea5.util;

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

    private List<Section> sections;

    private List<Section> filteredSections;
    
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


    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) 
    {
        this.globalFilterOnly = globalFilterOnly;
    }


	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Section> getFilterBy() {
		return filterBy;
	}

	

	public List<Section> getFilteredSections() 
	{
		return filteredSections;
	}

	public void setFilteredSections(List<Section> filteredSections) 
	{
		this.filteredSections = filteredSections;
	}

	public void setFilterBy(List<Section> filterBy) 
	{
		this.filterBy = filterBy;
	}
    
    
}
