/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

/**
 *
 * @author Pietro
 */
public class Vente {
    private Maison maison;
    private String dateVente;
    private double prixVente;
    
    public Vente(){
        maison = new Maison();
        dateVente = null;
        prixVente =0;
    }
}
