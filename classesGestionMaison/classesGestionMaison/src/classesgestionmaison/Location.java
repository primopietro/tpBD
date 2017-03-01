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
public class Location {

    private Maison maison;
    private String dateLocation;
    private String dateRetour;
    private double prixLocation;
    private int moisLocation;
    
    public Location(){
        maison = new Maison();
        dateLocation = null;
        dateRetour =null;
        prixLocation =0;
        moisLocation =0;
    }
    
    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public String getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(String dateLocation) {
        this.dateLocation = dateLocation;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public int getMoisLocation() {
        return moisLocation;
    }

    public void setMoisLocation(int moisLocation) {
        this.moisLocation = moisLocation;
    }
    
}
