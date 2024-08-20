package org.capacitacion.mappers;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.entidad.Pregunta;
import org.capacitacion.entidad.PreguntaRespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreguntaRespuestaMapper {

    PreguntaRespuestaDto toDto(PreguntaRespuesta entity);

    PreguntaRespuesta toEntity(PreguntaRespuestaDto dto);



}
