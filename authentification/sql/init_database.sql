drop database if exists authentification;
create database authentification;

use authentification;

drop table if exists user;
create table user(
idUser integer primary key auto_increment,
firstname varchar(100) not null,
lastname varchar(100) not null,
login varchar(100) unique not null,
password varchar(100) not null
)Engine=InnoDB;
insert into user(firstname, lastname, login, password) values 
	('anis', 'lalami', 'admin', 'admin'),
	('lambda', 'user', 'lambda', 'lambda');

drop table if exists animal;
create table animal(
idAnimal int primary key auto_increment,
name varchar(100),
color varchar(30) not null,
dangerous boolean not null,
idUser int not null,
constraint fk_owner foreign key (idUser) references user(idUser) 
	on delete CASCADE on update CASCADE
)engine=InnoDB;
insert into animal(name, color, dangerous, idUser) values
	('tigre', 'jaune', true, (select idUser from user where login='lambda')),
	('chat', 'noir', false, (select idUser from user where login='lambda')),
	('limace', 'marron', false, (select idUser from user where login='lambda'));

drop table if exists role;
create table role(
idRole int primary key auto_increment,
name varchar(20)
);
insert into role(name) values ('admin'), ('user');

drop table if exists user_role;
create table user_role(
idRole int,
idUser int,
constraint fk_idRole foreign key (idRole) references role(idRole)
	on delete restrict on update restrict,
constraint fk_idUser foreign key (idUser) references user(idUser)
	on delete restrict on update restrict
)engine=InnoDB;

insert into user_role values
	((select idUser from user where login='admin'),
	 (select idRole from role where name='admin')),
	((select idUser from user where login='lambda'),
	 (select idRole from role where name='user'));
