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
public class GestionProprio {

    private ArrayList<Proprio> listeProprios;
    
    private GestionProprio(){
        init();
    }
    
    public void init(){
        //Requete SQL load proprios dans la liste
    }

    public Proprio getProprio(int index){
        return listeProprios.get(index);
    }
    
    public void addProprio(Proprio proprio){
        listeProprios.add(proprio);
        //Requete SQL ajout proprio dans bd
    }
    
    public void removeProprio(int index){
        listeProprios.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeProprio(Proprio proprio){
        listeProprios.remove(proprio);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierProprio(Proprio proprio){
        listeProprios.remove(proprio);
        //Requete SQL enleve proprio dans bd
    }
        
    public int getIndiceProprio(Proprietaire proprietaire){
        return listeProprios.indexOf(proprietaire);
    }
    
    public int getIndiceProprio(Maison maison){
        return listeProprios.indexOf(maison);
    }
    
     public int getIndiceProprio(Proprio proprio){
        return listeProprios.indexOf(proprio);
    }
     public int getIdProprio(Proprietaire proprietaire){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
     }
    public int getIdProprio(Maison maison){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
     
    public int getIdProprio(Proprio proprio){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    
    public int getIdProprio(int index){
        Proprio proprioAChercher = listeProprios.get(index);
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
 }

