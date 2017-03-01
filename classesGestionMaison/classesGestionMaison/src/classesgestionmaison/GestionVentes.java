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
public class GestionVentes {
    private ArrayList<Vente> listeVentes;
    
    public GestionVentes(){
        init();
    }
    
    public void init(){
        //Requete SQL load ventes dans la liste
    }
    
     public Vente getProprio(int index){
        return listeVentes.get(index);
    }
    
    public void addProprio(Vente vente){
        listeVentes.add(vente);
        //Requete SQL ajout proprio dans bd
    }
    
    public void removeProprio(int index){
        listeVentes.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeProprio(Vente vente){
        listeVentes.remove(vente);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierProprio(Vente vente){
        listeVentes.remove(vente);
        //Requete SQL enleve proprio dans bd
    }
        
     public int getIndiceProprio(Vente vente){
        return listeVentes.indexOf(vente);
    }
    public int getIndiceVente(Maison maison){
        return listeVentes.indexOf(maison);
    }
    


    public int getIdVente(Vente vente){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
     
    public int getIdVente(Proprio proprio){
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    
    public int getIdVente(int index){
        Vente venteAChercher = listeVentes.get(index);
        //Requete SQL trouve l'id ou retourne 0
        
        return 0;
    }
    
}
