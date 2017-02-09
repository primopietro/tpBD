/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author montamal
 */
public class TraitementImage {

    /**
     * Prend l’objet i1 et fait une copie dans l’objet i2
     *
     * @param image1
     * @param image2
     */
    public static void copier(Image image1, Image image2) {
        image2.setHauteur(image1.getHauteur());
        image2.setLargeur(image1.getLargeur());

        image2.setMatrice();

        image2.setDelimiteur(image1.getDelimiteur());

        image2.setFormatImage(image1.getFormatImage());

        for (int i = 0; i < image2.getLargeur(); i++) {
            for (int j = 0; j < image2.getHauteur(); j++) {
                image2.setPixel(i, j, image1.getPixel(i, j));
            }
        }

    }

///** TEMPORARY BUT WORKS
// * Modifie la valeur de chaque pixel de l’image d’une valeur spécifiée, si v est
// * positif, l’image devient plus noire, si v est négatif, l’image devient plus
// * claire
// *
// * @param image
// * @param v
// */
//    public void eclaircir_noircir (Image image, int v){
//        if(image.getFormatImage()==".pgm")
//        {
//        PixelPGM tempPixel;
//        
//         for(int i=0;i<image.getLargeur();i++){
//               for(int j=0;j<image.getHauteur();j++){
//                   tempPixel = (PixelPGM)image.getPixel(i, j);
//                   tempPixel.add(v);
//                   image.setPixel(i, j, tempPixel);
//              }
//            }
//        }
//        
//        
//    }
    /**
     * Modifie la valeur de chaque pixel de l’image d’une valeur spécifiée, si v
     * est positif, l’image devient plus noire, si v est négatif, l’image
     * devient plus claire
     *
     * @param image
     * @param v
     */
    public static Image eclaircir_noircir(Image image, int v) {

        int temp = 0;
        Image image2 = new Image();
        TraitementImage.copier(image, image2);

        for (int i = 0; i < image.getLargeur(); i++) {
            for (int j = 0; j < image.getHauteur(); j++) {

                if (image.getFormatImage() == ".pgm") {
                    PixelPGM tempPixel = new PixelPGM();
                    temp = image.getPixel(i, j).getInt(0) + v;
                    if (temp < 0) {
                        temp = 0;
                    } else if (temp > image.getDelimiteur()) {
                        temp = image.getDelimiteur();
                    }
                    tempPixel.setPixel(temp);
                    image2.setPixel(i, j, tempPixel);
                } else if (image.getFormatImage() == ".ppm") {
                    PixelPPM tempPixel = new PixelPPM();

                    for (int k = 0; k < 3; k++) {

                        temp = image.getPixel(i, j).getInt(k) + v;

                        if (temp < 0) {
                            temp = 0;
                        } else if (temp > image.getDelimiteur()) {
                            temp = image.getDelimiteur();
                        }

                        tempPixel.setPixel(k, temp);
                    }
                    image2.setPixel(i, j, tempPixel);
                }

            }
        }
        return image2;
    }

    /**
     * Prend une partie de l'image pour en faire une nouvelle
     *
     * de p1,c1 jusqu'à p2,c2
     *
     * @param i
     * @param p1
     * @param c1
     * @param p2
     * @param c2
     */
    public static Image extraire(Image image, int p1, int c1, int p2, int c2) {

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

    /**
     * Créer une nouvelle image à partir de coordonnées dans l'image originale
     *
     * @param i image originale
     * @param nouvelleHauteur pour la hauteur de la nouvelle image
     * @param nouvelleLargeur pour la largeur de la nouvelle image
     * @param p pour coordonnée en X
     * @param c pour coordonnée en Y
     */
    public static Image crop(Image i, int nouvelleLargeur,
            int nouvelleHauteur, int p, int c) {
        int compt = 0;
        int compt1 = 0;

        Image nouvelleImage = new Image(i.getFormatImage(), i.getDelimiteur(),
                nouvelleLargeur, nouvelleHauteur);

        for (int k = p; k < nouvelleLargeur + p; k++) {
            for (int j = c; j < nouvelleHauteur + c; j++) {
                if (i.getFormatImage() == ".pgm") {
                    PixelPGM pixelTemp = new PixelPGM();
                    pixelTemp = (PixelPGM) i.getPixel(k, j);
                    nouvelleImage.setPixel(compt, compt1, pixelTemp);
                } else {
                    PixelPPM pixelTemp = new PixelPPM();
                    pixelTemp = (PixelPPM) i.getPixel(k, j);
                    nouvelleImage.setPixel(compt, compt1, pixelTemp);
                }

                compt1++;
            }
            compt1 = 0;
            compt++;
        }
        return nouvelleImage;
    }

    /**
     * Réduit l’image i1 pour produire l’image i2
     *
     * @return
     * @param image
     */
    public static Image reduire(Image image) {

        Image finale = new Image();
        finale.setDelimiteur(image.getDelimiteur());
        finale.setFormatImage(image.getFormatImage());

        int tempHauteur = image.getHauteur();
        int tempLargeur = image.getLargeur();
        int hauteurDivisee = 0;
        int largeurDivisee = 0;

        //Cas 1, reste 1 ligne et 1 cologne de pixels pas affectees
        if (tempLargeur % 2 != 0 && tempHauteur % 2 != 0) {

            hauteurDivisee = (tempHauteur - 1) / 2;
            largeurDivisee = (tempLargeur - 1) / 2;

        } //Cas 2, reste 1 ligne de pixels pas affectees
        else if (tempLargeur % 2 == 0 && tempHauteur % 2 != 0) {
            hauteurDivisee = (tempHauteur - 1) / 2;
            largeurDivisee = (tempLargeur) / 2;
        } //Cas 3, reste 1 cologne de pixels pas affectees
        else if (tempLargeur % 2 != 0 && tempHauteur % 2 == 0) {
            hauteurDivisee = (tempHauteur) / 2;
            largeurDivisee = (tempLargeur - 1) / 2;
        } //Cas 4, tous les pixels sont divisees
        else if (tempLargeur % 2 == 0 && tempHauteur % 2 == 0) {
            hauteurDivisee = (tempHauteur) / 2;
            largeurDivisee = (tempLargeur) / 2;

        }
        finale.setMatrice(largeurDivisee, hauteurDivisee);
        finale.setHauteur(hauteurDivisee);
        finale.setLargeur(largeurDivisee);

        for (int j = 0, i = 0; j < tempHauteur && i < tempLargeur;) {

            if (finale.getFormatImage() == ".pgm") {
                PixelPGM tempPixel = new PixelPGM();

                tempPixel = getAvgPixel((PixelPGM) image.getPixel(i, j),
                        (PixelPGM) image.getPixel(i + 1, j),
                        (PixelPGM) image.getPixel(i, j + 1),
                        (PixelPGM) image.getPixel(i + 1, j + 1));

                if (i / 2 <= tempHauteur && j / 2 <= tempLargeur) {
                    finale.setPixel(i / 2, j / 2, tempPixel);
                }

                i += 2;
                if (i >= tempLargeur) {
                    i = 0;
                    j += 2;
                }

            } else if (finale.getFormatImage() == ".ppm") {
                PixelPPM tempPixel = new PixelPPM();
                tempPixel = getAvgPixel((PixelPPM) image.getPixel(i, j),
                        (PixelPPM) image.getPixel(i + 1, j),
                        (PixelPPM) image.getPixel(i, j + 1),
                        (PixelPPM) image.getPixel(i + 1, j + 1));

                if (i / 2 < largeurDivisee && j / 2 < hauteurDivisee) {
                    finale.setPixel(i / 2, j / 2, tempPixel);
                }

                i += 2;
                if (i >= tempLargeur) {
                    i = 0;
                    j += 2;
                }
            }

        }

        return finale;
    }

    public static int comparerPixel(Pixel p, ArrayList a) {

        for (int i = 0; i < a.size(); i++) {
            if (p.comparer((Pixel) a.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static Pixel couleur_preponderante(Image i) {
        ArrayList<Integer> compteur = new ArrayList<Integer>();

        int temp = 0;
        int temp2 = 0;
        int max = 0;
        ArrayList<Pixel> array = new ArrayList<Pixel>();

        for (int k = 0; k < i.getLargeur(); k++) {
            for (int j = 0; j < i.getHauteur(); j++) {

                //Initialisation
                if (array.size() == 0) {
                    array.add((Pixel) i.getPixel(k, j));
                    compteur.add(1);
                } //Ajout d'autres pixels
                else {
                    //Verifier si le pixel est present
                    //Si present
                    Pixel pixelTemp = (Pixel) i.getPixel(k, j);
                    temp = comparerPixel(pixelTemp, array);
                    if (temp != -1) {

                        temp2 = compteur.get(temp) + 1;
                        compteur.set(temp, temp2);
                    } //Sinon
                    else {
                        array.add((Pixel) i.getPixel(k, j));
                        compteur.add(1);
                    }
                }
            }
        }
        max = Collections.max(compteur);
        max = compteur.indexOf(max);
        return array.get(max);
    }

    public static PixelPPM getAvgPixel(PixelPPM x1y1, PixelPPM x2y1,
            PixelPPM x1y2, PixelPPM x2y2) {
        PixelPPM tempPixel = new PixelPPM();
        int tempR = 0;
        int tempG = 0;
        int tempB = 0;

        tempR = x1y1.getInt(0) + x2y1.getInt(0) + x1y2.getInt(0) + x2y2.getInt(0);
        tempR = tempR / 4;
        tempG = x1y1.getInt(1) + x2y1.getInt(1) + x1y2.getInt(1) + x2y2.getInt(1);
        tempG = tempG / 4;
        tempB = x1y1.getInt(2) + x2y1.getInt(2) + x1y2.getInt(2) + x2y2.getInt(2);
        tempB = tempB / 4;

        tempPixel.setPixel(0, tempR);
        tempPixel.setPixel(1, tempG);
        tempPixel.setPixel(2, tempB);

        return tempPixel;

    }

    public static PixelPGM getAvgPixel(PixelPGM x1y1, PixelPGM x2y1,
            PixelPGM x1y2, PixelPGM x2y2) {
        PixelPGM tempPixel = new PixelPGM();
        int tempR = 0;

        tempR = x1y1.getInt(0) + x2y1.getInt(0) + x1y2.getInt(0) + x2y2.getInt(0);
        tempR = tempR / 4;

        tempPixel.setPixel(tempR);

        return tempPixel;

    }

    /**
     * Détecte si les deux images sont identiques pixel par pixel.
     *
     * @param image1
     * @param image2
     * @return
     */
    public static boolean sont_identiques(Image image1, Image image2) {
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
     * Permet de tourner de 90 degrés l’image.
     *
     * @param image
     */
    public static Image pivoter90(Image i) {

        Image nouvelleImage = new Image();

        nouvelleImage.setFormatImage(i.getFormatImage());
        nouvelleImage.setDelimiteur(i.getDelimiteur());
        nouvelleImage.setHauteur(i.getLargeur());
        nouvelleImage.setLargeur(i.getHauteur());
        nouvelleImage.setMatrice();

        for (int row = 0; row < nouvelleImage.getHauteur(); row++) {
            for (int col = 0; col < nouvelleImage.getLargeur(); col++) {
                nouvelleImage.setPixel(col, (nouvelleImage.getHauteur() - 1 - row), i.getPixel(row, col));
            }
        }
        return nouvelleImage;
    }

}
