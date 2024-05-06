CREATE DATABASE java_lez03_paninoteca;
USE java_lez03_paninoteca;

CREATE TABLE Panino(
	paninoID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    codice VARCHAR(50) NOT NULL UNIQUE,
    descrizione TEXT,
    prezzo FLOAT CHECK (prezzo >= 0),
    isvegan BOOLEAN NOT NULL
);

INSERT INTO Panino(nome, codice, descrizione, prezzo, isvegan) VALUES
("Il romano", "MT1234", "Prova di descrizione", 10.0, FALSE),
("Il livornese", "MT1235", "Prova di descrizione panino VEG", 20.0, TRUE);

SELECT * FROM Panino;