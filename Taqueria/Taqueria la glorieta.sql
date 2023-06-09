use taqueria_la_glorieta;

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
select * from menu_catalogo;

CREATE TABLE inventario (
  id_producto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(100),
  cantidad INT NOT NULL,
  proovedor VARCHAR(50)
);

-- Tabla de sueldos
CREATE TABLE sueldos (
  id_sueldo INT NOT NULL AUTO_INCREMENT,
  id_puesto INT NOT NULL,
  fecha_pago DATE NOT NULL,
  monto_sueldo DECIMAL NOT NULL,
  PRIMARY KEY (id_sueldo),
  FOREIGN KEY (id_puesto) 
  REFERENCES catalogo_puestos(id_puesto)
);
insert into sueldos(id_puesto, fecha_pago, monto_sueldo) values
(1, "2023-05-30", 1500), (2, "2023-05-30", 1600), (3, "2023-05-30", 1300), (4, "2023-05-30", 1200), (5, "2023-05-30", 2000);
SELECT id_registro, registro_jornada.id_empleado, concat(e.nombre_empleado, " ", e.apellido_empleado), fecha, hora_entrada, hora_salida FROM registro_jornada
INNER JOIN empleados e
on e.id_empleado = registro_jornada.id_empleado;

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
select * from registro_jornada;

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

DELIMITER $
CREATE TRIGGER actualizarBlancoANinguno
BEFORE INSERT 
ON empleados 
FOR EACH ROW
BEGIN
	SET new.direccion_empleado = "Ninguno";
    SET new.telefono_empleado = "Ninguno";
END;

select nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, puesto_empleado
from empleados e
inner join catalogo_puestos c
	on e.id_puesto = c.id_puesto;

INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("diego", "gonzalez", "tijuana", "664", "admin", "123", 5); #5 para admin
INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("diego", "gonzalez", "tijuana", "664", "mariano", "123", 2); #5 para admin
select * from empleados;
INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("Deysi", "Rufino", "tijuana", "663", "cajero", "123", 4);
INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("Nora", "Ornelas", "tijuana", "663", "mesero", "123", 3);
INSERT INTO empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto)
VALUES("Carla", "Perez", "tijuana", "663", "admin2", "123", 2);
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

select * from empleados;

CREATE TABLE insumos (
  id_insumo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  cantidad INT NOT NULL,
  unidad_medida VARCHAR(20) NOT NULL
);

CREATE TABLE recetas (
  id_receta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(100),
  precio int NOT NULL
);

CREATE TABLE recetas_insumos (
  id_receta INT NOT NULL,
  id_insumo INT NOT NULL,
  cantidad_requerida INT NOT NULL,
  PRIMARY KEY (id_receta, id_insumo),
  FOREIGN KEY (id_receta) REFERENCES recetas (id_receta),
  FOREIGN KEY (id_insumo) REFERENCES insumos (id_insumo)
);

ALTER TABLE registro_jornada MODIFY COLUMN hora_salida TIME DEFAULT NULL;
