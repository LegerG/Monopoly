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
import Ui.IHM;
import Ui.Utilitaire;
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
        

    public Controleur(IHM ihm) {
        this.ihm = ihm;
        CreerPlateau("src/Data/data.txt");
        this.DEPART = carreaux.get(0);
        this.initPartie();
    }
               
    @Override    
    public void update(Observable o, Object arg) {
            // TODO - implement Controleur.update
            throw new UnsupportedOperationException();
    }
    
    public void initPartie() {
        ArrayList<String> listJoueur = ihm.getJoueurs();
        for (String s : listJoueur) {
            Joueur j = new Joueur(s);
            j.setPositionCourante(DEPART);
            joueurs.add(j);
        }
        
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
                    System.out.println("Propriété à Construire :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    ProprieteAConstruire p = new ProprieteAConstruire();

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
                    System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Gare g = new Gare();

                    g.setNumero(Integer.parseInt(data.get(i)[1]));
                    g.setNomCarreau(data.get(i)[2]);
                    g.setPrix(Integer.parseInt(data.get(i)[3]));

                    carreaux.add(g);
                }
                else if(caseType.compareTo("C") == 0){
                    System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                    Compagnie c = new Compagnie();

                    c.setNumero(Integer.parseInt(data.get(i)[1]));
                    c.setNomCarreau(data.get(i)[2]);
                    c.setPrix(Integer.parseInt(data.get(i)[3])); 

                    carreaux.add(c);
                }
                else if(caseType.compareTo("AU") == 0){
                    System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    AutreCarreau ac = new AutreCarreau();

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

    private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
    {
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
    
    
    
    
    
    