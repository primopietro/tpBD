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
public class PixelPGM extends Pixel {

    public PixelPGM() {
        super(1);
    }

    public void copyPixel(Integer[] pixel) {
        this.pixel = pixel;
    }

    public void setPixel(int p) {
        this.pixel[0] = p;
    }
    /*
     Utilisé pour incrémenter le tableau de pixel de 1 (trouver la couleur prédominante)
     */

    public void add(int x) {
        this.pixel[0] += x;
    }
}
