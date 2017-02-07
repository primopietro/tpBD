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
    
    public int getInt()
    {
        return this.pixel[0];
    }
    
    public int getInt(int ind)
    {
        return this.pixel[ind];
    }
}
