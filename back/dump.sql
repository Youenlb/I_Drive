CREATE TABLE users (
                       id_user INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(1000) NOT NULL,
                       is_admin BOOLEAN DEFAULT FALSE,
                       is_suspended BOOLEAN DEFAULT FALSE
);


CREATE TABLE teams (
                       id_team INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       games_won INT NOT NULL
);

CREATE TABLE themes (
                        id_theme INT PRIMARY KEY AUTO_INCREMENT,
                        theme VARCHAR(255) NOT NULL
);

CREATE TABLE questions (
                           id_question INT PRIMARY KEY AUTO_INCREMENT,
                           question VARCHAR(255) NOT NULL,
                           difficulty_question INT NOT NULL,
                           id_theme INT NOT NULL,
                           FOREIGN KEY (id_theme) REFERENCES themes(id_theme)
);

CREATE TABLE answers (
                         id_answer INT PRIMARY KEY AUTO_INCREMENT,
                         answer VARCHAR(1000) NOT NULL,
                         correct BOOLEAN NOT NULL,
                         id_question INT NOT NULL,
                         FOREIGN KEY (id_question) REFERENCES questions(id_question)
);

CREATE TABLE played_games_solo (
                                   id_game_played INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                   id_user INT NOT NULL,
                                   FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE played_games_info (
                                   id_game_played INT NOT NULL,
                                   difficulty INT NOT NULL,
                                   nb_questions INT NOT NULL,
                                   score INT NOT NULL,
                                   PRIMARY KEY (id_game_played, difficulty),
                                   FOREIGN KEY (id_game_played) REFERENCES played_games_solo(id_game_played)
);


CREATE TABLE played_games_themes (
                                     id_game_played INT NOT NULL,
                                     id_theme INT NOT NULL,
                                     PRIMARY KEY (id_game_played, id_theme),
                                     FOREIGN KEY (id_game_played) REFERENCES played_games_info(id_game_played),
                                     FOREIGN KEY (id_theme) REFERENCES themes(id_theme)
);


-- Insert data into USERS table
INSERT INTO users (username, password, is_suspended, is_admin) VALUES
('user1', 'password1', FALSE, TRUE),
('user2', 'password2', TRUE, FALSE),
('user3', 'password3', FALSE, FALSE),
('user4', 'password4', FALSE, FALSE),
('user5', 'password5', FALSE, FALSE);



INSERT INTO played_games_solo (id_user) VALUES
(1), -- User 1
(2), -- User 2
(3), -- User 3
(1), -- User 1 (new game)
(2), -- User 2 (new game)
(3), -- User 3 (new game)
(1), -- User 1 (new game)
(4), -- User 4
(5), -- User 5
(1), -- User 1 (new game)
(2), -- User 2 (new game)
(4), -- User 4 (new game)
(5), -- User 5 (new game)
(3), -- User 3 (new game)
(4), -- User 4 (new game)
(2); -- User 2 (new game)


INSERT INTO played_games_info (id_game_played, difficulty, nb_questions, score) VALUES
(1, 1, 5, 2), -- Game 1: User 1, difficulty 1, 5 questions, 2 correct
(2, 2, 4, 3), -- Game 2: User 2, difficulty 2, 4 questions, 3 correct
(3, 3, 6, 4), -- Game 3: User 3, difficulty 3, 6 questions, 4 correct
(4, 1, 10, 8), -- Game 4: User 1, difficulty 1, 10 questions, 8 correct
(5, 2, 7, 5), -- Game 5: User 2, difficulty 2, 7 questions, 5 correct
(6, 3, 6, 1), -- Game 6: User 3, difficulty 3, 6 questions, 1 correct
(7, 1, 8, 7), -- Game 7: User 1, difficulty 1, 8 questions, 7 correct
(8, 2, 5, 3), -- Game 8: User 4, difficulty 2, 5 questions, 3 correct
(9, 3, 4, 2), -- Game 9: User 5, difficulty 3, 4 questions, 2 correct
(10, 1, 12, 9), -- Game 10: User 1, difficulty 1, 12 questions, 9 correct
(11, 2, 9, 6), -- Game 11: User 2, difficulty 2, 9 questions, 6 correct
(12, 3, 15, 12), -- Game 12: User 4, difficulty 3, 15 questions, 12 correct
(13, 1, 8, 4), -- Game 13: User 5, difficulty 1, 8 questions, 4 correct
(14, 2, 6, 4), -- Game 14: User 3, difficulty 2, 6 questions, 4 correct
(15, 3, 10, 7), -- Game 15: User 4, difficulty 3, 10 questions, 7 correct
(16, 1, 20, 15); -- Game 16: User 2, difficulty 1, 20 questions, 15 correct




-- Insert data into TEAMS table
INSERT INTO teams (name, games_won) VALUES
('Team Alpha', 2),
('Team Bravo', 1),
('Team Charlie', 0);


-- Insert data into THEMES table
INSERT INTO themes (theme) VALUES
('Mathématiques'),
('Science'),
('Histoire'),
('Géographie');


INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelle est la somme de 5 et 3?', 1, 1),
('Quelle est la racine carrée exacte de 16?', 1, 1),
('Résolvez pour x: 3x = 9.', 1, 1),
('Quelle est la moitié exacte de 20?', 1, 1),
('Calculez : 3 × 3.', 1, 1),
('Que vaut 7 + 2?', 1, 1),
('Quel est le résultat de 12 divisé par 3?', 1, 1),
('Que vaut 10 moins 4?', 1, 1);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quel est le carré parfait de 5?', 2, 1),
('Calculez : 15 ÷ 3.', 2, 1),
('Quel est le cube de 2?', 2, 1),
('Effectuez le calcul : 9 × 8.', 2, 1),
('Quelle est la racine carrée de 81?', 2, 1);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quel est 25% de 200?', 3, 1),
('Quels sont les facteurs de 4?', 3, 1),
('Résolvez pour x: 2x + 5 = 15.', 3, 1),
('Quelle est la dérivée de la fonction x²?', 3, 1),
('Quelle est la somme des angles dans un triangle?', 3, 1);


INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelle est l\'intégrale de x² dx?', 4, 1),
('Résolvez pour x : 3x² - 5x + 2 = 0.', 4, 1),
('Quel est le produit des racines de l\'équation 2x² + 3x - 5 = 0?', 4, 1),
('Calculez la limite de (x² - 1)/(x - 1) lorsque x tend vers 1.', 4, 1),
('Quelle est la dérivée de sin(x)?', 4, 1);


-- SCIENCES
INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('À quelle température l\'eau bout-elle en degrés Celsius?', 1, 2),
('Quelle planète est surnommée la "Planète rouge"?', 1, 2),
('À combien de degrés Celsius l\'eau gèle-t-elle?', 1, 2),
('Quelle est l\'étoile la plus proche de la Terre?', 1, 2),
('Quelle est l\'étoile la plus brillante dans le ciel nocturne?', 1, 2);


INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('À quelle température l\'eau bout-elle en degrés Fahrenheit?', 2, 2),
('Quelle est la planète la plus proche du Soleil?', 2, 2),
('Quelle est la plus grande planète du système solaire?', 2, 2),
('Quelle est la planète la plus éloignée du Soleil dans le système solaire?', 2, 2),
('Quelle planète est surnommée la "Planète bleue"?', 2, 2);


INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelle est la vitesse de la lumière en m/s?', 3, 2),
('Quelle est la température de fusion de l\'or en °C?', 3, 2),
('À quelle température le fer fond-il?', 3, 2),
('Quel métal fond à 327,5 °C?', 3, 2),
('Quelle est la température de fusion du cuivre?', 3, 2);


INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelle est l\'équation qui relie l\'énergie, la masse et la vitesse de la lumière?', 4, 2),
('Quel est le nom de la particule associée à la force électromagnétique?', 4, 2),
('Quelle est la constante gravitationnelle universelle (G)?', 4, 2),
('Quelle est l\'équation de Schrödinger?', 4, 2),
('Qu\'est-ce que l\'entropie en thermodynamique?', 4, 2);

-- HISTOIRE
INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Qui a rédigé la Déclaration d\'indépendance des États-Unis?', 1, 3),
('En quelle année s\'est terminée la Seconde Guerre mondiale?', 1, 3),
('Quelle ville est la capitale de la France?', 1, 3),
('Sur quel continent trouve-t-on le désert du Sahara?', 1, 3),
('Qui a peint La Joconde?', 1, 3);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Qui fut le premier président des États-Unis?', 2, 3),
('Qui est considéré comme le premier empereur romain?', 2, 3),
('Quel roi a été couronné comme premier roi de France?', 2, 3),
('Quel empereur a unifié la Chine sous la dynastie Qin?', 2, 3),
('Qui fut le premier roi d\'Angleterre?', 2, 3);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quels sont les accomplissements de Qin Shi Huang, le premier empereur chinois?', 3, 3),
('Quel tsar a été proclamé le premier empereur de Russie?', 3, 3),
('En quelle année Charlemagne a-t-il été couronné empereur?', 3, 3),
('Quel traité a marqué la fin de la Première Guerre mondiale?', 3, 3),
('Quel roi anglais a signé la Magna Carta?', 3, 3);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quels facteurs ont conduit à la chute de l\'Empire romain?', 4, 3),
('Expliquez l\'importance de la Révolution industrielle dans l\'histoire moderne.', 4, 3),
('Quel était le rôle de la Conférence de Yalta pendant la Seconde Guerre mondiale?', 4, 3),
('Quel événement a déclenché la Révolution française?', 4, 3),
('Quelle dynastie a régné sur la Chine pendant le siècle d\'or des Tang?', 4, 3);

-- GEOGRAPHIE
INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quel est le fleuve le plus long du monde?', 1, 4),
('Quelle est l\'île la plus grande du monde?', 1, 4),
('Quelle chaîne de montagnes est la plus étendue au monde?', 1, 4),
('Quelle forêt tropicale est la plus grande au monde?', 1, 4);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quel pays a la plus grande superficie au monde?', 2, 4),
('Quelle ville est la plus peuplée au monde?', 2, 4),
('Quelle est la plus grande île située dans l\'océan Indien?', 2, 4),
('Quelle île est la plus grande de l\'océan Atlantique?', 2, 4);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelle chaîne de montagnes traverse l\'Amérique du Sud?', 3, 4),
('Quelle forêt tropicale recouvre une grande partie de l\'Amazonie?', 3, 4),
('Quelle est la plus grande île du Pacifique et dans quel pays se trouve-t-elle?', 3, 4),
('Quelle est la plus grande île dans la région arctique?', 3, 4);

INSERT INTO questions (question, difficulty_question, id_theme) VALUES
('Quelles sont les causes de la désertification en Afrique?', 4, 4),
('Quels sont les défis environnementaux majeurs de l\'Amazonie?', 4, 4),
('Expliquez la formation des chaînes de montagnes.', 4, 4),
('Quels facteurs influencent la densité de population mondiale?', 4, 4);

-- Answers for 'Quelle est la somme de 5 et 3?' (id_question = 1)
INSERT INTO answers (id_question, answer, correct) VALUES
(1, '8', TRUE),
(1, '7', FALSE),
(1, '9', FALSE);

-- Answers for 'Quelle est la racine carrée exacte de 16?' (id_question = 2)
INSERT INTO answers (id_question, answer, correct) VALUES
(2, '4', TRUE),
(2, '3', FALSE),
(2, '5', FALSE);

-- Answers for 'Résolvez pour x: 3x = 9.' (id_question = 3)
INSERT INTO answers (id_question, answer, correct) VALUES
(3, '3', TRUE),
(3, '9', FALSE),
(3, '1', FALSE);

-- Answers for 'Quelle est la moitié exacte de 20?' (id_question = 4)
INSERT INTO answers (id_question, answer, correct) VALUES
(4, '10', TRUE),
(4, '5', FALSE),
(4, '15', FALSE);

-- Answers for 'Calculez : 3 × 3.' (id_question = 5)
INSERT INTO answers (id_question, answer, correct) VALUES
(5, '9', TRUE),
(5, '6', FALSE),
(5, '12', FALSE);

-- Answers for 'Que vaut 7 + 2?' (id_question = 6)
INSERT INTO answers (id_question, answer, correct) VALUES
(6, '9', TRUE),
(6, '8', FALSE),
(6, '10', FALSE);

-- Answers for 'Quel est le résultat de 12 divisé par 3?' (id_question = 7)
INSERT INTO answers (id_question, answer, correct) VALUES
(7, '4', TRUE),
(7, '3', FALSE),
(7, '6', FALSE);

-- Answers for 'Que vaut 10 moins 4?' (id_question = 8)
INSERT INTO answers (id_question, answer, correct) VALUES
(8, '6', TRUE),
(8, '7', FALSE),
(8, '5', FALSE);

-- Answers for 'Quel est le carré parfait de 5?' (id_question = 9)
INSERT INTO answers (id_question, answer, correct) VALUES
(9, '25', TRUE),
(9, '20', FALSE),
(9, '30', FALSE);

-- Answers for 'Calculez : 15 ÷ 3.' (id_question = 10)
INSERT INTO answers (id_question, answer, correct) VALUES
(10, '5', TRUE),
(10, '3', FALSE),
(10, '7', FALSE);

-- Answers for 'Quel est le cube de 2?' (id_question = 11)
INSERT INTO answers (id_question, answer, correct) VALUES
(11, '8', TRUE),
(11, '6', FALSE),
(11, '4', FALSE);

-- Answers for 'Effectuez le calcul : 9 × 8.' (id_question = 12)
INSERT INTO answers (id_question, answer, correct) VALUES
(12, '72', TRUE),
(12, '81', FALSE),
(12, '63', FALSE);

-- Answers for 'Quelle est la racine carrée de 81?' (id_question = 13)
INSERT INTO answers (id_question, answer, correct) VALUES
(13, '9', TRUE),
(13, '8', FALSE),
(13, '10', FALSE);

-- Answers for 'Quel est 25% de 200?' (id_question = 14)
INSERT INTO answers (id_question, answer, correct) VALUES
(14, '50', TRUE),
(14, '25', FALSE),
(14, '75', FALSE);

-- Answers for 'Quels sont les facteurs de 4?' (id_question = 15)
INSERT INTO answers (id_question, answer, correct) VALUES
(15, '1, 2, 4', TRUE),
(15, '2, 3, 4', FALSE),
(15, '1, 4, 5', FALSE);

-- Answers for 'Résolvez pour x: 2x + 5 = 15.' (id_question = 16)
INSERT INTO answers (id_question, answer, correct) VALUES
(16, '5', TRUE),
(16, '10', FALSE),
(16, '3', FALSE);

-- Answers for 'Quelle est la dérivée de la fonction x²?' (id_question = 17)
INSERT INTO answers (id_question, answer, correct) VALUES
(17, '2x', TRUE),
(17, 'x²', FALSE),
(17, '2', FALSE);

-- Answers for 'Quelle est la somme des angles dans un triangle?' (id_question = 18)
INSERT INTO answers (id_question, answer, correct) VALUES
(18, '180', TRUE),
(18, '360', FALSE),
(18, '90', FALSE);

-- Answers for 'Quelle est l\'intégrale de x² dx?' (id_question = 19)
INSERT INTO answers (id_question, answer, correct) VALUES
(19, '(1/3)x³ + C', TRUE),
(19, 'x² + C', FALSE),
(19, '(1/2)x² + C', FALSE);

-- Answers for 'Résolvez pour x : 3x² - 5x + 2 = 0.' (id_question = 20)
INSERT INTO answers (id_question, answer, correct) VALUES
(20, 'x = 1 ou x = 2/3', TRUE),
(20, 'x = -1 ou x = 3/2', FALSE),
(20, 'x = 0 ou x = 1', FALSE);

-- Answers for 'Quel est le produit des racines de l\'équation 2x² + 3x - 5 = 0?' (id_question = 21)
INSERT INTO answers (id_question, answer, correct) VALUES
(21, '-5/2', TRUE),
(21, '5/2', FALSE),
(21, '-3/2', FALSE);

-- Answers for 'Calculez la limite de (x² - 1)/(x - 1) lorsque x tend vers 1.' (id_question = 22)
INSERT INTO answers (id_question, answer, correct) VALUES
(22, '2', TRUE),
(22, '1', FALSE),
(22, '0', FALSE);

-- Answers for 'Quelle est la dérivée de sin(x)?' (id_question = 23)
INSERT INTO answers (id_question, answer, correct) VALUES
(23, 'cos(x)', TRUE),
(23, '-cos(x)', FALSE),
(23, 'sin(x)', FALSE);

-- Answers for 'À quelle température l\'eau bout-elle en degrés Celsius?' (id_question = 24)
INSERT INTO answers (id_question, answer, correct) VALUES
(24, '100', TRUE),
(24, '90', FALSE),
(24, '110', FALSE);

-- Answers for 'Quelle planète est surnommée la "Planète rouge"?' (id_question = 25)
INSERT INTO answers (id_question, answer, correct) VALUES
(25, 'Mars', TRUE),
(25, 'Vénus', FALSE),
(25, 'Jupiter', FALSE);

-- Answers for 'À combien de degrés Celsius l\'eau gèle-t-elle?' (id_question = 26)
INSERT INTO answers (id_question, answer, correct) VALUES
(26, '0', TRUE),
(26, '-10', FALSE),
(26, '5', FALSE);

-- Answers for 'Quelle est l\'étoile la plus proche de la Terre?' (id_question = 27)
INSERT INTO answers (id_question, answer, correct) VALUES
(27, 'Le Soleil', TRUE),
(27, 'Proxima du Centaure', FALSE),
(27, 'Sirius', FALSE);

-- Answers for 'Quelle est l\'étoile la plus brillante dans le ciel nocturne?' (id_question = 28)
INSERT INTO answers (id_question, answer, correct) VALUES
(28, 'Sirius', TRUE),
(28, 'Vega', FALSE),
(28, 'Bételgeuse', FALSE);


-- Answers for 'À quelle température l\'eau bout-elle en degrés Fahrenheit?' (id_question = 29)
INSERT INTO answers (id_question, answer, correct) VALUES
(29, '212', TRUE),
(29, '200', FALSE),
(29, '180', FALSE);

-- Answers for 'Quelle est la planète la plus proche du Soleil?' (id_question = 30)
INSERT INTO answers (id_question, answer, correct) VALUES
(30, 'Mercure', TRUE),
(30, 'Vénus', FALSE),
(30, 'Mars', FALSE);

-- Answers for 'Quelle est la plus grande planète du système solaire?' (id_question = 31)
INSERT INTO answers (id_question, answer, correct) VALUES
(31, 'Jupiter', TRUE),
(31, 'Saturne', FALSE),
(31, 'Uranus', FALSE);

-- Answers for 'Quelle est la planète la plus éloignée du Soleil dans le système solaire?' (id_question = 32)
INSERT INTO answers (id_question, answer, correct) VALUES
(32, 'Neptune', TRUE),
(32, 'Pluton', FALSE),
(32, 'Uranus', FALSE);

-- Answers for 'Quelle planète est surnommée la "Planète bleue"?' (id_question = 33)
INSERT INTO answers (id_question, answer, correct) VALUES
(33, 'La Terre', TRUE),
(33, 'Neptune', FALSE),
(33, 'Uranus', FALSE);

-- Answers for 'Quelle est la vitesse de la lumière en m/s?' (id_question = 34)
INSERT INTO answers (id_question, answer, correct) VALUES
(34, '299 792 458', TRUE),
(34, '300 000 000', FALSE),
(34, '150 000 000', FALSE);

-- Answers for 'Quelle est la température de fusion de l\'or en °C?' (id_question = 35)
INSERT INTO answers (id_question, answer, correct) VALUES
(35, '1 064', TRUE),
(35, '800', FALSE),
(35, '1 500', FALSE);

-- Answers for 'À quelle température le fer fond-il?' (id_question = 36)
INSERT INTO answers (id_question, answer, correct) VALUES
(36, '1 538', TRUE),
(36, '1 000', FALSE),
(36, '1 800', FALSE);

-- Answers for 'Quel métal fond à 327,5 °C?' (id_question = 37)
INSERT INTO answers (id_question, answer, correct) VALUES
(37, 'Le plomb', TRUE),
(37, 'L\'étain', FALSE),
(37, 'Le zinc', FALSE);

-- Answers for 'Quelle est la température de fusion du cuivre?' (id_question = 38)
INSERT INTO answers (id_question, answer, correct) VALUES
(38, '1 085', TRUE),
(38, '1 000', FALSE),
(38, '1 200', FALSE);

-- Answers for 'Quelle est l\'équation qui relie l\'énergie, la masse et la vitesse de la lumière?' (id_question = 39)
INSERT INTO answers (id_question, answer, correct) VALUES
(39, 'E = mc²', TRUE),
(39, 'F = ma', FALSE),
(39, 'P = mv', FALSE);

-- Answers for 'Quel est le nom de la particule associée à la force électromagnétique?' (id_question = 40)
INSERT INTO answers (id_question, answer, correct) VALUES
(40, 'Le photon', TRUE),
(40, 'Le graviton', FALSE),
(40, 'Le neutrino', FALSE);

-- Answers for 'Quelle est la constante gravitationnelle universelle (G)?' (id_question = 41)
INSERT INTO answers (id_question, answer, correct) VALUES
(41, '6,674 × 10⁻¹¹', TRUE),
(41, '9,8', FALSE),
(41, '3 × 10⁸', FALSE);

-- Answers for 'Quelle est l\'équation de Schrödinger?' (id_question = 42)
INSERT INTO answers (id_question, answer, correct) VALUES
(42, 'HΨ = EΨ', TRUE),
(42, 'E = mc²', FALSE),
(42, 'F = -kx', FALSE);

-- Answers for 'Qu\'est-ce que l\'entropie en thermodynamique?' (id_question = 43)
INSERT INTO answers (id_question, answer, correct) VALUES
(43, 'Une mesure du désordre d\'un système', TRUE),
(43, 'La capacité thermique d\'un système', FALSE),
(43, 'La quantité de chaleur transférée', FALSE);

-- Answers for 'Qui a rédigé la Déclaration d\'indépendance des États-Unis?' (id_question = 44)
INSERT INTO answers (id_question, answer, correct) VALUES
(44, 'Thomas Jefferson', TRUE),
(44, 'George Washington', FALSE),
(44, 'Benjamin Franklin', FALSE);

-- Answers for 'En quelle année s\'est terminée la Seconde Guerre mondiale?' (id_question = 45)
INSERT INTO answers (id_question, answer, correct) VALUES
(45, '1945', TRUE),
(45, '1939', FALSE),
(45, '1950', FALSE);

-- Answers for 'Quelle ville est la capitale de la France?' (id_question = 46)
INSERT INTO answers (id_question, answer, correct) VALUES
(46, 'Paris', TRUE),
(46, 'Lyon', FALSE),
(46, 'Marseille', FALSE);

-- Answers for 'Sur quel continent trouve-t-on le désert du Sahara?' (id_question = 47)
INSERT INTO answers (id_question, answer, correct) VALUES
(47, 'Afrique', TRUE),
(47, 'Asie', FALSE),
(47, 'Amérique', FALSE);

-- Answers for 'Qui a peint La Joconde?' (id_question = 48)
INSERT INTO answers (id_question, answer, correct) VALUES
(48, 'Léonard de Vinci', TRUE),
(48, 'Michel-Ange', FALSE),
(48, 'Raphaël', FALSE);

-- Answers for 'Qui fut le premier président des États-Unis?' (id_question = 49)
INSERT INTO answers (id_question, answer, correct) VALUES
(49, 'George Washington', TRUE),
(49, 'Abraham Lincoln', FALSE),
(49, 'Thomas Jefferson', FALSE);

-- Answers for 'Qui est considéré comme le premier empereur romain?' (id_question = 50)
INSERT INTO answers (id_question, answer, correct) VALUES
(50, 'Auguste', TRUE),
(50, 'Jules César', FALSE),
(50, 'Néron', FALSE);

-- Answers for 'Quel roi a été couronné comme premier roi de France?' (id_question = 51)
INSERT INTO answers (id_question, answer, correct) VALUES
(51, 'Clovis', TRUE),
(51, 'Charlemagne', FALSE),
(51, 'Louis XIV', FALSE);

-- Answers for 'Quel empereur a unifié la Chine sous la dynastie Qin?' (id_question = 52)
INSERT INTO answers (id_question, answer, correct) VALUES
(52, 'Qin Shi Huang', TRUE),
(52, 'Kublai Khan', FALSE),
(52, 'Sun Yat-sen', FALSE);

-- Answers for 'Qui fut le premier roi d\'Angleterre?' (id_question = 53)
INSERT INTO answers (id_question, answer, correct) VALUES
(53, 'Æthelstan', TRUE),
(53, 'Alfred le Grand', FALSE),
(53, 'Guillaume le Conquérant', FALSE);

-- Answers for 'Quels sont les accomplissements de Qin Shi Huang, le premier empereur chinois?' (id_question = 54)
INSERT INTO answers (id_question, answer, correct) VALUES
(54, 'Unification de la Chine, création de la Grande Muraille', TRUE),
(54, 'Création de la dynastie Ming, exploration maritime', FALSE),
(54, 'Introduction du bouddhisme en Chine', FALSE);

-- Answers for 'Quel tsar a été proclamé le premier empereur de Russie?' (id_question = 55)
INSERT INTO answers (id_question, answer, correct) VALUES
(55, 'Pierre le Grand', TRUE),
(55, 'Ivan le Terrible', FALSE),
(55, 'Catherine la Grande', FALSE);

-- Answers for 'En quelle année Charlemagne a-t-il été couronné empereur?' (id_question = 56)
INSERT INTO answers (id_question, answer, correct) VALUES
(56, '800', TRUE),
(56, '814', FALSE),
(56, '750', FALSE);

-- Answers for 'Quel traité a marqué la fin de la Première Guerre mondiale?' (id_question = 57)
INSERT INTO answers (id_question, answer, correct) VALUES
(57, 'Traité de Versailles', TRUE),
(57, 'Traité de Paris', FALSE),
(57, 'Traité de Tordesillas', FALSE);

-- Answers for 'Quel roi anglais a signé la Magna Carta?' (id_question = 58)
INSERT INTO answers (id_question, answer, correct) VALUES
(58, 'Jean sans Terre', TRUE),
(58, 'Henri VIII', FALSE),
(58, 'Richard Cœur de Lion', FALSE);


-- Answers for 'Quels facteurs ont conduit à la chute de l\'Empire romain?' (id_question = 59)
INSERT INTO answers (id_question, answer, correct) VALUES
(59, 'Invasions barbares, déclin économique, corruption', TRUE),
(59, 'Découverte de l\'Amérique, montée du protestantisme', FALSE),
(59, 'Réformes agraires, centralisation du pouvoir', FALSE);

-- Answers for 'Expliquez l\'importance de la Révolution industrielle dans l\'histoire moderne.' (id_question = 60)
INSERT INTO answers (id_question, answer, correct) VALUES
(60, 'Transition vers les machines, urbanisation, progrès technologiques', TRUE),
(60, 'Colonisation de l\'Amérique, développement agricole', FALSE),
(60, 'Chute des monarchies européennes, démocratisation', FALSE);

-- Answers for 'Quel était le rôle de la Conférence de Yalta pendant la Seconde Guerre mondiale?' (id_question = 61)
INSERT INTO answers (id_question, answer, correct) VALUES
(61, 'Réorganisation de l\'Europe, partage des zones d\'influence', TRUE),
(61, 'Financement de la guerre, adoption des droits humains', FALSE),
(61, 'Déclaration de guerre à l\'Allemagne', FALSE);

-- Answers for 'Quel événement a déclenché la Révolution française?' (id_question = 62)
INSERT INTO answers (id_question, answer, correct) VALUES
(62, 'La prise de la Bastille', TRUE),
(62, 'Le couronnement de Napoléon', FALSE),
(62, 'La déclaration de guerre à l\'Autriche', FALSE);

-- Answers for 'Quelle dynastie a régné sur la Chine pendant le siècle d\'or des Tang?' (id_question = 63)
INSERT INTO answers (id_question, answer, correct) VALUES
(63, 'Dynastie Tang', TRUE),
(63, 'Dynastie Song', FALSE),
(63, 'Dynastie Yuan', FALSE);

-- Answers for 'Quel est le fleuve le plus long du monde?' (id_question = 64)
INSERT INTO answers (id_question, answer, correct) VALUES
(64, 'Le Nil', TRUE),
(64, 'L\'Amazon', FALSE),
(64, 'Le Yangtsé', FALSE);

-- Answers for 'Quelle est l\'île la plus grande du monde?' (id_question = 65)
INSERT INTO answers (id_question, answer, correct) VALUES
(65, 'Le Groenland', TRUE),
(65, 'Madagascar', FALSE),
(65, 'Bornéo', FALSE);

-- Answers for 'Quelle chaîne de montagnes est la plus étendue au monde?' (id_question = 66)
INSERT INTO answers (id_question, answer, correct) VALUES
(66, 'Les Andes', TRUE),
(66, 'L\'Himalaya', FALSE),
(66, 'Les Rocheuses', FALSE);

-- Answers for 'Quelle forêt tropicale est la plus grande au monde?' (id_question = 67)
INSERT INTO answers (id_question, answer, correct) VALUES
(67, 'La forêt amazonienne', TRUE),
(67, 'La forêt du Congo', FALSE),
(67, 'La forêt de Bornéo', FALSE);

-- Answers for 'Quel pays a la plus grande superficie au monde?' (id_question = 68)
INSERT INTO answers (id_question, answer, correct) VALUES
(68, 'La Russie', TRUE),
(68, 'Le Canada', FALSE),
(68, 'La Chine', FALSE);

-- Answers for 'Quelle ville est la plus peuplée au monde?' (id_question = 69)
INSERT INTO answers (id_question, answer, correct) VALUES
(69, 'Tokyo', TRUE),
(69, 'Shanghai', FALSE),
(69, 'Mumbai', FALSE);

-- Answers for 'Quelle est la plus grande île située dans l\'océan Indien?' (id_question = 70)
INSERT INTO answers (id_question, answer, correct) VALUES
(70, 'Madagascar', TRUE),
(70, 'Sumatra', FALSE),
(70, 'Sri Lanka', FALSE);

-- Answers for 'Quelle île est la plus grande de l\'océan Atlantique?' (id_question = 71)
INSERT INTO answers (id_question, answer, correct) VALUES
(71, 'Le Groenland', TRUE),
(71, 'Cuba', FALSE),
(71, 'L\'Islande', FALSE);

-- Answers for 'Quelle chaîne de montagnes traverse l\'Amérique du Sud?' (id_question = 72)
INSERT INTO answers (id_question, answer, correct) VALUES
(72, 'Les Andes', TRUE),
(72, 'L\'Himalaya', FALSE),
(72, 'Les Alpes', FALSE);

-- Answers for 'Quelle forêt tropicale recouvre une grande partie de l\'Amazonie?' (id_question = 73)
INSERT INTO answers (id_question, answer, correct) VALUES
(73, 'La forêt amazonienne', TRUE),
(73, 'La forêt du Congo', FALSE),
(73, 'La taïga', FALSE);

-- Answers for 'Quelle est la plus grande île du Pacifique et dans quel pays se trouve-t-elle?' (id_question = 74)
INSERT INTO answers (id_question, answer, correct) VALUES
(74, 'La Nouvelle-Guinée, Indonésie et Papouasie-Nouvelle-Guinée', TRUE),
(74, 'Hawaï, États-Unis', FALSE),
(74, 'Bornéo, Indonésie', FALSE);

-- Answers for 'Quelle est la plus grande île dans la région arctique?' (id_question = 75)
INSERT INTO answers (id_question, answer, correct) VALUES
(75, 'Le Groenland', TRUE),
(75, 'Les îles Svalbard', FALSE),
(75, 'L\'île Baffin', FALSE);

-- Answers for 'Quelles sont les causes de la désertification en Afrique?' (id_question = 76)
INSERT INTO answers (id_question, answer, correct) VALUES
(76, 'Déforestation, surpâturage, changement climatique', TRUE),
(76, 'Intensification agricole, fonte des glaciers', FALSE),
(76, 'Pollution industrielle, urbanisation', FALSE);

-- Answers for 'Quels sont les défis environnementaux majeurs de l\'Amazonie?' (id_question = 77)
INSERT INTO answers (id_question, answer, correct) VALUES
(77, 'Déforestation, perte de biodiversité, exploitation minière', TRUE),
(77, 'Fonte des glaciers, pollution marine', FALSE),
(77, 'Urbanisation, pollution de l\'air', FALSE);

-- Answers for 'Expliquez la formation des chaînes de montagnes.' (id_question = 78)
INSERT INTO answers (id_question, answer, correct) VALUES
(78, 'Collision de plaques tectoniques', TRUE),
(78, 'Activité volcanique sous-marine', FALSE),
(78, 'Érosion et dépôt sédimentaire', FALSE);

-- Answers for 'Quels facteurs influencent la densité de population mondiale?' (id_question = 79)
INSERT INTO answers (id_question, answer, correct) VALUES
(79, 'Ressources naturelles, climat, infrastructures', TRUE),
(79, 'Changements climatiques, fonte des glaces', FALSE),
(79, 'Désertification, inégalités sociales', FALSE);




-- Insert data into PLAYED_GAMES_THEMES table
INSERT INTO played_games_themes (id_game_played, id_theme) VALUES
(1,1),
(1,2),
(2,2),
(3, 4),
(3, 1),
(4, 3),
(5, 4),
(6, 1),
(6, 2),
(7, 3),
(8, 2),
(9, 3),
(10, 3),
(11, 1),
(12, 1),
(13, 4),
(13, 2),
(13, 1),
(14, 2),
(14, 1),
(15, 3),
(15, 4),
(16, 4);




