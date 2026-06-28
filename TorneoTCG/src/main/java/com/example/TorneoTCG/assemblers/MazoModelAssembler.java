package com.example.TorneoTCG.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.TorneoTCG.controller.MazoController;
import com.example.TorneoTCG.dto.MazoDTO;

@Component
public class MazoModelAssembler implements RepresentationModelAssembler<MazoDTO, EntityModel<MazoDTO>> {

    @Override
    public EntityModel<MazoDTO> toModel(MazoDTO dto) {
        return EntityModel.of(dto,
            linkTo(methodOn(MazoController.class).buscarPorId(dto.getId())).withSelfRel(),
            linkTo(methodOn(MazoController.class).todosLosMazos()).withRel("todos")
        );
    }
}
