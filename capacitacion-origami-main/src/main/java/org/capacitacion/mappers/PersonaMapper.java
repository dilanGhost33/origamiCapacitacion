package org.capacitacion.mappers;

import org.capacitacion.dto.PersonaDto;
import org.capacitacion.entidad.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDto toDto(Persona entity);

    Persona toEntity(PersonaDto dto);


    List<PersonaDto> toDto(List<Persona> entities);



}
