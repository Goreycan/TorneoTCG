package com.example.TorneoTCG.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.TorneoTCG.controller.CartaController;
import com.example.TorneoTCG.dto.CartaDTO;

@Component
public class CartaModelAssembler implements RepresentationModelAssembler<CartaDTO, EntityModel<CartaDTO>> {

    @Override
    public EntityModel<CartaDTO> toModel(CartaDTO dto) {
        return EntityModel.of(dto,
            linkTo(methodOn(CartaController.class).buscarPorId(dto.getId())).withSelfRel(),
            linkTo(methodOn(CartaController.class).todasLasCartas()).withRel("todas")
        );
    }
}
