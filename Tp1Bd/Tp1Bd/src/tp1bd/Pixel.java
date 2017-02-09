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
public class Pixel {

    protected Integer[] pixel;
    protected int size;

    public Pixel(int taille) {
        this.size = taille;
        this.pixel = new Integer[size];
    }

    /**
     * Utilisé pour convertir le pixel en int
     *
     * @param ind pour l'indice dans le tableau de 3
     */
    public int getInt(int ind) {
        return this.pixel[ind];
    }

    public boolean comparer(Pixel p) {
        if (this.size == p.size) {
            for (int i = 0; i < size; i++) {
                if (this.pixel[i] != p.pixel[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
