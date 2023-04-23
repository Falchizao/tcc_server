insert into authority (authority) values ('ROLE_ADMIN');
insert into authority (authority) values ('ROLE_CANDIDATE');
insert into authority (authority) values ('ROLE_COMPANY');


@Getter
@Setter
    private String description;

    @Getter
@Setter
    private String location;

    @Getter
@Setter
    private String previousXP;
}
INSERT INTO profile(previousXP, location, description) VALUES ('Trabalhei 2 anos como desenvolvedor de software em Pato Branco - Parana','Sao Paulo - Brazil','Me chamo Marcelo Falchi, sou o criador deste app, busco sempre novos conhecimentos e me aprofundar em novas tecnologias')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('marcelonavarro@gmail.com', 'Marcelo', 'Falchi', '$2a$10$lLPJdpiaK3AHpfklvkIa1.O93tRYQCVYbtlA3CUNdXpQNY8PGJnti', 1, 'falchi', 1)

INSERT INTO profile(description) VALUES ('Hello there, my name is John, follow me for more content')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('johndoe@example.com', 'Lary', 'Doe', '$2a$10$Tb85oR8uoEa1e36EGhCJ6OMyMQs9EdW6DNv3J15hERbTgT8RnlW1a', 1, 'larydoe', 2);

INSERT INTO profile(description) VALUES ('Hey folks, my name is Jane, follow me for more content')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('janesmith@example.com', 'Jane', 'Smith', '$2a$10$7grx.5JLnPIVTOLuOYIzfu7XJhvKdUhVIlOFTBco6rhVgPQJ0cHqK', 1, 'janesmith', 3);

INSERT INTO profile(description) VALUES ('Whats up people, my name is Robert, follow me for more content')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('robertjones@example.com', 'Roberta', 'Jones', '$2a$10$W2u3il.3MEU6KzHMuUnsW.X9k43dHKPiA6fZT6TJW8xw26B1AlY0a', 1, 'robertajones', 4);

INSERT INTO profile(description) VALUES ('My name is Sarah, follow for more content')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('sarahlee@example.com', 'Sarah', 'Lee', '$2a$10$w4bUHhyjA10.6UVs9Bq3SO6jKm6TmT3q9XZ.vtH4a4zKgRlCXxoE.', 2, 'sarahlee', 5);

INSERT INTO profile(description) VALUES ('Senior software Eng, like to post about anything')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('michaelbrown@example.com', 'Michaela', 'Brown', '$2a$10$iCwzF50mt0jKzwfsLGxS0.4ukdK2N3X9gxIKDRtET4fH/0/XRzgmy', 2, 'michaelabrown', 6);

INSERT INTO profile(description) VALUES ('What`s up recruiters, my name is emily and i`m a 20yo software developer')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('emilynguyen@example.com', 'Emily', 'Nguyen', '$2a$10$JY8llvzU91AOSpVl/DHMH.NXlrgcFlKbsh27rkQzZ38fYdL26jF8S', 2, 'emilynguyen', 7);

INSERT INTO profile(description) VALUES ('My name is david and i love to play games')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('davidsmith@example.com', 'Samara', 'Smith', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'samarasmith', 8);

INSERT INTO profile(description) VALUES ('Me chamo ronald, sou recrutador da empresa XX, fique por dentro de novas vagas clicando no botao de seguir')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('ronald@example.com', 'Ronald', 'Black', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'ronaldblack', 9);

INSERT INTO profile(description) VALUES ('Me chamo vitor, adoro ler e comentar sobre programacao, se for de seu interesse, me siga para mais informacoes')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('victor@example.com', 'Victor', 'Santana', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'victorsantana', 10);

INSERT INTO profile(description) VALUES ('Professor Universitario, programador fullstack e amo jogos virtuais')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('pegorini@example.com', 'Vinicius', 'Pegorini', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'vinipegorini', 11);

INSERT INTO profile(description) VALUES ('Professora Universitaria, com muita vontade de ensinar!')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('soelaine@example.com', 'Gabrielle', 'Soelaine', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'soelaine', 12);

INSERT INTO profile(description) VALUES ('Programador C#, amo ensinar novas pessoas!')
INSERT INTO TB_USER (email, first_name, last_name, password, type, username, profile_id) VALUES ('bueno@example.com', 'Victor', 'Bueno', '$2a$10$hE2hBzUNOzN41yf25hJfAOE7i8Mk5p5ZK/6/hzUwOY8HzGJPPKjy2', 2, 'victorbueno', 13);



INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Programadora Delphi', 'Atenciosa, prestativa e gostar de trabalhar', now(), 8.48, 1800,'BR - Rio de Janeiro - Copacabana' ,'Orientacao a objetos, solucao de problemas', false ,1);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Programadora Java', 'Buscamos pessoas com facilidade de aprendizado', now(), 8, 5000,'BR - Sao Paulo - Santo Andre' ,'Facilidade de Aprendizado, Microservicos', true, 2);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Programadora Node JS', 'Deve-se conhecer bem node js', now(), 8, 4200,'BR - Sao Paulo - Sao Bernardo' ,'Ecossistema JavaScript', false, 3);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Arquiteto Java', 'Microsservices e Kafka', now(), 8, 13500,'BR - Parana - Pato Branco' ,'Escalabilidade de Servicos, Kafka, Spring-boot e Nginx', true, 4);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Estagio PHP', 'Composer e Fullstack', now(), 6, 1500,'BR - Bahia - Salvador' ,'Conhecimentos em PHP', false, 5);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Programadora Ruby', '+ de 3 anos de experiencia', now(), 8, 3200, 'BR - Bahia - Salvador' ,'Ruby, Orientacao a Objetos e JavaScript', true, 6);
INSERT into offer (title, content, created_date, hours, salary, location, requirements, remote, tb_user) VALUES ('Programadora Flutter', 'Getx e RiverPod', now(), 8, 4300, 'BR - Parana - Curitiba' ,'Flutter, Contribuicoes em Open Source, Getx, Gerenciamento de Estado com RiverPod', false, 7);

INSERT INTO post (content, created_date, tb_user_id) values ('Adoro essa plataforma!', now(), 1);
INSERT INTO post (content, created_date, tb_user_id) values ('Aff, php ficou muito ruim', now(), 2);
INSERT INTO post (content, created_date, tb_user_id) values ('Pessoal, minha empresas abriu algumas vagas! Tanto para pleno e senior hehe', now(), 3);
INSERT INTO post (content, created_date, tb_user_id) values ('Virei Tech Lead, muito feliz', now(), 4);
INSERT INTO post (content, created_date, tb_user_id) values ('Consegui meu primeiro emprego como programadora aqui, adorei!!', now(), 5);
INSERT INTO post (content, created_date, tb_user_id) values ('Que bacana esse sistema de seguir as pessoas', now(), 6);
INSERT INTO post (content, created_date, tb_user_id) values ('Adorei esse sistema de chat!', now(), 7);

INSERT INTO connection (connection_date, follower, following) values (now(), 1, 1);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 2);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 3);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 4);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 5);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 6);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 7);
INSERT INTO connection (connection_date, follower, following) values (now(), 1, 8);

