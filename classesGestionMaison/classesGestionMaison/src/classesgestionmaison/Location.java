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
    private Personne locateur;
    private String dateLocation;
    private String dateRetour;
    private double prixLocation;
    private int moisLocation;
    private int id_location;

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }
    
    public Location(){
        maison = new Maison();
        locateur = new Personne();
        dateLocation = null;
        dateRetour =null;
        prixLocation =0;
        moisLocation =0;
    }
    
        public Personne getLocateur() {
        return locateur;
    }

    public void setLocateur(Personne locateur) {
        this.locateur = locateur;
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
    
        
    public void show(){
        System.out.println("LA MAISON");
        maison.show();
        System.out.println("LE LOCATEUR");
        locateur.show();
        
        System.out.println("dateLocation : "+ dateLocation);
       System.out.println("dateRetour : "+ dateRetour);
       System.out.println("prixLocation : "+ prixLocation); 
        System.out.println("moisLocation : "+ moisLocation); 
        
    }
    
}
