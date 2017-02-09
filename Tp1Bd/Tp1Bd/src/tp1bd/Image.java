package tp1bd;

import java.util.Arrays;
import java.util.Collections;

/**
 * Cette classe define une image de type PGM ou PPM avec ces parametres.
 *
 * @author Pietro
 */
public class Image {

    //Declaration des variables locales
    private String formatImage; //Format de l'image
    //P2 = .pgm / P3 = .ppm 
    private int hauteur; //Hauteure de l'image en pixels
    private int largeur; //Largeure de l'image en pixels
    private int delimiteur; //Valeur maximum pour un pixel
    private Pixel[][] matrice;//Matrice les pixels 

    /*
     *Constructeur vide
     */
    Image() {
        formatImage = null;
        hauteur = 0;
        largeur = 0;
        delimiteur = 0;
        matrice = null;
    }

    /*
     Constructeur avec parametre
     @param format pour formatImage
     @param haut pour hauteur
     @param larg pour largeur
     @param del pour delimiteur
     */
    Image(String format, int del, int larg, int haut) {
        formatImage = format;
        hauteur = haut;
        largeur = larg;
        delimiteur = del;
        matrice = new Pixel[larg][haut];
    }

    /**
     * Get : La largeur de l'image
     *
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Get : l'hauteur de l'image
     *
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Get : Le format de l'image P1 = .pbm / P2 = .pgm / P3 = .ppm
     *
     * @return formatImage
     */
    public String getFormatImage() {
        return formatImage;
    }

    /**
     * Get : La valeur maximale pour un pixel
     *
     * @return delimiteur
     */
    public int getDelimiteur() {
        return delimiteur;
    }

    /**
     * Get : Le coleur preponderate
     *
     * @return Le pixel present le plus de fois
     */
//    public Pixel getColeurPlusUtilisee() {
//        Pixel[] totalPixels =new Pixel[delimiteur+1];
//        Pixel pixel;
//        if (this.formatImage==".pgm") pixel = new PixelPGM();
//        else pixel = new PixelPPM();
//        for(int i=0;i<largeur;i++){
//            for(int j=0;j<hauteur;j++){
//                int ind;
//                pixel = getPixel(i,j);
//                if (this.formatImage==".pgm") ind = pixel.returnInt(0);
//                totalPixels[ind].add(1);
//            }
//        }
//        Arrays.sort(totalPixels, Collections.reverseOrder());
//        return totalPixels[0];
//    }
    /**
     * Get : La valeur por un pixel dans la matrice
     *
     * @param x l'endroit X dans la matrice
     * @param y l'endroit y dans la matrice
     * @return
     */
    public Pixel getPixel(int x, int y) {
        return matrice[x][y];
    }

    /**
     * Set : La matrice en utilisant la largeur et hauteur deja definies
     */
    public void setMatrice() {
        matrice = new Pixel[largeur][hauteur];
    }

    /**
     * Set : La matrice en utilisant la x pour la largeur et y pour l'hauteur
     *
     * @param x la largeur de la matrice
     * @param y la hauteur de la matrice
     */
    public void setMatrice(int x, int y) {
        matrice = new Pixel[x][y];
    }

    /**
     * Set : La valeur d'un pixel dans la matrice
     *
     * @param x l'endroit X dans la matrice
     * @param y l'endroit y dans la matrice
     * @param pixel
     */
    public void setPixel(int x, int y, Pixel pixel) {
        matrice[x][y] = pixel;
    }

    /**
     * Set : Le format pour une image P1 = .pbm / P2 = .pgm / P3 = .ppm
     *
     * @param formatImage
     */
    public void setFormatImage(String formatImage) {
        this.formatImage = formatImage;
    }

    /**
     * Set : L'hauteur de la matrice
     *
     * @param hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Set : La largeur de la matrice
     *
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * Set : Le valeur max. pour un pixel dans la matrice
     *
     * @param delimiteur la valeur max. pour un pixel
     */
    public void setDelimiteur(int delimiteur) {
        this.delimiteur = delimiteur;
    }

}
