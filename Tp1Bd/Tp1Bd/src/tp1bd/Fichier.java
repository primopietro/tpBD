/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1bd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Constructeur avec paramètre
     *
     * @param path pour nom du fichier
     */
    Fichier(String path) {
        filepath = path;
    }

    /**
     * Getteur pour filepath
     *
     * @return filepath nom du fichier
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * Setteur pour filepath
     *
     * @param filepath pour nom du fichier
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Methode lire pour prendre le fichier pgm/ppm et placer chaque pixel dans
     * un tableau approprié
     *
     * @param file pour fichier
     * @param img pour l'image
     */
    public void lire(Fichier file, Image img) throws IOException {
        try (Scanner scan = new Scanner(new FileReader(file.getFilepath()))) {
            // Lit magicnumber(ppm ou pgm)

            if ("P3".equals(scan.nextLine())) {
                img.setFormatImage(".ppm");
            } else {
                img.setFormatImage(".pgm");
            }
            // lit la largeur, hauteur et max value
            img.setLargeur(scan.nextInt());
            img.setHauteur(scan.nextInt());
            img.setDelimiteur(scan.nextInt());

            //si pgm
            if (img.getFormatImage() == ".pgm") {
                while (scan.hasNext()) {
                    img.setMatrice();
                    for (int row = 0; row < img.getHauteur(); row++) {
                        for (int col = 0; col < img.getLargeur(); col++) {

                            PixelPGM tempP = new PixelPGM();
                            tempP.setPixel(scan.nextInt());
                            img.setPixel(col, row, tempP);
                        }
                    }
                }
            } //si ppm
            else {
                while (scan.hasNext()) {
                    img.setMatrice();

                    for (int row = 0; row < img.getHauteur(); row++) {
                        for (int col = 0; col < img.getLargeur(); col++) {
                            PixelPPM tempP = new PixelPPM();
                            //place les 3 int dans un pixelppm
                            for (int i = 0; i < 3; i++) {
                                tempP.setPixel(i, scan.nextInt());
                            }
                            //set pixel
                            img.setPixel(col, row, tempP);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sauvegarde l'image dans un nouveau fichier PGM ou PPM
     *
     * @param image
     * @param fichier
     */
    public void ecrire(Image img, Fichier file) throws IOException {

        PrintWriter writer = new PrintWriter(new File("sortie" + file.getFilepath()));
        // Lit magicnumber(ppm ou pgm)
        if (img.getFormatImage() == ".ppm") {
            writer.println("P3");
        } else {
            writer.println("P2");
        }
        // lit la largeur, hauteur et max value
        writer.println(img.getLargeur() + " " + img.getHauteur());
        writer.println(img.getDelimiteur());

        //si pgm
        if (img.getFormatImage() == ".pgm") {

            for (int row = 0; row < img.getHauteur(); row++) {
                for (int col = 0; col < img.getLargeur(); col++) {
                    writer.print(img.getPixel(col, row).getInt(0) + " ");
                }
                writer.println(""); //saut de ligne
            }
        } //si ppm
        else {
            for (int row = 0; row < img.getHauteur(); row++) {
                for (int col = 0; col < img.getLargeur(); col++) {
                    //place les 3 int dans un pixelppm
                    for (int i = 0; i < 3; i++) {
                        writer.print(img.getPixel(col, row).getInt(i) + " ");
                    }
                }
                writer.println(""); //saut de ligne
            }

        }
        writer.flush();
        writer.close();
    }

}
