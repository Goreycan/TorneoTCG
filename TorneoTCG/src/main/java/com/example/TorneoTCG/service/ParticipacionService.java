package com.example.TorneoTCG.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TorneoTCG.dto.ParticipacionDTO;
import com.example.TorneoTCG.model.Participacion;
import com.example.TorneoTCG.repository.ParticipacionRepository;

@Service
public class ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    public List<ParticipacionDTO> obtenerTodos() {

        List<ParticipacionDTO> listaDTO = new ArrayList<>();

        List<Participacion> participaciones =
                participacionRepository.findAll();

        for (Participacion participacion : participaciones) {
            listaDTO.add(convertirADTO(participacion));
        }

        return listaDTO;
    }

    public ParticipacionDTO buscarPorId(Long id) {

        Participacion participacion =
                participacionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Participación no encontrada"));

        return convertirADTO(participacion);
    }

    public ParticipacionDTO guardar(Participacion participacion) {

        Participacion guardada =
                participacionRepository.save(participacion);

        return convertirADTO(guardada);
    }

    private ParticipacionDTO convertirADTO(
            Participacion participacion) {

        ParticipacionDTO dto = new ParticipacionDTO();

        dto.setId(participacion.getId());

        dto.setIdJugador(
                participacion.getJugador().getId()
        );

        dto.setIdTorneo(
                participacion.getTorneo().getId()
        );

        dto.setRondaInscripcion(
                participacion.getRondaInscripcion()
        );

        return dto;
    }
}