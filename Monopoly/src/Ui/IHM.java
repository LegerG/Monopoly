package Ui;

import Controleur.Controleur;
import Modele.Joueur;
import static Ui.Utilitaire.lancerDés;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import javax.swing.event.ChangeEvent;

public class IHM extends Observable{
    
    public IHM() {
        //Constructeur
        
        
    }

    public void jouerTour(Joueur jCourant) {
        System.out.println(jCourant.getNomJoueur());
        setChanged();
        notifyObservers(Commande.LANCER_DES);
        clearChanged();
                
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
        
        
        
        for(int i = 0; i < nbJoueur; i++) {
            System.out.println("Quel est votre nom ? ");
            String nomJoueur = sc.next();
            nomJoueurs.add(nomJoueur);
            
            
        }
        return nomJoueurs;
    }
    
    public void acheter() {
        System.out.println("Il n'y a pas de propriétaire. \nVoulez-vous acheter cette propriété ?");
        Scanner sc = new Scanner(System.in);
        
        String reponse = sc.nextLine();
    }

    

}