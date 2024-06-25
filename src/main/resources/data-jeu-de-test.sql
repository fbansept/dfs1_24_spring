INSERT INTO utilisateur (email, password) VALUES
("a@a.com", "root"),
("b@b.com", "root"),
("c@c.com", "root");

INSERT INTO quizz (nom, niveau, createur_id) VALUES
("pokemon", 1, 1),
("manga", 3, 1),
("serie 90", 4, 2);

INSERT INTO categorie (nom) VALUES
("Culture G"),
("Culture geek"),
("Geographie"),
("Japon"),
("Serie");

INSERT INTO categorie_quizz (quizz_id, categorie_id) VALUES
(1, 2),
(1, 4),
(1, 5),
(2, 2),
(2, 4);