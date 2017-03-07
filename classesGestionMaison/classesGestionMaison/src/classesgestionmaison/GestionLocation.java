/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

import java.util.ArrayList;

/**
 *
 * @author Pietro
 */
public class GestionLocation {
    
    
    private ArrayList<Location> listeLocations;
    public GestionLocation(){
        listeLocations = new ArrayList<Location>();
        init();
    }
    
    public void init(){
        //Requete SQL load locations dans la liste
    }
    
     public Location getLocation(int index){
        return listeLocations.get(index);
    }
    
    public void addLocation(Location location){
        listeLocations.add(location);
        //Requete SQL ajout proprio dans bd
    }
    
    public void removeLocation(int index){
        listeLocations.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    public int getIdLastLocation(){
        return listeLocations.get(listeLocations.size() -1).getId_location();
    }
    //Faut tester bien cette fonction
    public void removeLocation(Location location){
        listeLocations.remove(location);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierLocation(Location location, int indice){
        listeLocations.set(indice, location);
    }
        
     public int getIndiceLocation(Location location){
        return listeLocations.indexOf(location);
    }
    public int getIndiceLocation(Maison maison){
        return listeLocations.indexOf(maison);
    }
    


    public int getIdLocation(Vente vente){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
     
    public int getIdLocation(Proprio proprio){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    
    public int getIdLocation(int index){
        Location locationAChercher = listeLocations.get(index);
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }

}
