package be.helha.aemt.groupea5.entities;

public enum Fraction {
	_480("480"),
	_750("750");

	private String valeur;
	
	Fraction(String valeur) {
		// TODO Auto-generated constructor stub
		this.valeur = valeur;
	}
	
	public String getValeur() {
		return valeur;
	}
}
