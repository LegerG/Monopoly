package Controleur;

import Modele.AutreCarreau;
import Modele.Carreau;
import Modele.Compagnie;
import Modele.CouleurPropriete;
import Modele.Gare;
import Modele.Groupe;
import Modele.Joueur;
import Modele.Propriete;
import Modele.ProprieteAConstruire;
import Ui.Commande;
import Ui.IHM;
import Modele.TypeCarreau;
import Ui.Utilitaire;
import static Ui.Utilitaire.lancerDés;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Controleur implements Observer{

    private IHM ihm;
    private ArrayList<Carreau> carreaux = new ArrayList<>();
    private ArrayList<Groupe> groupes = new ArrayList<>();
    private ArrayList<Joueur> joueurs= new ArrayList<>();
    private final Carreau DEPART;
    private Carreau nouveauCarreau;
    private int[] valDes = {0,0};
    private Joueur jCourant;

    public Controleur(IHM ihm) {
        this.ihm = ihm;
        CreerPlateau("src/Data/data.txt");
        DEPART = carreaux.get(0);
        ihm.addObserver(this);
        
        

    }
               
    @Override    
    public void update(Observable o, Object arg) {
        if (arg == Commande.LANCER_DES) {
            
            valDes = lancerDés();
            new Scanner(System.in).nextLine();
            
            ihm.affichePartrimoine(jCourant);
            avancer(jCourant, valDes);
            Carreau caseJoueur = jCourant.getPositionCourante();
            int numcaseJoueur = caseJoueur.getNumero();
            
             if(null != caseJoueur.getTypeCarreau()){
                 if((caseJoueur.getTypeCarreau() == TypeCarreau.PROPRIETE) ||
                    (caseJoueur.getTypeCarreau() == TypeCarreau.GARE) ||
                    (caseJoueur.getTypeCarreau() == TypeCarreau.COMPAGNIE)){
                     Propriete p = (Propriete) jCourant.getPositionCourante();
                    if (p.getProprietaire() == null) {
                        ihm.acheter(p);
                           
                    }
                    else{
                        if (jCourant != p.getProprietaire()) {
                            payerLoyer(p);
                        }
                        else {
                            ihm.afficherSweetHome();
                        }
                        
                    }

                }

            } 

            
            if (aFaitUnDouble()) {
                ihm.aFaitDouble();
                ihm.jouerTour(jCourant); // Le joueur rejoue si il a fait un double
            }
            
        }
        else if (arg == Commande.ACHETER) {
            
            acheterPropriete();

        }
        else if (arg == Commande.ABANDON) {
            
            joueurs.remove(jCourant);

        }
        else if (arg == Commande.NON) {
            
            ihm.afficherRefus();

        }
           
    }
    
    public void initPartie() {
        ArrayList<String> listJoueur = ihm.getJoueurs();
        for (String s : listJoueur) {
            Joueur j = new Joueur(s);
            j.setPositionCourante(DEPART);
            joueurs.add(j);
        }
        jCourant = joueurs.get(0);        
        jouer();
    }
    
    public void jouer() {
        
        while (joueurs.size() != 1) {
            ihm.jouerTour(jCourant);
            if (faillite(jCourant)){
                supprimerJoueur(jCourant);
                ihm.joueurSupprime(jCourant);
            }
            jCourant = jSuivant();
            
        }
        ihm.vainqueur(joueurs.get(0));
    }

    public void avancer(Joueur jCourant, int[] valDes) {
        
        
        Carreau ancienCarreau = jCourant.getPositionCourante();
        int numAncienCarreau = ancienCarreau.getNumero();
        int numNouvCarreau = (numAncienCarreau - 1 + valDes[0] + valDes[1]) % carreaux.size();
        Carreau nouveauCarreau = carreaux.get(numNouvCarreau);
        jCourant.setPositionCourante(nouveauCarreau);
        ihm.afficherAvancer(jCourant, valDes);
        
        
    }
    
    public Joueur jSuivant() {
        return joueurs.get((joueurs.indexOf(jCourant) + 1) % joueurs.size());
    }
    
    public boolean aFaitUnDouble() {
        return valDes[0] == valDes[1];
    }

    
    
    public void CreerPlateau(String dataFilename){
            buildGamePlateau(dataFilename);
    }

    private void buildGamePlateau(String dataFilename)
    {
        try{
            ArrayList<String[]> data = readDataFile(dataFilename, ",");
            
            

            //TODO: create cases instead of displaying
            for(int i=0; i<data.size(); ++i){
                String caseType = data.get(i)[0];

                if(caseType.compareTo("P") == 0){
                    //System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    ProprieteAConstruire p = new ProprieteAConstruire();
                    
                    p.setTypeCarreau((TypeCarreau.valeurDe(data.get(i)[0])));
                    p.setNumero(Integer.parseInt(data.get(i)[1]));
                    p.setNomCarreau(data.get(i)[2]);
                    p.setPrix(Integer.parseInt(data.get(i)[4]));
                    p.setLoyerBase(Integer.parseInt(data.get(i)[5]));
                    
                    //Ajouter Couleur/groupe p.setGroupe(CouleurPropriete.valueOf(data.get(i)[4]));
                    CouleurPropriete c = CouleurPropriete.valueOf(data.get(i)[3]);
                    
                    Groupe g = setGroupe(c);
                    g.setCouleur(c);
                    p.setGroupe(g);
                    g.addPropriete(p);

                    carreaux.add(p); 
                }
                else if(caseType.compareTo("G") == 0){
                    //System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Gare g = new Gare();
                    
                    g.setTypeCarreau((TypeCarreau.valeurDe(data.get(i)[0])));
                    g.setNumero(Integer.parseInt(data.get(i)[1]));
                    g.setNomCarreau(data.get(i)[2]);
                    g.setPrix(Integer.parseInt(data.get(i)[3]));

                    carreaux.add(g);
                }
                else if(caseType.compareTo("C") == 0){
                    //System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Compagnie c = new Compagnie();
                    
                    c.setTypeCarreau((TypeCarreau.valeurDe(data.get(i)[0])));
                    c.setNumero(Integer.parseInt(data.get(i)[1]));
                    c.setNomCarreau(data.get(i)[2]);
                    c.setPrix(Integer.parseInt(data.get(i)[3])); 

                    carreaux.add(c);
                }
                else if(caseType.compareTo("AU") == 0){
                    //System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    AutreCarreau ac = new AutreCarreau();
                    
                    ac.setTypeCarreau((TypeCarreau.valeurDe(data.get(i)[0])));
                    ac.setNumero(Integer.parseInt(data.get(i)[1]));
                    ac.setNomCarreau(data.get(i)[2]);

                    carreaux.add(ac);
                }
                else 
                    System.err.println("[buildGamePleateau()] : Invalid Data type");
            }

        } 
        catch(FileNotFoundException e){
                System.err.println("[buildGamePlateau()] : File is not found!");
        }
        catch(IOException e){
                System.err.println("[buildGamePlateau()] : Error while reading file!");
        }
        
       // System.out.println(groupes.size());
    }

    private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException {
        
        ArrayList<String[]> data = new ArrayList<String[]>();

        BufferedReader reader  = new BufferedReader(new FileReader(filename));
        String line = null;
        while((line = reader.readLine()) != null){
                data.add(line.split(token));
        }
        reader.close();

        return data;
    }
    
    
    public Groupe setGroupe(CouleurPropriete c) {
    int i = 0;
    Groupe g;

    while (i < groupes.size() && groupes.get(i).getCouleur() != c) {
        i++;
    }

    if (i == groupes.size()) {
        g = new Groupe(c);
        groupes.add(g);
    }
    else {
        g = groupes.get(i);
    }

    return g;
        
    }
    
    public boolean faillite(Joueur j){
        return j.getCash()<=0;
    }
    
    public void supprimerJoueur(Joueur j){
        for (Gare g : j.getGares()){
            g.setProprietaire(null);
        }
        for (Compagnie c : j.getCompagnies()){
            c.setProprietaire(null);
        }
        for (ProprieteAConstruire p : j.getProprietesAConstruires()){
            p.setProprietaire(null);
        }
        joueurs.remove(j);
    }
    
    public void payerLoyer(Propriete p) {
        
        int loyer = p.calculLoyer(valDes);
        jCourant.payerLoyer(loyer);
        p.getProprietaire().recevoirLoyer(loyer);
        ihm.affichePayerLoyer(p, loyer, jCourant);
    }
    
    public void acheterPropriete() {
        Propriete p = (Propriete) jCourant.getPositionCourante();
              ihm.afficheAchatProprieteAvant(jCourant, p);
              jCourant.subCash(p.getPrix());
              jCourant.addPropriete(p);
              p.setProprietaire(jCourant);
              ihm.afficheAchatProprieteApres(jCourant, p);
    }

}
    
    
    
    
    
    
