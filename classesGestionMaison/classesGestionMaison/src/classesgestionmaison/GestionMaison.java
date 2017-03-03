/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pietro
 */
public class GestionMaison {

    private ArrayList<Maison> listeMaisons;
    
    public GestionMaison(){
      listeMaisons = new ArrayList<Maison>();
    }
    
    public Maison getMaison(int index){
        return listeMaisons.get(index);
    }
    
    public void addMaison(Maison maison){
        listeMaisons.add(maison);
        //Requete SQL ajout maison dans bd
    }
    
    public void removeMaison(int index){
        listeMaisons.remove(index);        
        //Requete SQL enleve maison dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeMaison(Maison maison){
        listeMaisons.remove(maison);
        //Requete SQL enleve maison dans bd
    }
    //Faut tester bien cette fonction
    public void modifierMaison(Maison maison){
        listeMaisons.remove(maison);
        //Requete SQL enleve maison dans bd
    }
        
    public int getIndiceMaison(Maison maison){
        return listeMaisons.indexOf(maison);
    }
    
    public int getIdMaison(Maison maison){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    public int getIdMaison(int index){
        Maison maisonAChercher = listeMaisons.get(index);
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
 }

