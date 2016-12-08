package Modele;

public class Gare extends Propriete {

     private int loyerBase = 25;
     
    public Gare() {
      
    }

    

    public int getLoyerBase() {
            return this.loyerBase;
    }
    
     public void setLoyerBase(int loyerBase) {
        this.loyerBase = loyerBase;
    }

    @Override
    public int calculLoyer(int[] valDes) {
        int nbGare = this.getProprietaire().getNbGare();
        int loyerBase=this.getLoyerBase();
        
        return nbGare * loyerBase;
            
    }

}
