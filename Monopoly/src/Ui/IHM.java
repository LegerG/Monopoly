package Ui;

import Controleur.Controleur;
import Modele.Joueur;
import Modele.Propriete;
import static Ui.Utilitaire.lancerDés;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class IHM extends Observable{
    
    public IHM() {
        //Constructeur
        
        
    }

    public void jouerTour(Joueur jCourant) {
        System.out.println("");
        System.out.println("\033[00mTour de " + "\033[34m" + jCourant.getNomJoueur());
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
        System.out.println("\t#Lancement du jeu");
        System.out.println("\t#Création du plateau de jeu");
        System.out.println("\t#Démarrage...\n");
        
        
        System.out.println("\033[31m************************************************************************");
        System.out.println("\033[31m*                               Monopoly                               *");
        System.out.println("\033[31m************************************************************************");
        
        
        System.out.println("\033[00m\tCombien êtes-vous pour jouer ? (min : 2 / max : 6)");
        System.out.print("\t");
        nbJoueur = sc.nextInt(); 
        
        
        while (nbJoueur < 2 || nbJoueur > 6){
            
            System.out.println("\tCombien êtes-vous pour jouer ? (min : 2 / max : 6)");
            System.out.print("\t");
            nbJoueur = sc.nextInt(); 
        }
        
        
        
        for(int i = 0; i < nbJoueur; i++) {
            System.out.println("\tQuel est votre nom ? ");
            System.out.print("\t");
            String nomJoueur = sc.next();
            nomJoueurs.add(nomJoueur);
            
            
        }
        return nomJoueurs;
    }
    
    public void acheter(Propriete p) {
        System.out.println("\tIl n'y a pas de propriétaire.");
        System.out.print("\t");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\tVoulez-vous acheter la propriété " + p.getNomCarreau() + ", coutant " + p.getPrix() + "€ ? (oui/non) ");
        System.out.print("\t");
        String reponse = sc.nextLine();
        
        String oui = "oui";
        String non = "non";
        
        if(oui.equals(reponse)){
            setChanged();
            notifyObservers(Commande.ACHETER);
            clearChanged();
        } 
        else if (non.equals(reponse)){
            setChanged(); 
            notifyObservers(Commande.NON);
            clearChanged();
            System.out.println("\tVous n'avez pas acheté la propriété.");

        }
    }
    
    public void joueurSupprime(Joueur j){
        System.out.println("\t\033[31mLe joueur : " + j.getNomJoueur() + " est en faillite, il est donc retiré du jeu.\033[00m");
    }
    
    public void vainqueur(Joueur j) {
        System.out.println("=====================================================================================");
        System.out.println("\tLe joueur : " + j.getNomJoueur() + " a gangé cette partie de Monopoly." );
        System.out.println("=====================================================================================");
    }
    
    public void aFaitDouble(){
        System.out.println("\tTu as fais un double.");
    }
    
    public void afficheAchatProprieteAvant(Joueur jCourant, Propriete p){
        System.out.println("\tVOUS VENEZ D'ACHETER LA CASE : "+ p.getNomCarreau());
        System.out.println("\tVous aviez : " + jCourant.getCash() + "€.");
    }
    
    public void afficheAchatProprieteApres(Joueur jCourant, Propriete p){
        System.out.println("\tEt Maintenant vous avez : "+ jCourant.getCash()+ "€.");
    }
    
    public void affichePayerLoyer(Propriete p) {
        System.out.println("\tTU ES TOMBE SUR UNE PROPRIETE !");
        System.out.println("\t" + p.getProprietaire().getCash());

    }
    
    public void afficherAvancer(Joueur jCourant, int[] valDes) {
        System.out.println("\tValeur des dés : " + valDes[0] + "   " + valDes[1]);
        System.out.println("\t" + jCourant.getNomJoueur() + " est sur la case \033[32m" + jCourant.getPositionCourante().getNomCarreau() + "\033[00m.");
    }
    
    public void affichePartrimoine(Joueur jCourant){
        System.out.println("\tVotre patrimoine : ");
        System.out.println("\t\t* Nombres de compagnies : " + jCourant.getCompagnies().size() + ".");
        System.out.println("\t\t* Nombres de gares : "  + jCourant.getGares().size() + ".");
        System.out.println("\t\t* Nombres de propriete à construire : " + jCourant.getProprietesAConstruires().size() + ".");
    }
    
    public void afficherSweetHome() {
        System.out.println("\tVous êtes chez vous ! :)");
        new Scanner(System.in).nextLine();
    }
 }
    
