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

import com.example.TorneoTCG.dto.CartaMazoDTO;
import com.example.TorneoTCG.model.Carta;
import com.example.TorneoTCG.model.CartaMazo;
import com.example.TorneoTCG.model.Mazo;
import com.example.TorneoTCG.repository.CartaMazoRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
class CartaMazoServiceTest {

    @Mock
    private CartaMazoRepository cartaMazoRepository;
    
    @InjectMocks
    private CartaMazoService cartaMazoService; 
    
    private Faker faker = new Faker(); 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN: 
        Long idSimulado = 1L; 
        Integer cantidadSimulada = faker.number().numberBetween(1, 4); 
        
        // Creamos el Mazo simulado con Builder
        Mazo mazoFalso = Mazo.builder()
                .id(2L)
                .nombre("Mazo Fuego")
                .build();

        // Creamos la Carta simulada con Builder
        Carta cartaFalsa = Carta.builder()
                .id(3L)
                .nombre("Dragón")
                .build();

        // Armamos el CartaMazo uniendo todo
        CartaMazo cartaMazoFalsa = CartaMazo.builder()
                .id(idSimulado)
                .cantidad(cantidadSimulada)
                .mazo(mazoFalso)
                .carta(cartaFalsa)
                .build();
        
        when(cartaMazoRepository.findById(idSimulado)).thenReturn(Optional.of(cartaMazoFalsa));
        
        // WHEN: Ejecutamos el servicio
        CartaMazoDTO resultado = cartaMazoService.buscarPorId(idSimulado);
        
        // THEN: Verificamos los mapeos
        assertNotNull(resultado, "El DTO resultante no debería ser nulo");
        assertEquals(cantidadSimulada, resultado.getCantidad());
        
        verify(cartaMazoRepository, times(1)).findById(idSimulado);
    }
}
