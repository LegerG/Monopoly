package Modele;

public class Compagnie extends Propriete {

    @Override
    public int calculLoyer(int[] valDes) {
        
        int nbCompagnie = this.getProprietaire().getNbCompagnie();
        int loyerFinal = 0;
        
        if (nbCompagnie==1){
            loyerFinal = 4*(valDes[0]+valDes[1]);
        } 
        else if (nbCompagnie==2) {
            loyerFinal= 10*(valDes[0]+valDes[1]);
        }
        return loyerFinal;
          
    }

   

   

}