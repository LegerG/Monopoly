package Modele;

public abstract class Propriete extends Carreau {

	private Joueur proprietaire;
	private int prix;
	private int loyerBase;
	
	

	/**
	 * 
	 * @param jAch
	 * @param JRec
	 */
	public abstract void payerLoyer(Joueur jAch, Joueur JRec);

	/**
	 * 
	 * @param jCourant
	 */
	public void acheterPropriete(Joueur jCourant) {
		// TODO - implement Propriete.acheterPropriete
		throw new UnsupportedOperationException();
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	public abstract int calculLoyer();

	/**
	 * 
	 * @param j
	 */
	public void setPropriétaire(Joueur j) {
		// TODO - implement Propriete.setPropriétaire
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		return this.prix;
	}

	/**
	 * 
	 * @param jCourant
	 */
	public void setProprietaire(Joueur jCourant) {
		this.proprietaire = jCourant;
	}

}