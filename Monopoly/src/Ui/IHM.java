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
        System.out.println("");
        System.out.println("Tour de " + jCourant.getNomJoueur());
        System.out.println("Tu as : " + jCourant.getCash() + "€");
        System.out.println("Appuyez sur entrée pour tirer les dés");
        setChanged();
        notifyObservers(Commande.LANCER_DES);
        clearChanged();
                
    }
    
    
    public ArrayList<String> getJoueurs() {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomJoueurs = new ArrayList<>();
        
        int nbJoueur = 0;
        
        System.out.println("*********************************************************************");
        
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
        System.out.println("Il n'y a pas de propriétaire.");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Voulez-vous acheter la propriété " + p.getNomCarreau() + ", coutant " + p.getPrix() + "€ ? (oui/non) ");
        String reponse = sc.nextLine();
        
        String oui = "oui";
        String non = "non";
        
//        while (!oui.equals(reponse) ^ !non.equals(reponse)){
//            System.out.println("Voulez-vous acheter la propriété " + p.getNomCarreau() + ", coutant " + p.getPrix() + "€ ? (oui/non) ");
//            reponse = sc.nextLine();   
//        }
//        
//         if(oui.equals(reponse)){
//                setChanged();
//                notifyObservers(Commande.ACHETER);
//                clearChanged();
//            } 
//            else if (non.equals(reponse)){
//                setChanged(); 
//                notifyObservers(Commande.NON);
//                clearChanged();
//            }
//            else {          
//                reponse = sc.nextLine(); 
//            }
        
       
        
        System.out.println(reponse);
        if(oui.equals(reponse)){
            setChanged();
            notifyObservers(Commande.ACHETER);
            clearChanged();
        } 
        else if (non.equals(reponse)){
            setChanged(); 
            notifyObservers(Commande.NON);
            clearChanged();

        }
    }
    
    public void joueurSupprime(Joueur j){
        System.out.println("Le joueur : " + j.getNomJoueur() + " est en faillite, il est donc retiré du jeu.");
    }
    
    public void vainqueur(Joueur j) {
        System.out.println("Le joueur : " + j.getNomJoueur() + " a gangé cette partie de Monopoly." );
    }
    
    public void aFaitDouble(){
        System.out.println("Tu as fais un double.");
    }
    
    public void afficheAchatProprieteAvant(Joueur jCourant, Propriete p){
        System.out.println("VOUS VENEZ D'ACHETER LA CASE : "+ p.getNomCarreau());
        System.out.println("Vous aviez : " + jCourant.getCash() + "€.");
    }
    
    public void afficheAchatProprieteApres(Joueur jCourant, Propriete p){
        System.out.println("Et Maintenant vous avez : "+ jCourant.getCash()+ "€.");
    }
    
    public void affichePayerLoyer(Propriete p) {
        System.out.println("TU ES TOMBE SUR UNE PROPRIETE !");
        System.out.println(p.getProprietaire().getCash());

    }
    
    public void afficherAvancer(Joueur jCourant, int[] valDes) {
        System.out.println("Valeur des dés : " + valDes[0] + "   " + valDes[1]);
        System.out.println(jCourant.getNomJoueur() + " est a la position " + jCourant.getPositionCourante().getNumero() + ".");
    }
    
    public void affichePartrimoine(Joueur jCourant){
        System.out.println("Votre patrimoine : ");
        System.out.println("\tNombres de compagnies : " + jCourant.getCompagnies().size() + ".");
        System.out.println("\tNombres de gares : "  + jCourant.getGares().size() + ".");
        System.out.println("\tNombres de propriete à construire : " + jCourant.getProprietesAConstruires().size() + ".");
    }
    
    public void afficherSweetHome() {
        System.out.println("Vous êtes chez vous ! :)");
        new Scanner(System.in).nextLine();
    }
 }
    
