/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

/**
 *
 * @author montamal
 */
public class PixelPPM extends Pixel {

    public PixelPPM() {
        super(3);
    }

    public void copyPixel(Integer[] pixel) {
        this.pixel = pixel;
    }

    public void setPixel(int ind, int p) {
        this.pixel[ind] = p;
    }

    /*
     Utilisé pour incrémenter le tableau de pixel de 1 (trouver la couleur prédominante)
     pourrait mettre la boucle for dans la méthode a place...
     */
    public void add(int ind, int x) {
        this.pixel[ind] += x;
    }
}
