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
public class GestionCourtier {
    private ArrayList<Courtier> listeCourtiers;
    
    private GestionCourtier(){
        init();
    }
    
    public void init(){
        //Requete SQL load courtiers dans la liste
    }

    public Courtier getProprio(int index){
        return listeCourtiers.get(index);
    }
    
    public void addProprio(Courtier courtier){
        listeCourtiers.add(courtier);
        //Requete SQL ajout courtier dans bd
    }
    
    public void removeProprio(int index){
        listeCourtiers.remove(index);        
        //Requete SQL enleve courtier dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeProprio(Courtier courtier){
        listeCourtiers.remove(courtier);
        //Requete SQL enleve courtier dans bd
    }
    //Faut tester bien cette fonction
    public void modifierProprio(Courtier courtier){
        listeCourtiers.remove(courtier);
        //Requete SQL enleve courtier dans bd
    }
        
    public int getIndiceProprio(Courtier courtier){
        return listeCourtiers.indexOf(courtier);
    }
    
    public int getIndiceProprio(Maison maison){
        return listeCourtiers.indexOf(maison);
    }
    

    public int getIdProprio(Maison maison){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
     
    public int getIdProprio(Courtier courtier){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    
    public int getIdProprio(int index){
        Courtier courtierAChercher = listeCourtiers.get(index);
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
}
