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
public class Maison {

    public static Maison create() {
        return Maison.create();
    }

    private int nbImmeuble;
private int rue	;
private int annee;
private int nombreReparations;
private String codePostal;
private int id_ville;
private double echauffement;
private double eau;
private double electricite;
private double assurance; 
private double impots;
private double denegeur;
private double entretienMenager;

public Maison(){
     nbImmeuble =0;
 rue	=0;
 annee=0;
 nombreReparations=0;
 codePostal=null;
 id_ville=0;
 echauffement=0;
 eau=0;
 electricite=0;
 assurance=0; 
 impots=0;
denegeur=0;
 entretienMenager=0;
}
    
    public int getNbImmeuble() {
        return nbImmeuble;
    }

    public void setNbImmeuble(int nbImmeuble) {
        this.nbImmeuble = nbImmeuble;
    }

    public int getRue() {
        return rue;
    }

    public void setRue(int rue) {
        this.rue = rue;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNombreReparations() {
        return nombreReparations;
    }

    public void setNombreReparations(int nombreReparations) {
        this.nombreReparations = nombreReparations;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public double getEchauffement() {
        return echauffement;
    }

    public void setEchauffement(double echauffement) {
        this.echauffement = echauffement;
    }

    public double getEau() {
        return eau;
    }

    public void setEau(double eau) {
        this.eau = eau;
    }

    public double getElectricite() {
        return electricite;
    }

    public void setElectricite(double electricite) {
        this.electricite = electricite;
    }

    public double getAssurance() {
        return assurance;
    }

    public void setAssurance(double assurance) {
        this.assurance = assurance;
    }

    public double getImpots() {
        return impots;
    }

    public void setImpots(double impots) {
        this.impots = impots;
    }

    public double getDenegeur() {
        return denegeur;
    }

    public void setDenegeur(double denegeur) {
        this.denegeur = denegeur;
    }

    public double getEntretienMenager() {
        return entretienMenager;
    }

    public void setEntretienMenager(double entretienMenager) {
        this.entretienMenager = entretienMenager;
    }
   
}
