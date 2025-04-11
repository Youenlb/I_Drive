drop table if exists users cascade;
drop table if exists files cascade;
drop table if exists folder cascade;

create table users
(
    idUser   serial primary key,
    username varchar(100) not null,
    email    varchar(100) not null unique,
    password varchar(255) not null
);



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
                        FOREIGN KEY (idDossier) REFERENCES Files(idFile),
                        FOREIGN KEY (idFile) REFERENCES Files(idFile),
                        PRIMARY KEY (idDossier,idFile)
);

