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
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_empleado INT NOT NULL,
  fecha_venta DATE NOT NULL,
  total_venta DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_venta),
  FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Tabla de sueldos
CREATE TABLE sueldos (
  id_sueldo INT NOT NULL AUTO_INCREMENT,
  id_empleado INT NOT NULL,
  fecha_pago DATE NOT NULL,
  monto_sueldo DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_sueldo),
  FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
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
  nombre_empleado VARCHAR(50) NOT NULL,
  apellido_empleado VARCHAR(50) NOT NULL,
  direccion_empleado VARCHAR(100),
  telefono_empleado VARCHAR(20),
  puesto_empleado VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_empleado)
);

select usuario, password from usuarios
where usuario="Admin" and password="12345";