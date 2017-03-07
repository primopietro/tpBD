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
public class Personne {
    private int id_personne;
private String nom;				
private String prenom;				
private int telephone;			
private boolean acheteur;			
private boolean proprietaire;                   
private boolean courtier;	

    public Personne() {
  nom = null;				
  prenom = null;				
  telephone = 0;			
  acheteur = false;			
  proprietaire  = false;                   
  courtier  = false;
    }
    
    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public boolean isAcheteur() {
        return acheteur;
    }

    public void setAcheteur(boolean acheteur) {
        this.acheteur = acheteur;
    }

    public boolean isProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(boolean proprietaire) {
        this.proprietaire = proprietaire;
    }

    public boolean isCourtier() {
        return courtier;
    }

    public void setCourtier(boolean courtier) {
        this.courtier = courtier;
    }

    public void show(){
       System.out.println("nom :" + nom);			
   System.out.println("prenom :" + prenom); 				
   System.out.println("telephone :" + telephone); 		
   System.out.println("acheteur :" + acheteur); 			
   System.out.println("proprietaire :" + proprietaire);                    
   System.out.println("courtier :" + courtier);  
    }


}
