CREATE TABLE Province(
id_province			CHAR(2) NOT NULL, 
nomProvince			VARCHAR(50) UNIQUE NOT NULL,

CONSTRAINT provincePK PRIMARY KEY(id_province)														   
);

CREATE TABLE Ville(
id_ville			INTEGER NOT NULL,
nomVille			VARCHAR(50) UNIQUE NOT NULL,
id_province			CHAR(2) NOT NULL, 
    
CONSTRAINT provinceFK FOREIGN KEY(id_province) REFERENCES Province(id_province),
CONSTRAINT villePK PRIMARY KEY(id_ville)
);

CREATE TABLE Personne(
id_personne			INTEGER NOT NULL,
nom				VARCHAR(20) NOT NULL,
prenom				VARCHAR(20) NOT NULL,
telephone			INTEGER,
acheteur			BOOLEAN NOT NULL,
proprietaire                    BOOLEAN NOT NULL,
courtier			BOOLEAN NOT NULL,

CONSTRAINT personnePK PRIMARY KEY(id_personne)
);

CREATE TABLE Maison(
id_maison			INTEGER NOT NULL,
nbImmeuble              	INTEGER NOT NULL,
rue				VARCHAR(50) NOT NULL,
annee                       	SMALLINT,
nombreReparations               SMALLINT,
codePostal			CHAR(6) UNIQUE NOT NULL,
id_ville			INTEGER NOT NULL, 
echauffement                    NUMERIC(8,2) NOT NULL,
eau				NUMERIC(8,2) NOT NULL,
electricite			NUMERIC(8,2) NOT NULL, 
assurance			NUMERIC(8,2) NOT NULL, 
impots				NUMERIC(8,2) NOT NULL, 
denegeur			NUMERIC(8,2) NOT NULL,
entretienMenager                NUMERIC(8,2) NOT NULL,

CONSTRAINT villeFK FOREIGN KEY(id_ville) REFERENCES Ville(id_ville),
CONSTRAINT maisonPK PRIMARY KEY(id_maison)
);

CREATE TABLE Location(
id_location			INTEGER NOT NULL,
id_maison			INTEGER NOT NULL,
id_locateur			INTEGER NOT NULL,
dateLocation                    DATE,
dateRetour			DATE,
prixLocation                    NUMERIC(12,2) NOT NULL,
quantiteMois                    SMALLINT,

CONSTRAINT maisonFK FOREIGN KEY(id_maison) REFERENCES Maison(id_maison),
CONSTRAINT locateurFK FOREIGN KEY(id_locateur) REFERENCES Personne(id_personne),
CONSTRAINT locationPK PRIMARY KEY(id_location)
);

CREATE TABLE Vente(
id_vente			INTEGER NOT NULL,
id_maison			INTEGER NOT NULL,
id_courtier			INTEGER NOT NULL,
dateVente			DATE,
prixAchat			NUMERIC(12,2) NOT NULL,

CONSTRAINT maisonFK FOREIGN KEY(id_maison) REFERENCES Maison(id_maison),
CONSTRAINT courtierFK FOREIGN KEY(id_courtier) REFERENCES Personne(id_personne),
CONSTRAINT locationPK PRIMARY KEY(id_vente)
);

CREATE TABLE OffreAchat(
id_offreAchat                   INTEGER NOT NULL,
id_acheteur			INTEGER NOT NULL,
id_maison			INTEGER NOT NULL,
dateOffre			DATE,
valeurOffre		 	NUMERIC(12,2) NOT NULL,

CONSTRAINT maisonFK FOREIGN KEY(id_maison) REFERENCES Maison(id_maison),
CONSTRAINT acheteurFK FOREIGN KEY(id_acheteur) REFERENCES Personne(id_personne),
CONSTRAINT offreAchatPK PRIMARY KEY(id_offreAchat)
);

CREATE TABLE Proprietaire(
id_proprietaire                 INTEGER NOT NULL,
id_maison			INTEGER NOT NULL,
id_personne			INTEGER NOT NULL,
montantPropriete                NUMERIC(12,2) NOT NULL,

CONSTRAINT maisonFK FOREIGN KEY(id_maison) REFERENCES Maison(id_maison),
CONSTRAINT personneFK FOREIGN KEY(id_personne) REFERENCES Personne(id_personne),
CONSTRAINT proprietairePK PRIMARY KEY(id_proprietaire)
);