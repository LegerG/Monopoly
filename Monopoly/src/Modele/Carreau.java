package Modele;

public abstract class Carreau {
    
    private String typeCarreau;    
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

    public String getTypeCarreau() {
        return typeCarreau;
    }

    public void setTypeCarreau(String typeCarreau) {
        this.typeCarreau = typeCarreau;
    }
    
    
        
}