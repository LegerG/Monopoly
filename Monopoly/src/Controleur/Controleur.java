package Controleur;

import Modele.Carreau;
import Ui.IHM;
import java.util.ArrayList;

public class Controleur {

	private final IHM ihm;
        private final ArrayList<Carreau> carreaux = new ArrayList<>(null);
        private final Carreau DEPART = carreaux.get(0);

    public Controleur(IHM ihm) {
        this.ihm = ihm;
    }
        
        
        
    public void update() {
            // TODO - implement Controleur.update
            throw new UnsupportedOperationException();
    }

    
    
    
    
    
    
}