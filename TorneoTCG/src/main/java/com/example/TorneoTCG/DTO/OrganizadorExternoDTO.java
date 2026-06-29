package com.example.TorneoTCG.DTO;

import lombok.Data;

@Data
public class OrganizadorExternoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;
}
