/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

/**
 *
 * @author rodrigcy
 */
public enum TypeCarreau {
    P ("P"),
    G ("G"),
    C ("C"),
    AU ("AU");
    
    private String name;

    private TypeCarreau(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
}
