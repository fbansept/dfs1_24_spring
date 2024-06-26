INSERT INTO utilisateur (email, password, administrateur) VALUES
("a@a.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 1),
("b@b.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0),
("c@c.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0);

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

INSERT INTO question (texte, quizz_id) VALUES
("Comment s'appelle le 1er pokemon de sacha", 1),
("Combien y a t-il de pokemon dans la première génération", 1);