package com.example.TorneoTCG.DTO;

import lombok.Data;

@Data
public class ComunaExternoDTO {
    private Long id;
    private String nombre;
    private RegionExternoDTO region;
}
