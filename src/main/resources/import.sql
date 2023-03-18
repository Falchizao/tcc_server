insert into authority (authority) values ('ROLE_ADMIN');
insert into authority (authority) values ('ROLE_CANDIDATE');
insert into authority (authority) values ('ROLE_COMPANY');

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('marcelo@gmail.com', 'Marcelo', 'Falchi', 'a', 1, 'falchi', 1)

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('johndoe@example.com', 'Lary', 'Doe', '$2a$10$Tb85oR8uoEa1e36EGhCJ6OMyMQs9EdW6DNv3J15hERbTgT8RnlW1a', 1, 'larydoe', 2);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('janesmith@example.com', 'Jane', 'Smith', '$2a$10$7grx.5JLnPIVTOLuOYIzfu7XJhvKdUhVIlOFTBco6rhVgPQJ0cHqK', 1, 'janesmith', 3);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('robertjones@example.com', 'Roberta', 'Jones', '$2a$10$W2u3il.3MEU6KzHMuUnsW.X9k43dHKPiA6fZT6TJW8xw26B1AlY0a', 1, 'robertajones', 4);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('sarahlee@example.com', 'Sarah', 'Lee', '$2a$10$w4bUHhyjA10.6UVs9Bq3SO6jKm6TmT3q9XZ.vtH4a4zKgRlCXxoE.', 2, 'sarahlee', 5);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('michaelbrown@example.com', 'Michaela', 'Brown', '$2a$10$iCwzF50mt0jKzwfsLGxS0.4ukdK2N3X9gxIKDRtET4fH/0/XRzgmy', 2, 'michaelabrown', 6);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('emilynguyen@example.com', 'Emily', 'Nguyen', '$2a$10$JY8llvzU91AOSpVl/DHMH.NXlrgcFlKbsh27rkQzZ38fYdL26jF8S', 2, 'emilynguyen', 7);

INSERT INTO profile(description) VALUES ('boilerplate')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('davidsmith@example.com', 'Samara', 'Smith', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'samarasmith', 8);

INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Pessoa Programadora Delphi Pleno', 'Atenciosa, prestativa e gostar de trabalhar', now(), 8.48, 1800, 1);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Pessoa Programadora Java Senior', 'Buscamos pessoas com facilidade de aprendizado', now(), 8, 5000, 2);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Pessoa Programadora Node JS Pleno', 'Deve-se conhecer bem node js', now(), 8, 4200, 3);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Arquiteto Java', 'Microsservices e Kafka', now(), 8, 13500, 4);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Estagio PHP', 'Composer e Fullstack', now(), 6, 1500, 5);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Programadora Ruby on Rails', '+ de 3 anos de experiencia', now(), 8, 3200, 6);
INSERT into offer (title, content, created_date, hours, salary, tb_user) VALUES ('Pessoa Programadora Flutter', 'Getx e RiverPod', now(), 8, 4300, 7);

INSERT INTO post (content, created_date, tb_user_id) values ('Adoro essa plataforma!', now(), 1);
INSERT INTO post (content, created_date, tb_user_id) values ('Aff, php é muito ruim', now(), 2);
INSERT INTO post (content, created_date, tb_user_id) values ('Pessoal, minha empresas está contratando! Vagas para pleno e senior hehe', now(), 3);
INSERT INTO post (content, created_date, tb_user_id) values ('Virei Tech Lead, muito feliz', now(), 4);
INSERT INTO post (content, created_date, tb_user_id) values ('Consegui meu primeiro emprego como programadora aqui, adorei!!', now(), 5);
INSERT INTO post (content, created_date, tb_user_id) values ('Que bacana esse sistema de adicionar as conexões', now(), 6);
INSERT INTO post (content, created_date, tb_user_id) values ('Adorei esse sistema de chat!', now(), 7);
