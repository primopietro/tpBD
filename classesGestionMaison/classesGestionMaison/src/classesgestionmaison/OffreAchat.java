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
  private Courtier courtier;
    private Acheteur achteteur;
    private Maison maison;
    private String date;
    private double valeurOffre;
    public OffreAchat(){
        courtier = new Courtier();
        achteteur = new Acheteur();
        maison = new Maison();
        date = null;
        valeurOffre =0;
        
    }
    public Courtier getCourtier() {
        return courtier;
    }

    public void setCourtier(Courtier courtier) {
        this.courtier = courtier;
    }

    public Acheteur getAchteteur() {
        return achteteur;
    }

    public void setAchteteur(Acheteur achteteur) {
        this.achteteur = achteteur;
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
