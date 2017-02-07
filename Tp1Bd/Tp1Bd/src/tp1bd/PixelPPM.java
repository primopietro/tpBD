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
    
    public Integer getPixel(int ind) {
        return pixel[ind];
    }
    
    public void copyPixel(Integer[] pixel) {
        this.pixel = pixel;
    }
    
    public void setPixel(int ind, int p) {
        this.pixel[ind] = p;
    }
    
    /*
    Utilisé pour incrémenter le tableau de pixel de 1 (trouver la couleur prédominante)
    */
    public void add(int ind,int x)
    {
        this.pixel[ind]+=x;
    }
    
     /*
    Utilisé pour convertir le pixel en int 
    @param ind pour l'indice dans le tableau de 3
    */
    public int returnInt(int ind)
    {
        return this.pixel[ind];
    }
}
