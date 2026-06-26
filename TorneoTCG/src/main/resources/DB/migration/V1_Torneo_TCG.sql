CREATE TABLE region (
    id_region INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL
);


CREATE TABLE comuna (
    id_comuna INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    id_region INT,
    FOREIGN KEY (id_region) REFERENCES region(id_region)
);


CREATE TABLE organizador (
    id_organizador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    correo VARCHAR(30) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    cargo VARCHAR(20) NOT NULL,
    id_comuna INT,
    FOREIGN KEY (id_comuna) REFERENCES comuna(id_comuna)
);


CREATE TABLE recinto (
    id_recinto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    capacidad INT NOT NULL,
    id_comuna INT,
    FOREIGN KEY (id_comuna) REFERENCES comuna(id_comuna)
);


CREATE TABLE recinto_organizador (

    id_recinto INT,
    id_organizador INT,
    FOREIGN KEY (id_recinto) REFERENCES recinto(id_recinto),
    FOREIGN KEY (id_organizador) REFERENCES organizador(id_organizador)
);
