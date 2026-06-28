package com.example.TorneoTCG.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.TorneoTCG.controller.CartaMazoController;
import com.example.TorneoTCG.dto.CartaMazoDTO;

@Component
public class CartaMazoModelAssembler implements RepresentationModelAssembler<CartaMazoDTO, EntityModel<CartaMazoDTO>> {

    @Override
    public EntityModel<CartaMazoDTO> toModel(CartaMazoDTO dto) {
        return EntityModel.of(dto,
            linkTo(methodOn(CartaMazoController.class).buscarPorId(dto.getId())).withSelfRel(),
            linkTo(methodOn(CartaMazoController.class).listarTodo()).withRel("todos")
        );
    }
}
