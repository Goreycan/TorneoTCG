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

import com.example.TorneoTCG.dto.CartaDTO;
import com.example.TorneoTCG.model.Carta;
import com.example.TorneoTCG.repository.CartaRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class CartaServiceTest {

    @InjectMocks
    private CartaService cartaService;

    @Mock
    private CartaRepository cartaRepository;

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
        String rareza = "Rara";
        Integer costo = faker.number().numberBetween(1, 10);

        Carta mockEntity = Carta.builder()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .rareza(rareza)
                .costo(costo)
                .cartaMazos(new ArrayList<>())
                .build();

        when(cartaRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // WHEN:
        CartaDTO resultado = cartaService.buscarPorId(id);

        // THEN:
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals(nombre, resultado.getNombre());
        assertEquals(descripcion, resultado.getDescripcion());
        assertEquals(rareza, resultado.getRareza());
        assertEquals(costo, resultado.getCosto());
        verify(cartaRepository, times(1)).findById(id);
    }
}
