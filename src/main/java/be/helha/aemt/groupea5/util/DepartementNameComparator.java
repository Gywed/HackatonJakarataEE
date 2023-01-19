package be.helha.aemt.groupea5.util;

import java.util.Comparator;

import be.helha.aemt.groupea5.entities.Departement;

public class DepartementNameComparator implements Comparator<Departement>
{
	  @Override
	    public int compare(Departement d1, Departement d2) {
	       return d1.getNom().compareTo(d2.getNom());
	   }
}
