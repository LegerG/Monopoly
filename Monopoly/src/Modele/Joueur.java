
package Modele;


import java.util.ArrayList;


public class Joueur {

    private ArrayList<Compagnie> compagnies = new ArrayList<>();
    private ArrayList<ProprieteAConstruire> proprietesAConstruires = new ArrayList<>();
    private ArrayList<Gare> gares = new ArrayList<>();
    private Carreau positionCourante;
    private String nomJoueur;
    private int cash;

    public Joueur(String nomJoueur) {
        this.positionCourante = null;
        this.nomJoueur = nomJoueur;
        this.cash = 1500;
    }

    
    public int getNbProprietesGroupe(Groupe g){
        int nbProprietesGroupe = 0;
        for (int i=0;i<proprietesAConstruires.size();i++ ){
            if(proprietesAConstruires.get(i).getGroupe()==g){
                nbProprietesGroupe=nbProprietesGroupe+1;
            }
        }
       return nbProprietesGroupe; 
    }

 
    
    
    
    
    /**
     * 
     * @param l
     */
    public void payerLoyer(int l) {
            // TODO - implement Joueur.payerLoyer
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param l
     */
    public void recevoirLoyer(int l) {
            // TODO - implement Joueur.recevoirLoyer
            throw new UnsupportedOperationException();
    }

    public int getCash() {
            return this.cash;
    }
    
      public void setCash(int cash) {
        this.cash = cash;
    }

    public Carreau getPositionCourante() {
            return this.positionCourante;
    }

    /**
     * 
     * @param ca
     */
    public void setPositionCourante(Carreau ca) {
            this.positionCourante = ca;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }


    

    /**
     * 
     * @param propri
     */
    public void addPropriete(Propriete propri) {
            // TODO - implement Joueur.addPropriete
            throw new UnsupportedOperationException();
    }

    public int getNbGare() {
            return gares.size();
    }

    
    public void subCash(int prix) {
        this.setCash(this.getCash()-prix);
    }

    /**
     * 
     * @param positionCourante
     */
    public void addPropriete(Carreau positionCourante) {   
        // A FINIR
//        if (positionCourante instanceof ProprieteAConstruire){
//            this.proprietesAConstruires.add((ProprieteAConstruire)positionCourante);
//        } 
//        else if(positionCourante instanceof Compagnie){
//            this.compagnies.add((Compagnie)positionCourante);
//        } 
//        else if(positionCourante instanceof Gare){ 
//            this.gares.add((Gare)positionCourante);
//        }
        

    }

    public int getNbCompagnie() {
           return compagnies.size();
    }


    
    
}