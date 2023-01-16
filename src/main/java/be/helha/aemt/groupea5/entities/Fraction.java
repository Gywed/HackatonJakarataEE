package be.helha.aemt.groupea5.entities;

public enum Fraction {
	QUATRECENTQUATREVINGT(480),
	SEPTCENTCINQUANTE(750);

	private int valeur;
	
	Fraction(int valeur) {
		// TODO Auto-generated constructor stub
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return valeur;
	}
}
