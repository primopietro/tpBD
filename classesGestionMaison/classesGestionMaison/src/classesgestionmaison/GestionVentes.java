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
        listeVentes = new ArrayList<Vente>();
        init();
    }
    
    public void init(){
        //Requete SQL load ventes dans la liste
    }
    
     public Vente getVente(int index){
        return listeVentes.get(index);
    }
    
    public void addVente(Vente vente){
        listeVentes.add(vente);
        //Requete SQL ajout proprio dans bd
    }
    
    public void removeVente(int index){
        listeVentes.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeVente(Vente vente){
        listeVentes.remove(vente);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierVente(Vente vente, int indiceVente){
        listeVentes.set(indiceVente, vente);
    }
        
     public int getIndiceVente(Vente vente){
        return listeVentes.indexOf(vente);
    }
     
     public int getIdLastVente(){
         return listeVentes.get(listeVentes.size() -1).getId_Vente();
     }

     public int getSizeVentes(){
         return listeVentes.size();
     }

    
}
