CREATE DATABASE aluno_Navegador;

USE aluno_Navegador;

CREATE TABLE usuario (
	PRIMARY KEY (id),
    id 			INT NOT NULL,
    
	login 		VARCHAR (70),
    senha 		VARCHAR (20)
);

CREATE TABLE favoritos (
	PRIMARY KEY (id),
    id 			INT NOT NULL,
    
    id_usuario  INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    
    urlsite		VARCHAR (2083)
);
    
CREATE TABLE historico (
	PRIMARY KEY (id),
    id 			INT NOT NULL,
    
    id_usuario  INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    
    urlsite		VARCHAR (2083)
);
