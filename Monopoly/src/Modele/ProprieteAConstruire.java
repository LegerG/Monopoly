package Modele;

import Modele.Propriete;

public class ProprieteAConstruire extends Propriete {

    @Override
    public void payerLoyer(Joueur aJAch, Joueur aJRec) {
            throw new UnsupportedOperationException();
    }

    @Override
    protected int calculLoyer() {
            throw new UnsupportedOperationException();
    }

    @Override
    public Joueur getProprietaire() {
        return _proprietaire;
    }

    public void setProprietaire(Joueur _proprietaire) {
        this._proprietaire = _proprietaire;
    }
        
        
}