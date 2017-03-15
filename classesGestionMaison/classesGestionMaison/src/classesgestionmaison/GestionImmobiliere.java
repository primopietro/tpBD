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
public class GestionImmobiliere {

    public static void initMaisons(GestionMaison maisons) {

        try {
            Connection conn = SimpleDataSource.getConnection();
            String query = "SELECT * FROM Maison";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Maison maisonTemporaire = new Maison();

                maisonTemporaire.setId_maison(resultSet.getInt(1));
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
                } else {
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

    public static void addMaison(GestionMaison maisons, Maison maison) {

        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO Maison (nbImmeuble,rue,"
                    + "annee,nombreReparations, codePostal,id_ville,echauffement,"
                    + "eau,electricite,assurance,impots,denegeur,"
                    + "entretienMenager)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maison.getNbImmeuble());
            st.setString(2, maison.getRue());
            st.setInt(3, maison.getAnnee());
            st.setInt(4, maison.getNombreReparations());
            st.setString(5, maison.getCodePostal());

            int nb_ville = 0;

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
            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();
            maison.setId_maison(maisons.getIdLastMaison() + 1);
            maisons.addMaison(maison);

        } catch (SQLException ex) {
        }
    }

    public static void removeMaison(GestionMaison maisons, int indiceMaison,
            GestionOffres offres, GestionLocation locations, GestionVentes ventes) {
        try {
            String tempCodePostal = maisons.getMaison(indiceMaison).getCodePostal();

            Connection conn = SimpleDataSource.getConnection();
            String query = "DELETE FROM Maison "
                    + "WHERE codePostal = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, tempCodePostal);

            try {
                st.executeUpdate();
                for (int i = 0; i < offres.getSizeOffres(); i++) {
                    if (tempCodePostal == offres.getOffre(i).getMaison().getCodePostal()) {
                        offres.removeOffre(i);
                        i--;
                    }
                }
                for (int i = 0; i < ventes.getSizeVentes(); i++) {
                    if (tempCodePostal == ventes.getVente(i).getMaison().getCodePostal()) {
                        ventes.removeVente(i);
                        i--;
                    }
                }
                for (int i = 0; i < locations.getSizeLocation(); i++) {
                    if (tempCodePostal == locations.getLocation(i).getMaison().getCodePostal()) {
                        offres.removeOffre(i);
                        i--;
                    }
                }

                maisons.removeMaison(indiceMaison);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void modifierMaison(GestionMaison maisons, int indiceMaison,
            Maison nouvelleMaison) {
        //Update BD

        int id_maison = 0;

        try {

            Connection conn = SimpleDataSource.getConnection();

            //Get id maison a changer 
            //Get maison a changer
            Maison maisonaChanger = maisons.getMaison(indiceMaison);

            String queryId = "SELECT * "
                    + "FROM `Maison`"
                    + "WHERE `codePostal` = ?";
            PreparedStatement stId = conn.prepareStatement(queryId);
            stId.setString(1, maisons.getMaison(indiceMaison).getCodePostal());

            try {
                ResultSet resultSetId = stId.executeQuery();
                if (resultSetId.next()) {
                    id_maison = resultSetId.getInt(1);
                }
            } catch (Exception ex) {
                System.out.print(ex);
            }

            String query = "UPDATE Maison "
                    + "SET nbImmeuble = ? , rue=?, annee = ?,nombreReparations = ?"
                    + ",codePostal = ?,id_ville= ?,echauffement=  ?,eau=?,"
                    + "electricite = ?,assurance = ?,impots= ?,denegeur= ?,"
                    + "entretienMenager= ?"
                    + "WHERE id_maison = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, nouvelleMaison.getNbImmeuble());
            st.setString(2, nouvelleMaison.getRue());
            st.setInt(3, nouvelleMaison.getAnnee());
            st.setInt(4, nouvelleMaison.getNombreReparations());
            st.setString(5, nouvelleMaison.getCodePostal());

            int nb_ville = 0;

            String queryVille = "SELECT * FROM Ville WHERE nomVille =?";
            PreparedStatement stVille = conn.prepareStatement(queryVille);
            stVille.setString(1, nouvelleMaison.getville());
            ResultSet resultSetVille = stVille.executeQuery();

            stVille.setString(1, nouvelleMaison.getville());

            if (resultSetVille.next()) {
                nb_ville = resultSetVille.getInt(1);
            }

            st.setInt(6, nb_ville);

            st.setDouble(7, nouvelleMaison.getEchauffement());
            st.setDouble(8, nouvelleMaison.getEau());
            st.setDouble(9, nouvelleMaison.getElectricite());
            st.setDouble(10, nouvelleMaison.getAssurance());
            st.setDouble(11, nouvelleMaison.getImpots());
            st.setDouble(12, nouvelleMaison.getDenegeur());
            st.setDouble(13, nouvelleMaison.getEntretienMenager());

            st.setInt(14, id_maison);
            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }

        //Modifie maisons dans la liste de maisons
        maisons.modifierMaison(nouvelleMaison, indiceMaison);
    }

    public static void initPersonnes(GestionPersonnes personnes) {

        try {
            Connection conn = SimpleDataSource.getConnection();
            String query = "SELECT * FROM Personne";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Personne personneTemporaire = new Personne();

                personneTemporaire.setId_personne(resultSet.getInt(1));
                personneTemporaire.setNom(resultSet.getString(2));
                personneTemporaire.setPrenom(resultSet.getString(3));
                personneTemporaire.setTelephone(resultSet.getInt(4));
                personneTemporaire.setAcheteur(resultSet.getBoolean(5));
                personneTemporaire.setProprietaire(resultSet.getBoolean(6));
                personneTemporaire.setCourtier(resultSet.getBoolean(7));

                personnes.addPersonne(personneTemporaire);
                personneTemporaire.show();
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void addPersonne(GestionPersonnes personnes,
            Personne personne) {

        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO Personne (nom,prenom,"
                    + "telephone,acheteur, proprietaire,courtier)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, personne.getNom());
            st.setString(2, personne.getPrenom());
            st.setInt(3, personne.getTelephone());
            st.setBoolean(4, personne.isAcheteur());
            st.setBoolean(5, personne.isProprietaire());
            st.setBoolean(6, personne.isCourtier());

            try {
                st.executeUpdate();
                personne.setId_personne(personnes.getIdLastPersonne() + 1);
                personnes.addPersonne(personne);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void removePersonne(GestionPersonnes personnes,
            int indicePersonne, GestionOffres offres,
            GestionLocation locations, GestionVentes ventes) {
        try {

            int idPersonne = personnes.getPersonne(indicePersonne).getId_personne();
            Connection conn = SimpleDataSource.getConnection();
            String query = "DELETE FROM Personne "
                    + "WHERE id_personne = ? ";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idPersonne);

            try {
                st.executeUpdate();
                for (int i = 0; i < offres.getSizeOffres(); i++) {
                    if (idPersonne == offres.getOffre(i).getAchteteur().getId_personne()) {
                        offres.removeOffre(i);
                        i--;
                    }
                }
                for (int i = 0; i < ventes.getSizeVentes(); i++) {
                    if (idPersonne == ventes.getVente(i).getCourtier().getId_personne()) {
                        ventes.removeVente(i);
                        i--;
                    }
                }
                for (int i = 0; i < locations.getSizeLocation(); i++) {
                    if (idPersonne == locations.getLocation(i).getLocateur().getId_personne()) {
                        offres.removeOffre(i);
                        i--;
                    }
                }

                personnes.removePersonne(indicePersonne);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void modifierPersonne(GestionPersonnes personnes,
            Personne nouvellePersonne,
            int indicePersonne) {
        //Update BD

        int id_personne = 0;

        try {

            Connection conn = SimpleDataSource.getConnection();

            //Get id maison a changer 
            //Get maison a changer
            Personne personneAchanger = personnes.getPersonne(indicePersonne);

            String queryId = "SELECT * "
                    + "FROM `Maison`"
                    + "WHERE `nom` = ?,`prenom` = ?, `telephone` = ? ";
            PreparedStatement stId = conn.prepareStatement(queryId);
            stId.setString(1, personnes.getPersonne(indicePersonne).getNom());
            stId.setString(2, personnes.getPersonne(indicePersonne).getPrenom());
            stId.setInt(3, personnes.getPersonne(indicePersonne).getTelephone());
            try {
                ResultSet resultSetId = stId.executeQuery();
                if (resultSetId.next()) {
                    id_personne = resultSetId.getInt(1);
                }
            } catch (Exception ex) {
                System.out.print(ex);
            }

            String query = "UPDATE Personne "
                    + "SET nom = ? , prenom=?, telephone = ?,acheteur = ?"
                    + ",proprietaire = ?,courtier= ?"
                    + "WHERE id_personne = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, nouvellePersonne.getNom());
            st.setString(2, nouvellePersonne.getPrenom());
            st.setInt(3, nouvellePersonne.getTelephone());
            st.setBoolean(4, nouvellePersonne.isAcheteur());
            st.setBoolean(5, nouvellePersonne.isProprietaire());
            st.setBoolean(6, nouvellePersonne.isCourtier());

            st.setInt(7, id_personne);
            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }

        //Modifie maisons dans la liste de maisons
        personnes.modifierPersonne(nouvellePersonne, indicePersonne);
    }

    public static void initLocations(GestionLocation locations,
            GestionPersonnes personnes, GestionMaison maisons) {

        try {
            Connection conn = SimpleDataSource.getConnection();
            //Selectionne tous 
            String query = "SELECT * FROM Location";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Location locationTemporaire = new Location();
                int id_personne = 0;
                int id_maison = 0;

                locationTemporaire.setId_location(resultSet.getInt(1));

                id_maison = resultSet.getInt(2);

                locationTemporaire.setMaison(maisons.getMaisonById(id_maison));

                id_personne = resultSet.getInt(3);
                locationTemporaire.setLocateur(personnes.getPersonneById(id_personne));

                locationTemporaire.setDateLocation(resultSet.getString(4));
                locationTemporaire.setDateRetour(resultSet.getString(5));
                locationTemporaire.setPrixLocation(resultSet.getDouble(6));
                locationTemporaire.setMoisLocation(resultSet.getInt(7));

                locations.addLocation(locationTemporaire);
                locationTemporaire.show();
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void addLocation(GestionLocation locations,
            Location location) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO Location (id_maison, id_locateur,"
                    + "dateLocation, dateRetour, prixLocation, quantiteMois)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, location.getMaison().getId_maison());
            st.setInt(2, location.getLocateur().getId_personne());
            st.setString(3, location.getDateLocation());
            st.setString(4, location.getDateRetour());
            st.setDouble(5, location.getPrixLocation());
            st.setDouble(6, location.getMoisLocation());

            try {
                st.executeUpdate();
                location.setId_location(locations.getIdLastLocation() + 1);
                locations.addLocation(location);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void modifierLocation(GestionLocation locations,
            Location nouvelleLocation, int indiceLocation) {

        try {

            Connection conn = SimpleDataSource.getConnection();

            String query = "UPDATE Location "
                    + "SET id_maison = ? , id_locateur=?, "
                    + "dateLocation = ?, dateRetour = ? ,"
                    + "prixLocation = ?, quantiteMois= ? "
                    + "WHERE id_location  = ? ";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, nouvelleLocation.getMaison().getId_maison());
            st.setInt(2, nouvelleLocation.getLocateur().getId_personne());
            st.setString(3, nouvelleLocation.getDateLocation());
            st.setString(4, nouvelleLocation.getDateRetour());
            st.setDouble(5, nouvelleLocation.getPrixLocation());
            st.setInt(6, nouvelleLocation.getMoisLocation());
            st.setInt(7, locations.getLocation(indiceLocation).getId_location());

            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }

        //Modifie maisons dans la liste de maisons
        locations.modifierLocation(nouvelleLocation, indiceLocation);
    }

    public static void removeLocation(GestionLocation locations, int indiceLocation) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "DELETE FROM Location "
                    + "WHERE id_location = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, locations.getLocation(indiceLocation).getId_location());

            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            locations.removeLocation(indiceLocation);
            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void initVentes(GestionVentes ventes,
            GestionPersonnes personnes, GestionMaison maisons) {

        try {
            Connection conn = SimpleDataSource.getConnection();
            //Selectionne tous les ventes
            String query = "SELECT * FROM Vente";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Vente venteTemporaire = new Vente();
                int id_personne = 0;
                int id_maison = 0;

                venteTemporaire.setId_Vente(resultSet.getInt(1));

                id_maison = resultSet.getInt(2);

                venteTemporaire.setMaison(maisons.getMaisonById(id_maison));

                id_personne = resultSet.getInt(3);
                venteTemporaire.setCourtier(personnes.getPersonneById(id_personne));

                venteTemporaire.setDateVente(resultSet.getString(4));
                venteTemporaire.setPrixVente(resultSet.getDouble(5));

                ventes.addVente(venteTemporaire);
                venteTemporaire.show();
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void addVente(GestionVentes ventes,
            Vente vente) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO Vente (id_maison, id_courtier,"
                    + "dateVente, prixAchat)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, vente.getMaison().getId_maison());
            st.setInt(2, vente.getCourtier().getId_personne());
            st.setString(3, vente.getDateVente());
            st.setDouble(4, vente.getPrixVente());

            try {
                st.executeUpdate();
                vente.setId_Vente(ventes.getIdLastVente() + 1);
                ventes.addVente(vente);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void modifierVente(GestionVentes ventes,
            Vente nouvelleVente, int indiceVente) {

        try {

            Connection conn = SimpleDataSource.getConnection();

            String query = "UPDATE Vente "
                    + "SET id_maison = ? , id_courtier=?, "
                    + "dateVente = ?, prixAchat = ?  "
                    + "WHERE id_vente  = ? ";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, nouvelleVente.getMaison().getId_maison());
            st.setInt(2, nouvelleVente.getCourtier().getId_personne());
            st.setString(3, nouvelleVente.getDateVente());
            st.setDouble(4, nouvelleVente.getPrixVente());
            st.setInt(5, ventes.getVente(indiceVente).getId_Vente());
            try {
                st.executeUpdate();
                nouvelleVente.setId_Vente(ventes.getVente(indiceVente).getId_Vente());
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }

        //Modifie maisons dans la liste de maisons
        ventes.modifierVente(nouvelleVente, indiceVente);
    }

    public static void removeVente(GestionVentes ventes, int indiceVente) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "DELETE FROM Vente "
                    + "WHERE id_vente = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, ventes.getVente(indiceVente).getId_Vente());

            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            ventes.removeVente(indiceVente);
            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void initOffresAchat(GestionOffres offres,
            GestionPersonnes personnes, GestionMaison maisons) {

        try {
            Connection conn = SimpleDataSource.getConnection();
            //Selectionne tous les ventes
            String query = "SELECT * FROM offreachat";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                OffreAchat offreTemporaire = new OffreAchat();
                int id_personne = 0;
                int id_maison = 0;

                offreTemporaire.setId_offre(resultSet.getInt(1));

                id_maison = resultSet.getInt(2);

                offreTemporaire.setMaison(maisons.getMaisonById(id_maison));

                id_personne = resultSet.getInt(3);
                offreTemporaire.setAchteteur(personnes.getPersonneById(id_personne));

                offreTemporaire.setDate(resultSet.getString(4));
                offreTemporaire.setValeurOffre(resultSet.getDouble(5));

                offres.addOffre(offreTemporaire);

            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void addOffreAchat(GestionOffres offres,
            OffreAchat offreAchat) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "INSERT INTO offreachat (id_maison, id_acheteur,"
                    + "dateOffre, valeurOffre)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, offreAchat.getMaison().getId_maison());
            st.setInt(2, offreAchat.getAchteteur().getId_personne());
            st.setString(3, offreAchat.getDate());
            st.setDouble(4, offreAchat.getValeurOffre());

            try {
                st.executeUpdate();
                offreAchat.setId_offre(offres.getIdLastOffre() + 1);

                offres.addOffre(offreAchat);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }
    }

    public static void modifierOffreAchat(GestionOffres offres,
            OffreAchat nouvelleOffreAchat, int indiceOffre) {

        try {

            Connection conn = SimpleDataSource.getConnection();

            String query = "UPDATE offreachat "
                    + "SET id_maison = ? , id_acheteur=?, "
                    + "dateOffre = ?, valeurOffre = ?  "
                    + "WHERE id_offreAchat  = ? ";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, nouvelleOffreAchat.getMaison().getId_maison());
            st.setInt(2, nouvelleOffreAchat.getAchteteur().getId_personne());
            st.setString(3, nouvelleOffreAchat.getDate());
            st.setDouble(4, nouvelleOffreAchat.getValeurOffre());
            st.setInt(5, offres.getOffre(indiceOffre).getId_offre());

            try {
                st.executeUpdate();
                nouvelleOffreAchat.setId_offre(offres.getOffre(indiceOffre).getId_offre());
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            conn.close();

        } catch (SQLException ex) {
        }

        //Modifie maisons dans la liste de maisons
        offres.modifierOffre(nouvelleOffreAchat, indiceOffre);
    }

    public static void removeOffre(GestionOffres offres, int indiceOffre) {
        try {

            Connection conn = SimpleDataSource.getConnection();
            String query = "DELETE FROM offreachat "
                    + "WHERE id_offreAchat = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, offres.getOffre(indiceOffre).getId_offre());

            try {
                st.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            offres.removeOffre(indiceOffre);
            conn.close();

        } catch (SQLException ex) {
        }
    }
}
