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

import com.example.TorneoTCG.dto.JugadorDTO;
import com.example.TorneoTCG.model.Jugador;
import com.example.TorneoTCG.repository.JugadorRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {

    @Mock
    private JugadorRepository jugadorRepository;
    
    @InjectMocks
    private JugadorService jugadorService; 
    
    private Faker faker = new Faker(); 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN: Dado un escenario inicial
        Long idSimulado = 10L; 
        String nombreAleatorio = faker.name().fullName(); 
        
        
        Jugador jugadorFalso = Jugador.builder()
                .id(idSimulado)
                .nombre(nombreAleatorio)
                .build();
        
        when(jugadorRepository.findById(idSimulado)).thenReturn(Optional.of(jugadorFalso));
        
        // WHEN: Cuando ejecutamos la acción
        JugadorDTO resultado = jugadorService.buscarPorId(idSimulado);
        
        // THEN: Entonces validamos
        assertNotNull(resultado, "El DTO resultante no debería ser nulo");
        assertEquals(nombreAleatorio, resultado.getNombre(), "El nombre debe coincidir con el de la DB");
        verify(jugadorRepository, times(1)).findById(idSimulado);
    }
}