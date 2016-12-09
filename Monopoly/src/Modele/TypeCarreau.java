/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author rodrigcy
 */
public enum TypeCarreau {
    PROPRIETE ("P"),
    GARE ("G"),
    COMPAGNIE ("C"),
    AUTRE_CARREAU ("AU");
    
    private String name;

    private TypeCarreau(String name) {
        this.name = name;
    }
    
    
    public static TypeCarreau valeurDe(String s) {
        TypeCarreau tc = null;
        
        for (TypeCarreau tp : TypeCarreau.values()) {
            if (tp.name.equals(s)) {
                tc = tp.getType(s);
            }
        }
        return tc;
    }
    
    public TypeCarreau getType(String s) {
        if(s.equals(PROPRIETE.toString())){
            return PROPRIETE;
        }
        else if (s.equals(GARE.toString())){
            return GARE;
            
        }
        else if (s.equals(COMPAGNIE.toString())){
            return COMPAGNIE;
        }
        else {
            return AUTRE_CARREAU;
        }
    }
    
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
}
