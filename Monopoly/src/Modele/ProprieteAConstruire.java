package Modele;



public class ProprieteAConstruire extends Propriete {

    private Groupe groupe;
    private int loyerBase;

    @Override
    public int calculLoyer(int[] valDes) {
        int nb = this.groupe.getNbProprieteGroupe();
        int nbProprieteGroupe = this.getProprietaire().getNbProprietesGroupe(this.groupe);
            int loyer = this.getLoyerBase();
            if(nb==nbProprieteGroupe){
                loyer = loyer * 2 ;
            }
            return loyer;
    }

    public Groupe getGroupe() {
            return this.groupe;
    }

    public int getLoyer() {
            // TODO - implement ProprieteAConstruire.getLoyer
            throw new UnsupportedOperationException();
    }
       
    public int getLoyerBase() {
        return loyerBase;
    }
    
    public void setLoyerBase(int loyerBase) {
        this.loyerBase = loyerBase;
    }
      
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
        
    public CouleurPropriete getCouleur() {
        return groupe.getCouleur();
    }

   

}