package Modele;

public abstract class Propriete extends Carreau {

    private Joueur proprietaire;
    private int prix;


    public Propriete() {
        super();
        this.proprietaire = null;
        this.prix = -1;
    }

    public abstract int calculLoyer(int[] valDes);

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
       

	

      
        
        
        
        

}
