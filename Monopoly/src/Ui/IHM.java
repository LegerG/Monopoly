package Ui;

import Controleur.Controleur;
import Modele.Joueur;
import Modele.Propriete;
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
    
    public void acheter(Propriete p) {
        System.out.println("Il n'y a pas de propriétaire."); ;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Voulez-vous acheter la propriété " + p.getNomCarreau() + ", coutant " + p.getPrix() + "€ ? (oui/non) ");
        String reponse;
        reponse = ("");
        
        reponse = sc.nextLine(); 
        
        
//        while ((!"oui".equals(reponse)) || (!"non".equals(reponse))) {
//            
//            System.out.println("Voulez-vous acheter cette propriété ? (oui/non) ");
//            reponse = sc.next(); 
//        }

        if(reponse != "oui" || reponse !="non"){
            reponse = "oui";
        }
        
        if(reponse == "oui"){
            setChanged();
            notifyObservers(Commande.ACHETER);
            clearChanged();
        } else{
            setChanged(); 
            notifyObservers(Commande.NON);
            clearChanged();
        }
 

    }
    
    public void joueurSupprime(Joueur j){
        System.out.println("Le joueur : " + j.getNomJoueur() + " est en faillite, il est donc retiré du jeu.");
    }
    
}
    
