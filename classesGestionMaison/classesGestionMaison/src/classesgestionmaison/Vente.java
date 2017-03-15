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
public class Vente {

    private int id_vente;
    private Maison maison;
    private Personne courtier;
    private String dateVente;
    private double prixVente;

    public Vente() {
        id_vente = 0;
        maison = new Maison();
        courtier = new Personne();
        dateVente = null;
        prixVente = 0;
    }

    public Personne getCourtier() {
        return courtier;
    }

    public void setCourtier(Personne courtier) {
        this.courtier = courtier;
    }

    public int getId_Vente() {
        return id_vente;
    }

    public void setId_Vente(int idVente) {
        this.id_vente = idVente;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public void show() {
        System.out.println("idVente : " + id_vente);
        System.out.println("maison : " + maison.getCodePostal());
        System.out.println("courtier : " + courtier.getNom() +" "+ courtier.getPrenom());
        System.out.println("dateVente : " + dateVente);
        System.out.println("prixVente : " + prixVente);

    }

}
