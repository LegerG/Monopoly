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
import Ui.TypeCarreau;
import Ui.Utilitaire;
import static Ui.Utilitaire.lancerDés;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Controleur implements Observer{

    private IHM ihm;
    private ArrayList<Carreau> carreaux = new ArrayList<>();
    private ArrayList<Groupe> groupes = new ArrayList<>();
    private ArrayList<Joueur> joueurs= new ArrayList<>();
    private final Carreau DEPART;
    private Carreau nouveauCarreau;
    private int[] valDes;
    private Joueur jCourant;

    public Controleur(IHM ihm) {
        this.ihm = ihm;
        CreerPlateau("src/Data/data.txt");
        this.DEPART = carreaux.get(0); 
        ihm.addObserver(this);
        

    }
               
    @Override    
    public void update(Observable o, Object arg) {
        if (arg == Commande.LANCER_DES) {
            valDes = lancerDés();
            avancer(jCourant, valDes);
            Carreau caseJoueur = jCourant.getPositionCourante();
            int numcaseJoueur = caseJoueur.getNumero();
            
             if(null != caseJoueur.getTypeCarreau()){
                 if((caseJoueur.getTypeCarreau() == TypeCarreau.P) ||
                    (caseJoueur.getTypeCarreau() == TypeCarreau.G) ||
                    (caseJoueur.getTypeCarreau() == TypeCarreau.C)){
                     Propriete p = (Propriete) jCourant.getPositionCourante();
                      if (p.getProprietaire() == null) {
                        ihm.acheter(p);
                           
                      }
                      else{
                          payerLoyer(p);
                      }

                 }
                 
             } 

            
            if (aFaitUnDouble()) {
                ihm.aFaitDouble();
                ihm.jouerTour(jCourant); // Le joueur rejoue si il a fait un double
            }
            
        }
        else if (arg == Commande.ACHETER) {
              Propriete p = (Propriete) jCourant.getPositionCourante();
              ihm.afficheAchatPropriete(jCourant, p);
              jCourant.subCash(p.getPrix());
              jCourant.addPropriete(nouveauCarreau);

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
        System.out.println("Valeur des dés : " + valDes[0] + "   " + valDes[1]);
        
        Carreau ancienCarreau = jCourant.getPositionCourante();
        int numAncienCarreau = ancienCarreau.getNumero();
        int numNouvCarreau = (numAncienCarreau - 1 + valDes[0] + valDes[1]) % carreaux.size();
        Carreau nouveauCarreau = carreaux.get(numNouvCarreau);
        jCourant.setPositionCourante(nouveauCarreau);
        
        System.out.println(jCourant.getNomJoueur() + " est a la position " + jCourant.getPositionCourante().getNumero());
        System.out.println("");
        
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
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    ProprieteAConstruire p = new ProprieteAConstruire();
                    
                    p.setTypeCarreau((TypeCarreau.valueOf(data.get(i)[0])));
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
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Gare g = new Gare();
                    
                    g.setTypeCarreau((TypeCarreau.valueOf(data.get(i)[0])));
                    g.setNumero(Integer.parseInt(data.get(i)[1]));
                    g.setNomCarreau(data.get(i)[2]);
                    g.setPrix(Integer.parseInt(data.get(i)[3]));

                    carreaux.add(g);
                }
                else if(caseType.compareTo("C") == 0){
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Compagnie c = new Compagnie();
                    
                    c.setTypeCarreau((TypeCarreau.valueOf(data.get(i)[0])));
                    c.setNumero(Integer.parseInt(data.get(i)[1]));
                    c.setNomCarreau(data.get(i)[2]);
                    c.setPrix(Integer.parseInt(data.get(i)[3])); 

                    carreaux.add(c);
                }
                else if(caseType.compareTo("AU") == 0){
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    AutreCarreau ac = new AutreCarreau();
                    
                    ac.setTypeCarreau((TypeCarreau.valueOf(data.get(i)[0])));
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
        
        System.out.println(groupes.size());
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
        System.out.println("TU ES TOMBE SUR UNE PROPRIETE");
        int loyer = p.calculLoyer(valDes);
        jCourant.payerLoyer(loyer);                       
        System.out.println(p.getProprietaire().getCash());
        p.getProprietaire().recevoirLoyer(loyer);
        System.out.println(p.getProprietaire().getCash());
    }
    
    
    public void testArretGare() {
        
    }
    
    public void testDouble() {
        
    }
    
    public void testPossedePropriete() {
        
    }
    
    public void testArretSurProprietePrive() {
        
    }
    
    public void testArretSurCompagnie() {
        
    }
    
    public void testFaillite() {
        Joueur j1 = new Joueur("J1");
        Joueur j2 = new Joueur("J2");
        joueurs.add(j1);
        joueurs.add(j2);
        
        jCourant = j2;
        j1.subCash(1499);
        Propriete p = (Propriete) carreaux.get(5);
        p.setProprietaire(jCourant);
        j2.addPropriete(p);
        j1.setPositionCourante(carreaux.get(5));
        payerLoyer((Propriete) carreaux.get(5));
        
        if (faillite(jCourant)){
            supprimerJoueur(jCourant);
            ihm.joueurSupprime(jCourant);
        }
        
        ihm.vainqueur(joueurs.get(0));

    }
    
    public void testVainqueur() {
        
    }
}
    
    
    
    
    
    
