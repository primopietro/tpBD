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
public class GestionOffres {
     private ArrayList<OffreAchat> listeOffresAchat;
    
    public GestionOffres(){
        listeOffresAchat = new ArrayList<OffreAchat>();
    }
    
    
     public OffreAchat getOffre(int index){
        return listeOffresAchat.get(index);
    }
    
    public void addOffre(OffreAchat offreAchat){
        listeOffresAchat.add(offreAchat);
        //Requete SQL ajout proprio dans bd
    }
    
    public void removeOffre(int index){
        listeOffresAchat.remove(index);        
        //Requete SQL enleve proprio dans bd
    }
    
    //Faut tester bien cette fonction
    public void removeOffre(OffreAchat offreAchat){
        listeOffresAchat.remove(offreAchat);
        //Requete SQL enleve proprio dans bd
    }
    //Faut tester bien cette fonction
    public void modifierOffre(OffreAchat offreAchat, int indiceVente){
        listeOffresAchat.set(indiceVente, offreAchat);
    }
        
     public int getIndiceOffre(OffreAchat offreAchat){
        return listeOffresAchat.indexOf(offreAchat);
    }
     
     public int getIdLastOffre(){
         return listeOffresAchat.get(listeOffresAchat.size() -1).getId_offre();
     }
     
     public int getSizeOffres(){
         return listeOffresAchat.size();
     }


}
