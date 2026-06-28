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
import com.example.TorneoTCG.repository.CartaRepository;
import com.example.TorneoTCG.repository.MazoRepository;

import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class CartaMazoServiceTest {

    @InjectMocks
    private CartaMazoService cartaMazoService;

    @Mock
    private CartaMazoRepository cartaMazoRepository;

    @Mock
    private CartaRepository cartaRepository;

    @Mock
    private MazoRepository mazoRepository;

    private Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_Exitoso() {
        // GIVEN:
        Long id = faker.number().randomNumber();
        Integer cantidad = faker.number().numberBetween(1, 4);

        Mazo mazo = Mazo.builder()
                .id(faker.number().randomNumber())
                .nombre(faker.lorem().word())
                .build();

        Carta carta = Carta.builder()
                .id(faker.number().randomNumber())
                .nombre(faker.lorem().word())
                .build();

        CartaMazo mockEntity = CartaMazo.builder()
                .id(id)
                .cantidad(cantidad)
                .mazo(mazo)
                .carta(carta)
                .build();

        when(cartaMazoRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // WHEN:
        CartaMazoDTO resultado = cartaMazoService.buscarPorId(id);

        // THEN:
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals(cantidad, resultado.getCantidad());
        assertEquals(mazo.getNombre(), resultado.getNombreMazo());
        assertEquals(carta.getNombre(), resultado.getNombreCarta());
        verify(cartaMazoRepository, times(1)).findById(id);
    }
}
