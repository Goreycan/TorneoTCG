
CREATE TABLE mazo (
    id_mazo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(50),
    fecha_creacion DATE,
    estado VARCHAR(10),
    
    id_jugador INT NOT NULL
);