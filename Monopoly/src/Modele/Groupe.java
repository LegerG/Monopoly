package Modele;

import java.util.ArrayList;

public class Groupe {

    private ArrayList<ProprieteAConstruire> proprietes = new ArrayList<>();
    private CouleurPropriete couleur;

    public Groupe( CouleurPropriete couleur) {
        this.couleur = couleur;
    }
        
        

    public int getNbProprieteGroupe() {
            return this.proprietes.size();
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
        
    public void addPropriete(ProprieteAConstruire p) {
        proprietes.add(p);
    }
    
        

}