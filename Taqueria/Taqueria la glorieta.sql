use taqueria_la_glorieta;
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

-- Tabla de inventario
CREATE TABLE inventario (
  id_producto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(100),
  cantidad INT NOT NULL,
  proovedor VARCHAR(50)
);
select * from inventario;

-- Tabla de ventas
CREATE TABLE ventas (
	venta_id int NOT NULL auto_increment,
	item_id int NOT NULL,
    cantidad int NOT NULL,
    total_venta int,
    fecha DATE NOT NULL,
    primary key(venta_id),
    foreign key(item_id)
    references menu_catalogo(item_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE menu_catalogo(
	item_id int NOT NULL auto_increment,
    nombre varchar(30),
    precio_unit int,
    primary key(item_id)
);

CREATE TABLE inventario (
  id_producto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(100),
  cantidad INT NOT NULL,
  proovedor VARCHAR(50)
);
select * from inventario;

-- Tabla de sueldos
CREATE TABLE sueldos (
  id_sueldo INT NOT NULL AUTO_INCREMENT,
  id_empleado INT NOT NULL,
  fecha_pago DATE NOT NULL,
  monto_sueldo DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_sueldo),
  FOREIGN KEY (id_empleado) 
  REFERENCES empleados(id_empleado)
);

-- Tabla de registro de jornada
CREATE TABLE registro_jornada (
  id_registro INT NOT NULL AUTO_INCREMENT,
  id_empleado INT NOT NULL,
  fecha DATE NOT NULL,
  hora_entrada TIME NOT NULL,
  hora_salida TIME NOT NULL,
  PRIMARY KEY (id_registro),
  FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Tabla de empleados
CREATE TABLE empleados (
  id_empleado INT NOT NULL AUTO_INCREMENT,
  nombre_empleado VARCHAR(25) NOT NULL,
  apellido_empleado VARCHAR(25) NOT NULL,
  direccion_empleado VARCHAR(40),
  telefono_empleado VARCHAR(10),
  usuario varchar(15) not null,
  password varchar(15) not null,
  id_puesto INT NOT NULL,
  FOREIGN KEY (id_puesto)
  REFERENCES catalogo_puestos(id_puesto)
  ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id_empleado)
);
INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("diego", "gonzalez", "tijuana", "664", "admin", "123", 5); #5 para admin
select * from empleados;

CREATE TABLE catalogo_puestos (
	id_puesto INT NOT NULL AUTO_INCREMENT,
    puesto_empleado VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_puesto)
);
INSERT INTO catalogo_puestos(puesto_empleado)
VALUES("asador"),("taquero"),("mesero"),("cajero"),("admin");
select * from catalogo_puestos;

select puesto_empleado
from catalogo_puestos;



select concat(nombre_empleado, ' ', apellido_empleado) from empleados;
select id_empleado from empleados where nombre_empleado = 'diego' and apellido_empleado = 'gonzalez';
select usuario, password from usuarios
where usuario="Admin" and password="12345";