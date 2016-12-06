/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Controleur.Controleur;
import Ui.IHM;

/**
 *
 * @author rodrigcy
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IHM ihm = new IHM();
        Controleur controleur = new Controleur(ihm);
        
        ihm.addObserver(controleur);
        
        
    }
    
}
