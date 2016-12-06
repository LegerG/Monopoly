package Modele;

import java.util.*;

public class ProprieteAConstruire extends Propriete {

	private Groupe groupe;
        

	public int calculLoyer() {
		// TODO - implement ProprieteAConstruire.calculLoyer
		throw new UnsupportedOperationException();
	}

	public Groupe getGroupe() {
		// TODO - implement ProprieteAConstruire.getGroupe
		throw new UnsupportedOperationException();
	}

	public int getLoyer() {
		// TODO - implement ProprieteAConstruire.getLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loyer
	 */
	public int calculLoyerDouble(int loyer) {
		// TODO - implement ProprieteAConstruire.calculLoyerDouble
		throw new UnsupportedOperationException();
	}

        public void payerLoyer(Joueur jAch, Joueur JRec) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setGroupe(Groupe groupe) {
            this.groupe = groupe;
        }
        
        public CouleurPropriete getCouleur() {
            return groupe.getCouleur();
        }
}