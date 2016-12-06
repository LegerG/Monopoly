package Ui;

import Controleur.Controleur;
import Modele.Joueur;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class IHM extends Observable{
    
    public IHM() {
        //Constructeur
        
    }

    

    private void notifierObservateurs() {
            // TODO - implement IHM.notifierObservateurs
            throw new UnsupportedOperationException();
    }
    
    public ArrayList<String> getJoueurs() {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomJoueurs = new ArrayList<>();
        
        int nbJoueur = 0;
        
        System.out.println("Combien êtes-vous pour jouer ? (min : 2 / max : 6)");
        nbJoueur = sc.nextInt(); 
        
        
        while (nbJoueur < 2 || nbJoueur > 6){
            
            System.out.println("Combien êtes-vous pour jouer ? (min : 2 / max : 6)");
            nbJoueur = sc.nextInt(); 
        }
        
        
        int i = 0;
        while(i < nbJoueur) {
            System.out.println("Quel est votre nom ? ");
            String nomJoueur = sc.nextLine();
            nomJoueurs.add(nomJoueur);
            i++;
            
        }
        System.out.println("ddd");
        return nomJoueurs;
    }

}