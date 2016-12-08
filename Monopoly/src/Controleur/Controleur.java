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
        this.initPartie();

    }
               
    @Override    
    public void update(Observable o, Object arg) {
        if (arg == Commande.LANCER_DES) {
            valDes = lancerDés();
            avancer(jCourant, valDes);
            Carreau caseJoueur = jCourant.getPositionCourante();
            int numcaseJoueur = caseJoueur.getNumero();
            
            if (null != caseJoueur.getTypeCarreau()) 
                switch (caseJoueur.getTypeCarreau()) {
                    case "P":
                        ProprieteAConstruire p = (ProprieteAConstruire) jCourant.getPositionCourante();
                        if (p.getProprietaire() == null) {
                            ihm.acheter();
                        }
                        else {
                            if (p.getProprietaire() != jCourant) {
                                
                            }
                            else {
                                
                            }
                        }
                        break;
                    case "G":

                        break;
                    case "C":

                        break;
                    case "AU":

                        break;
                    default:
                        System.err.println("ERROR !");
                        break;
                }
            
            
            
            if (aFaitUnDouble()) {
            System.out.println("DOUBLE !!!!!!!!!!!!!!!!!!!!");
                ihm.jouerTour(jCourant); // Le joueur rejoue si il a fait un double
            }
            
        }
        else if (arg == Commande.ACHETER) {
            
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
        
        while (joueurs.size() != 0) {
            ihm.jouerTour(jCourant);
            jCourant = jSuivant();
        }
    }

    public void avancer(Joueur jCourant, int[] valDes) {
        System.out.println("Valeur des dés : " + valDes[0] + "   " + valDes[1]);
        
        Carreau ancienCarreau = jCourant.getPositionCourante();
        int numAncienCarreau = ancienCarreau.getNumero();
        int numNouvCarreau = (numAncienCarreau - 1 + valDes[0] + valDes[1]) % 40;
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
                    
                    p.setTypeCarreau(data.get(i)[0]);
                    p.setNumero(Integer.parseInt(data.get(i)[1]));
                    p.setNomCarreau(data.get(i)[2]);
                    p.setPrix(Integer.parseInt(data.get(i)[4]));
                    p.setLoyerBase(Integer.parseInt(data.get(i)[5]));
                    
                    //Ajouter Couleur/groupe p.setGroupe(CouleurPropriete.valueOf(data.get(i)[4]));
                    CouleurPropriete c = CouleurPropriete.valueOf(data.get(i)[3]);
                    
                    Groupe g = getGroupe(c);
                    g.setCouleur(c);
                    p.setGroupe(g);
                    g.addPropriete(p);

                    carreaux.add(p); 
                }
                else if(caseType.compareTo("G") == 0){
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Gare g = new Gare();
                    
                    g.setTypeCarreau(data.get(i)[0]);
                    g.setNumero(Integer.parseInt(data.get(i)[1]));
                    g.setNomCarreau(data.get(i)[2]);
                    g.setPrix(Integer.parseInt(data.get(i)[3]));

                    carreaux.add(g);
                }
                else if(caseType.compareTo("C") == 0){
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Compagnie c = new Compagnie();
                    
                    c.setTypeCarreau(data.get(i)[0]);
                    c.setNumero(Integer.parseInt(data.get(i)[1]));
                    c.setNomCarreau(data.get(i)[2]);
                    c.setPrix(Integer.parseInt(data.get(i)[3])); 

                    carreaux.add(c);
                }
                else if(caseType.compareTo("AU") == 0){
                    System.out.println("Type Carreau :\t" + data.get(i)[0] + "\t"  + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    AutreCarreau ac = new AutreCarreau();
                    
                    ac.setTypeCarreau(data.get(i)[0]);
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
    
    
    public Groupe getGroupe(CouleurPropriete c) {
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
    
}
    
    
    
    
    
    