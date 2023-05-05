CREATE DATABASE Taqueria_La_Glorieta;
USE Taqueria_La_Glorieta;

#USUARIOS
CREATE TABLE Usuarios(
id_usuario int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
usuario varchar(15) not null,
password varchar(15) not null,
telefono varchar(10) not null,
estado int (1) not null 
);
CREATE TABLE personal (
	personal_id int NOT NULL auto_increment,
    nombre varchar(20),
    apellido varchar(20),
    tipo_usuario varchar(20),
    primary key(personal_id)
);

#Movimientos
CREATE TABLE movimiento (
	movimiento_id int NOT NULL auto_increment,
    articulo_id int,
    cantidad float,
    primary key(movimiento_id),
    foreign key(articulo_id)
    references catalogo(articulo_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE evento (
	evento_id int NOT NULL auto_increment,
    estado varchar(20),
    cliente_id int,
	asistentes int,
    costo float,
    fecha datetime,
    primary key(evento_id),
    foreign key(cliente_id)
    references cliente(cliente_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

#ESTADOS
#Pendiente por pagar
#Pendiente por fecha
#Cancelado
#Concluido


CREATE TABLE cliente (
	cliente_id int NOT NULL auto_increment,
    nombre varchar(20),
    apellido varchar(20),
    telefono varchar(12),
    correo varchar(40),
    primary key(cliente_id)
);

CREATE TABLE catalogo (
	articulo_id int NOT NULL auto_increment,
    nombre varchar(30),
    marca_id int,
	udm varchar(5),
    existencia float,
    costo float,
    primary key(articulo_id),
    foreign key(marca_id)
    references marca(marca_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE marca (
	marca_id int NOT NULL auto_increment,
    nombre varchar(30),
    primary key(marca_id)
);

