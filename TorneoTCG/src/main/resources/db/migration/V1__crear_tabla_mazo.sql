CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE mazo (
    id_mazo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(50),
    fecha_creacion DATE,
    estado VARCHAR(10),
    
    id_jugador INT NOT NULL
);
CREATE TABLE carta (
    id_carta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,                     
    rareza VARCHAR(20),                                 
    costo INT,     
    id_mazo INT NOT NULL                                     
);
CREATE TABLE carta_mazo (
    id_carta_mazo INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    id_mazo INT NOT NULL,
    id_carta INT NOT NULL, 
);