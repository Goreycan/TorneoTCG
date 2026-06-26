package com.example.TorneoTCG.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TorneoTCG.dto.PartidaDTO;
import com.example.TorneoTCG.model.Partida;
import com.example.TorneoTCG.repository.PartidaRepository;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<PartidaDTO> obtenerTodos() {

        List<PartidaDTO> listaDTO = new ArrayList<>();

        List<Partida> partidas = partidaRepository.findAll();

        for (Partida partida : partidas) {
            listaDTO.add(convertirADTO(partida));
        }

        return listaDTO;
    }

    public PartidaDTO buscarPorId(Long id) {

        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Partida no encontrada"));

        return convertirADTO(partida);
    }

    public PartidaDTO guardar(Partida partida) {

        Partida guardada = partidaRepository.save(partida);

        return convertirADTO(guardada);
    }

    public PartidaDTO actualizar(Long id, Partida partida) {
    Partida existente = partidaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Partida no encontrada"));
    existente.setMesa(partida.getMesa());
    existente.setEstado(partida.getEstado());
    existente.setRonda(partida.getRonda());
    existente.setCantidadJugadores(partida.getCantidadJugadores());
    existente.setJugador1(partida.getJugador1());
    existente.setJugador2(partida.getJugador2());
    existente.setJugador3(partida.getJugador3());
    existente.setJugador4(partida.getJugador4());
    existente.setJugador5(partida.getJugador5());
    Partida actualizada = partidaRepository.save(existente);
    return convertirADTO(actualizada);
}

    public String eliminar(Long id) {
    if (partidaRepository.existsById(id)) {
        partidaRepository.deleteById(id);
        return "Partida eliminada correctamente";
    } else {
        return "Partida no encontrada";
    }
}

    private PartidaDTO convertirADTO(Partida partida) {

        PartidaDTO dto = new PartidaDTO();

        dto.setId(partida.getId());
        dto.setMesa(partida.getMesa());
        dto.setEstado(partida.getEstado());
        dto.setCantidadJugadores(partida.getCantidadJugadores());

        dto.setIdRonda(
                partida.getRonda().getId()
        );

        dto.setIdJugador1(
                partida.getJugador1().getId()
        );

        dto.setIdJugador2(
                partida.getJugador2().getId()
        );

        dto.setIdJugador3(
                partida.getJugador3().getId()
        );

        if (partida.getJugador4() != null) {
            dto.setIdJugador4(
                    partida.getJugador4().getId()
            );
        }

        if (partida.getJugador5() != null) {
            dto.setIdJugador5(
                    partida.getJugador5().getId()
            );
        }

        return dto;
    }
}