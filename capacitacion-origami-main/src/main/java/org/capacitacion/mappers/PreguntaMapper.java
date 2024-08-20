package org.capacitacion.mappers;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.entidad.Pregunta;
import org.capacitacion.entidad.PreguntaRespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreguntaMapper {

    PreguntaDto toDto(Pregunta entity);

    Pregunta toEntity(PreguntaDto dto);


    List<PreguntaDto> toDto(List<Pregunta> entities);
    PreguntaRespuestaDto respuestaToDto(PreguntaRespuesta respuesta);
    PreguntaRespuesta respuestaToEntity(PreguntaRespuestaDto dto);


}
