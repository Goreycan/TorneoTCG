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

import com.example.TorneoTCG.dto.CartaDTO;
import com.example.TorneoTCG.model.Carta;
import com.example.TorneoTCG.repository.CartaRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
class CartaServiceTest {

    @Mock
    private CartaRepository cartaRepository;
    
    @InjectMocks
    private CartaService cartaService; 
    
    private Faker faker = new Faker(); 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN: Dada una carta en la base de datos
        Long idSimulado = 99L; 
        String nombreCarta = faker.superhero().name(); 
        
        // Usamos tu @Builder
        Carta cartaFalsa = Carta.builder()
                .id(idSimulado)
                .nombre(nombreCarta)
                .build();
        
        when(cartaRepository.findById(idSimulado)).thenReturn(Optional.of(cartaFalsa));
        
        // WHEN: Consultamos la carta
        CartaDTO resultado = cartaService.buscarPorId(idSimulado);
        
        // THEN: Confirmamos la respuesta
        assertNotNull(resultado, "El DTO resultante no debería ser nulo");
        assertEquals(nombreCarta, resultado.getNombre(), "El nombre de la carta debe coincidir");
        verify(cartaRepository, times(1)).findById(idSimulado);
    }
}
