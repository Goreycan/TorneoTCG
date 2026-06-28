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
import com.example.TorneoTCG.model.Mazo;
import com.example.TorneoTCG.repository.MazoRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
class MazoServiceTest {

    @Mock
    private MazoRepository mazoRepository;
    
    @InjectMocks
    private MazoService mazoService; 
    
    private Faker faker = new Faker(); 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN: Dado un mazo simulado
        Long idSimulado = 5L; 
        String nombreMazo = faker.book().title(); 
        
        // Usamos tu @Builder para crear el mazo falso
        Mazo mazoFalso = Mazo.builder()
                .id(idSimulado)
                .nombre(nombreMazo)
                .build();
        
        when(mazoRepository.findById(idSimulado)).thenReturn(Optional.of(mazoFalso));
        
        // WHEN: Cuando buscamos el mazo
        MazoDTO resultado = mazoService.buscarPorId(idSimulado);
        
        // THEN: Verificamos los resultados
        assertNotNull(resultado, "El DTO resultante no debería ser nulo");
        assertEquals(nombreMazo, resultado.getNombre(), "El nombre del mazo debe coincidir");
        verify(mazoRepository, times(1)).findById(idSimulado);
    }
}
