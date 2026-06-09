
CREATE TABLE torneo (
   id_torneo INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   fechaInicio Date NOT NULL,
   fechaFin Date NOT NULL,
   estado VARCHAR NOT NULL,
   ubicacion VARCHAR(50) NOT NULL,
   id_recinto INT(1) NOT NUll,  
);

CREATE TABLE ronda (
    id_ronda INT AUTO_INCREMENT PRIMARY KEY,
    numero_ronda INT NOT NULL,
    fecha DATE NOT NULL,
    id_torneo INT NOT NULL,
    CONSTRAINT fk_ronda_torneo FOREIGN KEY (id_torneo) REFERENCES torneo(id_torneo)
);

CREATE TABLE partida (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    mesa VARCHAR(10) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    cantidad_jugadores INT NOT NULL,
    id_ronda INT NOT NULL,
    id_jugador1 INT NOT NULL,
    id_jugador2 INT NOT NULL,
    id_jugador3 INT NOT NULL,
    id_jugador4 INT,
    id_jugador5 INT,
    CONSTRAINT fk_partida_ronda FOREIGN KEY (id_ronda) REFERENCES ronda(id_ronda)
);

CREATE TABLE resultado (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_partida INT NOT NULL UNIQUE,
    id_ganador INT NOT NULL,
    puntaje_jugador1 INT,
    puntaje_jugador2 INT,
    puntaje_jugador3 INT,
    puntaje_jugador4 INT,
    puntaje_jugador5 INT,
    posicion_jugador1 INT,
    posicion_jugador2 INT,
    posicion_jugador3 INT,
    posicion_jugador4 INT,
    posicion_jugador5 INT,
    CONSTRAINT fk_resultado_partida FOREIGN KEY (id_partida) REFERENCES partida(id_partida)
);