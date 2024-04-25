CREATE TABLE Kino(
                     ID INTEGER NOT NULL AUTO_INCREMENT,
                     antall INTEGER NOT NULL ,
                     telefon INTEGER NOT NULL ,
                     film VARCHAR(255) NOT NULL ,
                     fornavn VARCHAR(255) NOT NULL ,
                     etternavn VARCHAR(255) NOT NULL ,
                     epost VARCHAR(255) NOT NULL ,
                     PRIMARY KEY (ID)
);