package com.example.TorneoTCG.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.TorneoTCG.controller.JugadorController;
import com.example.TorneoTCG.dto.JugadorDTO;

@Component
public class JugadorModelAssembler implements RepresentationModelAssembler<JugadorDTO, EntityModel<JugadorDTO>> {

    @Override
    public EntityModel<JugadorDTO> toModel(JugadorDTO dto) {
        Long idLong = dto.getId() != null ? dto.getId().longValue() : null;
        return EntityModel.of(dto,
            linkTo(methodOn(JugadorController.class).buscarPorId(idLong)).withSelfRel(),
            linkTo(methodOn(JugadorController.class).listarTodos()).withRel("todos")
        );
    }
}
