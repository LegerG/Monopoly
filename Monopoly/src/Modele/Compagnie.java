package Modele;

import Modele.Joueur;

public class Compagnie extends Propriete {

	public void payerLoyer(Joueur aJAch, Joueur aJRec) {
		throw new UnsupportedOperationException();
	}

        @Override
	protected int calculLoyer() {
		throw new UnsupportedOperationException();
	}

    public Joueur getProprietaire() {
        return _proprietaire;
    }

    public void setProprietaire(Joueur _proprietaire) {
        this._proprietaire = _proprietaire;
    }
        
        
}