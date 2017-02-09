/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.io.IOException;

/**
 *
 * @author
 */
public class Tp1Bd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /**
         * Partie pgm
         */
//        Image image = new Image();
//        Image image2 = new Image();
//        Image image3 = new Image();
//        Image image4 = new Image();
//        Image image5 = new Image();
//        Image image6 = new Image();
//        Image image7 = new Image();
//        Fichier fichierPgm = new Fichier("pgm.pgm");
//        Fichier fichierCopie = new Fichier("copiePgm.pgm");
//        Fichier fichierExtraire = new Fichier("extrairePgm.pgm");
//        Fichier fichierPivot = new Fichier("pivotPgm.pgm");
//        Fichier fichierEclaircir = new Fichier("eclaircirPgm.pgm");
//        Fichier fichierNoircir = new Fichier("noircirPgm.pgm");
//        Fichier fichierReduit = new Fichier("reduitPgm.pgm");
//        
//        fichierPgm.lire(fichierPgm, image);
//        
//        TraitementImage.copier(image, image2);
//        fichierCopie.ecrire(image2, fichierCopie);
//        
//        if(TraitementImage.sont_identiques(image, image2)){
//           System.out.println("Image 1 et 2 sont identique");
//        }
//        
//        image3 = TraitementImage.extraire(image, 10, 10, 150, 182);
//        fichierExtraire.ecrire(image3, fichierExtraire);
//        
//        if(!TraitementImage.sont_identiques(image2, image3)){
//           System.out.println("Image 2 et 3 ne sont pas identique");
//        }
//        
//        image4 = TraitementImage.pivoter90(image3);
//        fichierPivot.ecrire(image4, fichierPivot);
//        
//        image5 = TraitementImage.eclaircir_noircir(image4, 50);
//        fichierEclaircir.ecrire(image5, fichierEclaircir);
//        
//        image6 = TraitementImage.eclaircir_noircir(image4, -50);
//        fichierNoircir.ecrire(image6, fichierNoircir);
//        
//        image7 = TraitementImage.reduire(image);
//        fichierReduit.ecrire(image7, fichierReduit);
//        
//        System.out.println("Couleur prépondérante de l'image original " + TraitementImage.couleur_preponderante(image).getInt(0));

        /**
         * Partie ppm
         */
        Image image = new Image();
        Image image2 = new Image();
        Image image3 = new Image();
        Image image4 = new Image();
        Image image5 = new Image();
        Image image6 = new Image();
        Image image7 = new Image();
        Fichier fichierPgm = new Fichier("ppm.ppm");
        Fichier fichierCopie = new Fichier("copiePpm.ppm");
        Fichier fichierExtraire = new Fichier("extrairePpm.ppm");
        Fichier fichierPivot = new Fichier("pivotPpm.ppm");
        Fichier fichierEclaircir = new Fichier("eclaircirPpm.ppm");
        Fichier fichierNoircir = new Fichier("noircirPpm.ppm");
        Fichier fichierReduit = new Fichier("reduitPpm.ppm");

        fichierPgm.lire(fichierPgm, image);

        TraitementImage.copier(image, image2);
        fichierCopie.ecrire(image2, fichierCopie);

        if (TraitementImage.sont_identiques(image, image2)) {
            System.out.println("Image 1 et 2 sont identique");
        }

        image3 = TraitementImage.extraire(image, 10, 10, 150, 182);
        fichierExtraire.ecrire(image3, fichierExtraire);

        if (!TraitementImage.sont_identiques(image2, image3)) {
            System.out.println("Image 2 et 3 ne sont pas identique");
        }

        image4 = TraitementImage.pivoter90(image3);
        fichierPivot.ecrire(image4, fichierPivot);

        image5 = TraitementImage.eclaircir_noircir(image4, 50);
        fichierEclaircir.ecrire(image5, fichierEclaircir);

        image6 = TraitementImage.eclaircir_noircir(image4, -50);
        fichierNoircir.ecrire(image6, fichierNoircir);

        image7 = TraitementImage.reduire(image);
        fichierReduit.ecrire(image7, fichierReduit);

        System.out.println("Couleur prépondérante de l'image original " + TraitementImage.couleur_preponderante(image).getInt(0) + " " + TraitementImage.couleur_preponderante(image).getInt(1) + " " + TraitementImage.couleur_preponderante(image).getInt(2));
    }
}
