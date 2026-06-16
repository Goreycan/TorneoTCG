package com.example.TorneoTCG.dto;

import com.example.TorneoTCG.model.Torneo;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ParticipacionDTO {
   
    private Long id;

    private Jugador jugador;

    private Torneo torneo;

    private Integer rondaInscripcion;
}