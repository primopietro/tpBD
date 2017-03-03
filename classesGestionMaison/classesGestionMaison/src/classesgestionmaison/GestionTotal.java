/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pietro
 */
public class GestionTotal {
    private GestionProprio proprietaires;
    private GestionCourtier courtiers;
    private GestionProprio proprios;
    
   public GestionTotal(){
         
   }
   public static void initMaisons(GestionMaison maisons) {
       
        try {
            Connection conn = SimpleDataSource.getConnection();
            String query = "SELECT * FROM Maison";
            PreparedStatement st = conn.prepareStatement(query);
       

            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
               Maison maisonTemporaire = new Maison();
               
             maisonTemporaire.setNbImmeuble(resultSet.getInt(2));
             maisonTemporaire.setRue(resultSet.getString(3));
             maisonTemporaire.setAnnee(resultSet.getInt(4));
             maisonTemporaire.setNombreReparations(resultSet.getInt(5));
             maisonTemporaire.setCodePostal(resultSet.getString(6));
             
            String queryVille = "SELECT * FROM Ville";
            PreparedStatement stVille = conn.prepareStatement(queryVille);
            ResultSet resultSetVille = stVille.executeQuery();
            if (resultSetVille.next()) {
                      maisonTemporaire.setVille(resultSetVille.getString(2));
             }
            else{
                maisonTemporaire.setVille("Pas defini");
            }
                 
            maisonTemporaire.setEchauffement(resultSet.getDouble(8));
            maisonTemporaire.setEau(resultSet.getDouble(9));
            maisonTemporaire.setElectricite(resultSet.getDouble(10));
            maisonTemporaire.setAssurance(resultSet.getDouble(11));
            maisonTemporaire.setImpots(resultSet.getDouble(12));
            maisonTemporaire.setDenegeur(resultSet.getDouble(13));
            maisonTemporaire.setEntretienMenager(resultSet.getDouble(14));
            maisons.addMaison(maisonTemporaire);
            maisonTemporaire.show();
            }

            conn.close();

        } catch (SQLException ex) {
        }
   }
   

   public static void addMaison(GestionMaison maisons, Maison maison){
      
       try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO Maison (nbImmeuble,rue,"
                    + "annee,nombreReparations, codePostal,id_ville,echauffement,"
                    + "eau,electricite,assurance,impots,denegeur,"
                    + "entretienMenager)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maison.getNbImmeuble());
            st.setString(2, maison.getRue());
            st.setInt(3, maison.getAnnee());
            st.setInt(4, maison.getNombreReparations());
            st.setString(5, maison.getCodePostal());
            
            
            int nb_ville =0;
            
           String queryVille = "SELECT * FROM Ville WHERE nomVille =?";
            PreparedStatement stVille = conn.prepareStatement(queryVille);
            stVille.setString(1, maison.getville());
            ResultSet resultSetVille = stVille.executeQuery();
            
             stVille.setString(1, maison.getville());
             
             
            if (resultSetVille.next()) {
                     nb_ville = resultSetVille.getInt(1);
             }
            
            st.setInt(6, nb_ville);
            
            
            st.setDouble(7, maison.getEchauffement());
            st.setDouble(8, maison.getEau());
            st.setDouble(9, maison.getElectricite());
            st.setDouble(10, maison.getAssurance());
            st.setDouble(11, maison.getImpots());
            st.setDouble(12, maison.getDenegeur());
            st.setDouble(13, maison.getEntretienMenager());

            try{
                 st.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println(ex);
        }

           
            
            conn.close();

        } catch (SQLException ex) {
        }
   }
}
