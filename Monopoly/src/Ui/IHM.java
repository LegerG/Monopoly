package Ui;

import Controleur.Controleur;
import java.util.Observable;

public class IHM  extends Observable{
	public Controleur monopoly;
	public Controleur controleur;

    public Controleur getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(Controleur _monopoly) {
        this.monopoly = _monopoly;
    }

    public Controleur getControleur() {
        return controleur;
    }

    public void setControleur(Controleur _controleur) {
        this.controleur = _controleur;
    }
        
        
}