/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.io.IOException;

/**
 *
 * @author Pietro
 */
public class Tp1Bd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Image image = new Image();
        
        Fichier fichier = new Fichier("4par4.pgm");
        
        fichier.lire(fichier, image);
        
         System.out.println("APRES");
        
        TraitementImage.eclaircir_noircir(image, 20);
         for (int row = 0; row < image.getLargeur()-1; row++) {
            for (int col = 0; col < image.getHauteur()-1; col++) {

                System.out.print(image.getPixel(row, col).getInt()+ " ");
            }
            System.out.println();
        }

    } 
    
}
