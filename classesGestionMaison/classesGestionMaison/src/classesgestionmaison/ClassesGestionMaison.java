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
    GestionTotal.initMaisons(maisons);
//   Maison maison2 =  new Maison();
//   maison2 = maisons.getMaison(0);
//   maison2.setRue("GODBLESS");
//   maison2.setCodePostal("666667");
//   GestionTotal.addMaison(maisons, maison2);
//        maison2.show();

Maison maison3 = maisons.getMaison(1);
GestionTotal.removeMaison(maisons, maison3);
    }
    
}
