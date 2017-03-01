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
public class Proprio {
 private Maison maison;
    private Proprietaire proprietaire;
    private double montantPropriete;
    
    public Proprio(){
       maison = new Maison();
       proprietaire= new Proprietaire();
       montantPropriete =0;
    }
    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public double getMontantPropriete() {
        return montantPropriete;
    }

    public void setMontantPropriete(double montantPropriete) {
        this.montantPropriete = montantPropriete;
    }
    
   
}
