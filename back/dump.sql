drop table if exists users cascade;
drop table if exists files cascade;
drop table if exists folder cascade;

create table users
(
    iduser   serial primary key,
    username varchar(100) not null,
    email    varchar(100) not null unique,
    password varchar(255) not null
);

INSERT INTO users (iduser, username, email, password) VALUES (1, 'alice123', 'alice@example.com', 'password123');
INSERT INTO users (iduser, username, email, password) VALUES (2, 'bob456', 'bob@example.com', 'password456');
INSERT INTO users (iduser, username, email, password) VALUES (3, 'charlie789', 'charlie@example.com', 'password789');
INSERT INTO users (iduser, username, email, password) VALUES (4, 'david321', 'david@example.com', 'password321');
INSERT INTO users (iduser, username, email, password) VALUES (5, 'eve654', 'eve@example.com', 'password654');



CREATE TABLE files (
    idFile          INT PRIMARY KEY,
    name            VARCHAR(50),
    extension       VARCHAR(50),
    uploadDate      VARCHAR(50),
    idUser          INT,
    FOREIGN KEY (idUser) REFERENCES Users(idUser)
);

CREATE TABLE folder (
    idDossier           INT,
    idFile              INT,
    FOREIGN KEY (idDossier) REFERENCES Files(idFile)
    FOREIGN KEY (idFile) REFERENCES Files(idFile)
    PRIMARY KEY (idDossier,idFile)
);

