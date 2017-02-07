/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author montamal
 */
public class TraitementImage {

    /**
     * Modifie la valeur de chaque pixel de l’image d’une valeur spécifiée, si v
     * est positif, l’image devient plus noire, si v est négatif, l’image
     * devient plus claire
     *
     * @param i
     * @param p1
     * @param c1
     * @param p2
     * @param c2
     */
    public Image extraire(Image image, int p1, int c1, int p2, int c2) {

        int nouvelleLargeur = 0;
        int nouvelleHauteur = 0;

        Image nouvelleImage = new Image();

        //Cas 1
        if (p1 < p2 && c1 < c2) {
            nouvelleLargeur = p2 - p1;
            nouvelleHauteur = c2 - c1;
            nouvelleImage = crop(image, nouvelleLargeur, nouvelleHauteur, p1, c1);
        } //Cas 2
        else if (p1 > p2 && c1 < c2) {
            nouvelleLargeur = p1 - p2;
            nouvelleHauteur = c2 - c1;
            nouvelleImage = crop(image, nouvelleLargeur, nouvelleHauteur, p2, c1);
        } //Cas 3
        else if (p1 < p2 && c1 > c2) {
            nouvelleLargeur = p2 - p1;
            nouvelleHauteur = c1 - c2;
            nouvelleImage = crop(image, nouvelleLargeur, nouvelleHauteur, p1, c2);
        } //Cas 4
        else if (p1 > p2 && c1 > c2) {
            nouvelleLargeur = p1 - p2;
            nouvelleHauteur = c1 - c2;
            nouvelleImage = crop(image, nouvelleLargeur, nouvelleHauteur, p2, c2);
        }
        return nouvelleImage;
    }

    public Image crop(Image i, int nouvelleHauteur, int nouvelleLargeur, int p, int c) {
        int compt = 0;
        int compt1 = 0;

        Image nouvelleImage = new Image(i.getFormatImage(), i.getDelimiteur(), nouvelleLargeur, nouvelleHauteur);

        for (int k = c; k <= nouvelleHauteur + c; k++) {
            for (int j = p; j <= nouvelleLargeur + p; j++) {
                nouvelleImage.setPixel(k, j, i.getPixel(compt, compt1));
                compt1++;
            }
            compt1 = 0;
            compt++;
        }
        return nouvelleImage;
    }

    /**
     * Permet de tourner de 90 degrés l’image.
     *
     * @param image
     */
    public Image pivoter90(Image i) {

        //first change the dimensions vertical length for horizontal length
        //and viceversa
        Image nouvelleImage = new Image(i.getFormatImage(), i.getDelimiteur(), i.getLargeur(), i.getHauteur());

        //invert values 90 degrees clockwise by starting from button of
        //array to top and from left to right
        int ii = 0;
        int jj = 0;
        for (int k = 0; k < i.getLargeur(); k++) {
            for (int j = i.getHauteur() - 1; j >= 0; j--) {
                nouvelleImage.setPixel(ii, jj, i.getPixel(k, j));
                jj++;
            }
            ii++;
        }

        return nouvelleImage;
    }

    /**
     * Détecte si les deux images sont identiques pixel par pixel.
     *
     * @param image1
     * @param image2
     * @return
     */
    public boolean sont_identiques(Image image1, Image image2) {
        int tempHauteure = image1.getHauteur();
        int tempLargeure = image1.getLargeur();

        if (tempHauteure == image2.getHauteur()
                && tempLargeure == image2.getLargeur()
                && image1.getDelimiteur() == image2.getDelimiteur()) {
            for (int i = 0; i < image1.getLargeur(); i++) {
                for (int j = 0; j < image1.getHauteur(); j++) {
                    if (image1.getPixel(i, j) != image2.getPixel(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    /**
     * Modifie la valeur de chaque pixel de l’image d’une valeur spécifiée, si v
     * est positif, l’image devient plus noire, si v est négatif, l’image
     * devient plus claire
     *
     * @param image
     * @param v
     */
    public static void eclaircir_noircir(Image image, int v) {
        
        int temp =0;
        
        
        for (int i = 0; i < image.getLargeur()-1; i++) {
            for (int j = 0; j < image.getHauteur()-1; j++) {
               
                if(image.getFormatImage() == ".pgm" ){
                       PixelPGM tempPixel = new PixelPGM();
                       temp = image.getPixel(i, j).getInt(0) +v;
                        if(temp<0){
                              temp=0;
                          }
                          else if(temp>image.getDelimiteur()){
                              temp =image.getDelimiteur();
                          }
                       tempPixel.setPixel(temp); 
               image.setPixel(i, j, tempPixel);
                }
                else if(image.getFormatImage() == ".ppm" ){
                      PixelPPM tempPixel = new PixelPPM();
                     
                      for(int k=0;k<3;k++){
                       
                          temp = image.getPixel(i, j).getInt(k) +v; 
                          
                          if(temp<0){
                              temp=0;
                          }
                          else if(temp>image.getDelimiteur()){
                              temp =image.getDelimiteur();
                          }
                                  
                          tempPixel.setPixel(k, temp);
                      } 
                image.setPixel(i, j, tempPixel);
                }
                
            }
        }
    }

    /**
     * Prend l’objet i1 et fait une copie dans l’objet i2
     *
     * @param image1
     * @param image2
     */
    public void copier(Image image1, Image image2) {
        image2 = image1; //?
    }

    /**
     * Retournera la couleur prépondérante de l’image i
     *
     * @param image
     * @return
     */
//    public static Pixel coleur_preponderate(Image image) {
//  
//        Pixel[] totalPixels = new Pixel[image.getDelimiteur() + 1];
//        Pixel pixel;
//        if (image.getFormatImage() == ".pgm") {
//            pixel = new PixelPGM();
//        } else {
//            pixel = new PixelPPM();
//        }
//        for (int i = 0; i < image.getLargeur(); i++) {
//            for (int j = 0; j < image.getHauteur(); j++) {
//                int ind;
//                pixel = image.getPixel(i, j);
//                if (image.getFormatImage() == ".pgm") {
//                    ind = pixel.returnInt(0);
//                }
//                totalPixels[ind].add(1);
//            }
//        }
//        Arrays.sort(totalPixels, Collections.reverseOrder());
//        return totalPixels[0];
//    }

    /**
     * Réduit l’image i1 pour produire l’image i2
     *
     * @param image
     */
    public void reduire(Image image) {

    }

    /**
     * Get : Le coleur preponderate
     *
     * @return Le pixel present le plus de fois
     */
//    public Pixel getColeurPlusUtilisee(Image image) {
//        
//    }
}
