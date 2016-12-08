
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

    
    public void payerLoyer(int loyer) {
            this.subCash(loyer);
    }

    
    public void recevoirLoyer(int loyer) {
        this.setCash(this.getCash()+loyer);
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

    public void setPositionCourante(Carreau ca) {
            this.positionCourante = ca;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }


    public int getNbGare() {
        return gares.size();

    }

    
    public void subCash(int prix) {
        this.setCash(this.getCash()-prix);
    }


    
    public void addPropriete(Carreau positionCourante) {           
            if (positionCourante instanceof ProprieteAConstruire){
                this.proprietesAConstruires.add((ProprieteAConstruire)positionCourante);
            } else if(positionCourante instanceof Compagnie){
                this.compagnies.add((Compagnie)positionCourante);
            } else if(positionCourante instanceof Gare){ 
                this.gares.add((Gare)positionCourante);
                
            }

           
    }
    



    public int getNbCompagnie() {
           return compagnies.size();
    }

    public ArrayList<Gare> getGares() {
        return gares;
    }

    public ArrayList<Compagnie> getCompagnies() {
        return compagnies;
    }

    public ArrayList<ProprieteAConstruire> getProprietesAConstruires() {
        return proprietesAConstruires;
    }
    
    


    
    
}
