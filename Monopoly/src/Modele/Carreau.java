package Modele;

public abstract class Carreau {
	private int _numero;
	private String nomCarreau;

	public int getNumero() {
		return this._numero;
	}

    public String getNomCarreau() {
        return nomCarreau;
    }

    public void setNomCarreau(String nomCarreau) {
        this.nomCarreau = nomCarreau;
    }
        
        
}