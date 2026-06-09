package com.example.TorneoTCG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TorneoTCG.model.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

}