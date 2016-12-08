package Modele;

import Ui.TypeCarreau;

public abstract class Carreau {
    
    private TypeCarreau typeCarreau;    
    private int numero;
    private String nomCarreau;

    public Carreau() {
        this.typeCarreau = null;
        this.numero = -1;
        this.nomCarreau = null;
    }

   
    
        

    public int getNumero() {
            return this.numero;
    }

    public void setNomCarreau(String nomCarreau) {
        this.nomCarreau = nomCarreau;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TypeCarreau getTypeCarreau() {
        return typeCarreau;
    }

    public void setTypeCarreau(TypeCarreau typeCarreau) {
        this.typeCarreau = typeCarreau;
    }

    public String getNomCarreau() {
        return nomCarreau;
    }
    
    
        
}