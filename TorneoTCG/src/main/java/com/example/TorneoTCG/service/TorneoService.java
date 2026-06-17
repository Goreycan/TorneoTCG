package com.example.TorneoTCG.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TorneoTCG.dto.TorneoDTO;
import com.example.TorneoTCG.model.Torneo;
import com.example.TorneoTCG.repository.TorneoRepository;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    public List<TorneoDTO> obtenerTodos() {

        List<TorneoDTO> listaDTO = new ArrayList<>();

        List<Torneo> torneos = torneoRepository.findAll();

        for (Torneo torneo : torneos) {
            listaDTO.add(convertirADTO(torneo));
        }

        return listaDTO;
    }

    public TorneoDTO buscarPorId(Long id) {

        Torneo torneo = torneoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Torneo no encontrado"));

        return convertirADTO(torneo);
    }

    public TorneoDTO guardar(Torneo torneo) {

        Torneo guardado = torneoRepository.save(torneo);

        return convertirADTO(guardado);
    }

    private TorneoDTO convertirADTO(Torneo torneo) {

        TorneoDTO dto = new TorneoDTO();

        dto.setId(torneo.getId());
        dto.setNombre(torneo.getNombre());
        dto.setFechaInicio(torneo.getFechaInicio());
        dto.setFechaFin(torneo.getFechaFin());
        dto.setEstado(torneo.getEstado());
        dto.setIdRecinto(torneo.getIdRecinto());

        return dto;
    }
}