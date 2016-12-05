package Modele;

public abstract class Propriete extends Carreau {

	private Joueur proprietaire;
	private int prix;
	private int loyerBase;

        public Propriete() {
            this.proprietaire = null;
            this.prix = -1;
            this.loyerBase = -1;
        }

        
        
        public abstract void payerLoyer(Joueur jAch, Joueur JRec);
        
        public abstract int calculLoyer();

        
       

	public void acheterPropriete(Joueur jCourant) {
		
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setProprietaire(Joueur jCourant) {
		this.proprietaire = jCourant;
	}

        public void setPrix(int prix) {
            this.prix = prix;
        }

        public int getLoyerBase() {
            return loyerBase;
        }

        public void setLoyerBase(int loyerBase) {
            this.loyerBase = loyerBase;
        }
        
        
        

}