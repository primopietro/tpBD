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
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SimpleDataSource.init("bd.properties");

        //Liste des maison
        GestionMaison maisons = new GestionMaison();
        //Liste des personnes
        GestionPersonnes personnes = new GestionPersonnes();
        //Liste des locations
        GestionLocation locations = new GestionLocation();
        //Liste des ventes
        GestionVentes ventes = new GestionVentes();
        //Liste d'offres d'achat
        GestionOffres offres = new GestionOffres();

        //Load personnes et maisons dans la BD
        GestionImmobiliere.initMaisons(maisons);
        GestionImmobiliere.initPersonnes(personnes);
        GestionImmobiliere.initLocations(locations, personnes, maisons);
        GestionImmobiliere.initVentes(ventes, personnes, maisons);
        GestionImmobiliere.initOffresAchat(offres, personnes, maisons);

        //Utiliser GestionImmobiliere
        //pour faire des changements a BD et aux listes
        System.out.println("Fin du programme");

    }

}
