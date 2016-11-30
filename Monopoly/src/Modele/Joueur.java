import java.util.*;
import DDC.*;

public class Joueur {

	private Collection<Compagnie> compagnies;
	private Collection<ProprieteAConstruire> proprietesAConstruires;
	private Collection<Gare> gares;
	private Carreau positionCourante;
	private String nomJoueur;
	private int cash = 1500;

	/**
	 * 
	 * @param l
	 */
	public void payerLoyer(int l) {
		// TODO - implement Joueur.payerLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 */
	public void recevoirLoyer(int l) {
		// TODO - implement Joueur.recevoirLoyer
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this.cash;
	}

	public Carreau getPositionCourante() {
		return this.positionCourante;
	}

	/**
	 * 
	 * @param ca
	 */
	public void setPositionCourante(Carreau ca) {
		this.positionCourante = ca;
	}

	/**
	 * 
	 * @param propri
	 */
	public void addPropriete(Propriete propri) {
		// TODO - implement Joueur.addPropriete
		throw new UnsupportedOperationException();
	}

	public int getNbGare() {
		// TODO - implement Joueur.getNbGare
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prix
	 */
	public void subCash(int prix) {
		// TODO - implement Joueur.subCash
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param positionCourante
	 */
	public void addPropriete(Carreau positionCourante) {
		// TODO - implement Joueur.addPropriete
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		// TODO - implement Joueur.getPrix
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public int getnbPropGroupe(Groupe g) {
		// TODO - implement Joueur.getnbPropGroupe
		throw new UnsupportedOperationException();
	}

	public int getNbCompagnie() {
		// TODO - implement Joueur.getNbCompagnie
		throw new UnsupportedOperationException();
	}

}