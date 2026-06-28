package com.example.TorneoTCG.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.TorneoTCG.dto.MazoDTO;
import com.example.TorneoTCG.model.Jugador;
import com.example.TorneoTCG.model.Mazo;
import com.example.TorneoTCG.repository.JugadorRepository;
import com.example.TorneoTCG.repository.MazoRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class MazoServiceTest {

    @InjectMocks
    private MazoService mazoService;

    @Mock
    private MazoRepository mazoRepository;

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
        String nombre = faker.lorem().word();
        String descripcion = faker.lorem().sentence();

        Jugador jugador = Jugador.builder()
                .id(faker.number().randomDigit())
                .nombre(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .build();

        Mazo mockEntity = Mazo.builder()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .jugador(jugador)
                .build();

        when(mazoRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // WHEN:
        MazoDTO resultado = mazoService.buscarPorId(id);

        // THEN:
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals(nombre, resultado.getNombre());
        assertEquals(descripcion, resultado.getDescripcion());
        assertEquals(jugador.getId(), resultado.getIdJugador());
        assertEquals(jugador.getNombre(), resultado.getNombreJugador());
        verify(mazoRepository, times(1)).findById(id);
    }
}
