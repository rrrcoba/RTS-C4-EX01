use heroku_51622ecbff57a76;

drop table if exists `messages`;
drop table if exists `users`;
drop table if exists `parties`;
drop table if exists `games`;

CREATE TABLE `games` (
	`id` int NOT NULL auto_increment,
    `name` nvarchar(255) NOT NULL,
    `type` nvarchar(255) NOT NULL,
    `age` int NOT NULL,
    PRIMARY KEY (`id`)
);
INSERT INTO `games` (`name`, `type`, `age`) VALUES ('PUBG', 'Shooter', 18),
												   ('Phasmophobia', 'Terror', 18),
												   ('Torchligth 3', 'Action', 16),
                                                   ('Fable', 'Adventure', 16),
                                                   ('Grand Turismo 4', 'Racing', 5);
                                                   


CREATE TABLE `parties` (
	`id` int NOT NULL auto_increment,
    `name` nvarchar(255) NOT NULL,
    `game` int NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `parties_fk_1` FOREIGN KEY (`game`) REFERENCES `games` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `parties` (`name`,`game`) VALUES ('sala29',11),
											 ('omaigot',1),
											 ('mysala',41);
                                                             

CREATE TABLE `users` (
	`id` int NOT NULL auto_increment,
    `nick` nvarchar(255) NOT NULL,
    `name_surname` nvarchar(255) NOT NULL,
    `steam_user` nvarchar(255),
    `party` int NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `users_fk_1` FOREIGN KEY (`party`) REFERENCES `parties`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE
);
INSERT INTO `users` (`nick`, `name_surname`, `steam_user`, `party`) VALUES ('elrubius', 'Ruben Doblas', 'elrubius', 11),
																		   ('mayte', 'Maite Apellido1 Apellido2', 'mayte', 1);


CREATE TABLE `messages` (
	`id` int NOT NULL auto_increment,
    `content` nvarchar(255) NOT NULL,
    `user` int NOT NULL,
    PRIMARY KEY (`id`),
	CONSTRAINT `messages_fk_1` FOREIGN KEY (`user`) REFERENCES `users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `messages` (`content`, `user`) VALUES ('Quien anda ahi', 11), 
												  ('no hay nadie', 11),
                                                  ('holaa', 1);

commit;