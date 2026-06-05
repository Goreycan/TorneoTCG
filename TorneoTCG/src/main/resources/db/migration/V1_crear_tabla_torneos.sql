
CREATE TABLE torneos (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   fechaInicio Date NOT NULL,
   fechaFin Date NOT NULL,
   estado VARCHAR NOT NULL,
   ubicacion VARCHAR(50) NOT NULL,
   id_recinto INT(20) NOT NUll,  
)
