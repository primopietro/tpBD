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
 private int indiceMaison;
    private int indicePrietaire;
    private double montantPropriete;
    
    public Proprio(){
       indiceMaison = 0;
       indicePrietaire= 0;
       montantPropriete =0;
    }
    public Maison getMaison(GestionMaison maisons) {
        return maisons.getMaison(indiceMaison);
    }
    public Personne getPersonne(GestionPersonnes personnes) {
        return personnes.getPersonne(indicePrietaire);
    }

    public void setMaison(Maison maison) {
        //this.maison = maison;
    }


    public void setProprietaire(Proprietaire proprietaire) {
        //this.proprietaire = proprietaire;
    }

    public double getMontantPropriete() {
        return montantPropriete;
    }

    public void setMontantPropriete(double montantPropriete) {
        this.montantPropriete = montantPropriete;
    }
    
   
}
