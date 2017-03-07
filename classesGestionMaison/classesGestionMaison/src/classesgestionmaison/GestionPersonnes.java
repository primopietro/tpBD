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
public class GestionPersonnes {
       private ArrayList<Personne> listePersonnes;
    
    public GestionPersonnes(){
        listePersonnes= new ArrayList<Personne>();
        init();
    }
    
    public void init(){
        //Requete SQL load Personne dans la liste
    }

        public Personne getPersonneById(int id){
        
        for(Personne personne : listePersonnes){
            
            if(personne.getId_personne() == id){
                return personne;
            }
        }
        return null;
    }
    
    public Personne getPersonne(int index){
        return listePersonnes.get(index);
    }
    
    public void addPersonne(Personne personne){
        listePersonnes.add(personne);
        //Requete SQL ajout proprio dans bd
    }
    
    
    public int getIdLastPersonne(){
        return listePersonnes.get(listePersonnes.size() -1).getId_personne();
    }
    public void removePersonne(int index){
        listePersonnes.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    //Faut tester bien cette fonction
    public void removePersonne(Personne personne){
        listePersonnes.remove(personne);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierPersonne(Personne personne, int indicePersonne){
        listePersonnes.set(indicePersonne, personne);
        //Requete SQL enleve proprio dans bd
    }

}
