package com.example.TorneoTCG.DTO;

import lombok.Data;

@Data
public class RecintoExternoDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private Integer capacidad;
    private Long comunaId;
    private ComunaDTO comuna;
}
