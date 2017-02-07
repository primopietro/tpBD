/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public class Fichier {

    private String filepath;    
    
    /*
    Constructeur sans paramètre
    */
    Fichier() {
        filepath = "";
    }
    /*
    Constructeur avec paramètre
    @param path pour nom du fichier
    */      
    Fichier(String path){
        filepath = path;        
    }

    /*
    Getteur pour filepath
    @return filepath nom du fichier
    */
    public String getFilepath() {
        return filepath;
    }   
    
    /*
    Setteur pour filepath
    @param filepath pour nom du fichier
    */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }  
    
    /*
    Methode lire pour prendre le fichier pgm/ppm et placer chaque pixel dans un
    tableau approprié
    @param file pour fichier
    @param img pour l'image
    */
    public void lire(Fichier file, Image img) throws IOException {
        
        FileInputStream fStream = new FileInputStream(file.getFilepath());
        Scanner scan = new Scanner(fStream);

        // Discard the magic number(ppm ou pgm)
        if (scan.nextLine()=="P3")
        {
           img.setFormatImage(".ppm");
        }
        else
        {
            img.setFormatImage(".pgm");
        }
        // Discard the comment line
        scan.nextLine();
        // Read pic width, height and max value
        img.setLargeure(scan.nextInt());
        img.setHauteure(scan.nextInt());
        img.setDelimiteur(scan.nextInt());

        fStream.close();

        // Now parse the file as binary data
        fStream = new FileInputStream(file.getFilepath());
        DataInputStream dis = new DataInputStream(fStream);

        // look for 4 lines (i.e.: the header) and discard them
        int numnewlines = 3;
        while (numnewlines > 0) {
            char c;
            do {
                c = (char) (dis.readUnsignedByte());
            } while (c != '\n');
            numnewlines--;
        }

        // read the image data       
        img.setMatrice();
        for (int row = 0; row < img.getLargeur()-1; row++) {
            for (int col = 0; col < img.getHauteur()-1; col++) {
                PixelPGM tempP = new PixelPGM();
                tempP.setPixel(dis.readUnsignedByte());
                img.setPixel(row, col, tempP);
                System.out.print(img.getPixel(row, col).getInt()+ " ");
            }
            System.out.println();
        }
    }
    

}
