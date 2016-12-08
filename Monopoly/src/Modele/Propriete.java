package Modele;

public abstract class Propriete extends Carreau {

	private Joueur proprietaire;
	private int prix;
	

        public Propriete() {
            this.proprietaire = null;
            this.prix = -1;
        }

        
        
        
        
        public abstract int calculLoyer(int[] valDes);

        public void payerLoyer(Joueur jAch, Joueur JRec){
            // 
        }
       

	public void acheterPropriete(Joueur jCourant) {
		
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}
        
        public void setProprietaire(Joueur jCourant) {
		this.proprietaire = jCourant;
	}

	public int getPrix() {
		return this.prix;
	}
        
        public void setPrix(int prix) {
            this.prix = prix;
        }

	

      
        
        
        
        

}