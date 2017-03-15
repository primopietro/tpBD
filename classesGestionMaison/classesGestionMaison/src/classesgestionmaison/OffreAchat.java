/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

/**
 *
 * @author Pietro
 */
public class OffreAchat {

    private int id_offre;
    private Personne acheteur;
    private Maison maison;
    private String date;
    private double valeurOffre;

    public OffreAchat() {
        id_offre=0;
        acheteur = new Personne();
        maison = new Maison();
        date = null;
        valeurOffre = 0;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }


    public Personne getAchteteur() {
        return acheteur;
    }

    public void setAchteteur(Personne achteteur) {
        this.acheteur = achteteur;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValeurOffre() {
        return valeurOffre;
    }

    public void setValeurOffre(double valeurOffre) {
        this.valeurOffre = valeurOffre;
    }


}
