package com.example.TorneoTCG.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.TorneoTCG.dto.JugadorDTO;
import com.example.TorneoTCG.model.Jugador;
import com.example.TorneoTCG.repository.JugadorRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class JugadorServiceTest {

    @InjectMocks
    private JugadorService jugadorService;

    @Mock
    private JugadorRepository jugadorRepository;

    private Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN:
        Long id = faker.number().randomNumber();
        String nombre = faker.name().firstName();
        String email = faker.internet().emailAddress();

        Jugador mockEntity = Jugador.builder()
                .id(id.intValue())
                .nombre(nombre)
                .email(email)
                .mazos(new ArrayList<>())
                .build();

        when(jugadorRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // WHEN:
        JugadorDTO resultado = jugadorService.buscarPorId(id);

        // THEN:
        assertNotNull(resultado);
        assertEquals(id.intValue(), resultado.getId());
        assertEquals(nombre, resultado.getNombre());
        assertEquals(email, resultado.getEmail());
        verify(jugadorRepository, times(1)).findById(id);
    }
}
