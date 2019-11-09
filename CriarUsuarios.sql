USE dbGames;

INSERT INTO Usuario (nomeUsuario, senha, dataCadastro, ativo, idFuncionario) 
VALUES ('mazinhacardoso', '948571', curdate(), TRUE, 1),
('mmarinho', '395678', curdate(), TRUE, 3),
('araujovitor', '908070', curdate(), TRUE, 2),
('valeriaAlves', '905941', curdate(), FALSE, 4);