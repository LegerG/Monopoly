package Modele;

public abstract class Propriete extends Carreau {
    private int _prix;
    private int _loyerBase;
    public Joueur _proprietaire;

    public abstract void payerLoyer(Joueur aJAch, Joueur aJRec);

    public void acheterPropriete(Joueur aJ) {
            throw new UnsupportedOperationException();
    }

    public Joueur getProprietaire() {
            return this._proprietaire;
    }

    protected abstract int calculLoyer();

    public int getPrix() {
        return _prix;
    }

    public void setPrix(int _prix) {
        this._prix = _prix;
    }

    public int getLoyerBase() {
        return _loyerBase;
    }

    public void setLoyerBase(int _loyerBase) {
        this._loyerBase = _loyerBase;
    }
        
        
}