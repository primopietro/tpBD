/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;
import java.io.IOException;
/**
 *
 * @author Pietro
 */
public class ClassesGestionMaison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        
     SimpleDataSource.init("bd.properties");
     
     GestionMaison maisons = new GestionMaison();
     GestionPersonnes personnes = new GestionPersonnes();
     
     GestionLocation locations = new GestionLocation();
     
     GestionImmobiliere.initMaisons(maisons);
     GestionImmobiliere.initPersonnes(personnes);
     
     Personne pTemp = personnes.getPersonne(0);
    
  GestionImmobiliere.removePersonne(personnes, pTemp);
  System.out.println("Fin du programme");
   


    
    

    }
    
}
