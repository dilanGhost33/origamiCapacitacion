package org.capacitacion.mappers;

import org.capacitacion.dto.MarcacionDto;
import org.capacitacion.entidad.Marcacion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarcacionMapper {

    MarcacionDto toDto(Marcacion entity);
    Marcacion toEntity(MarcacionDto dto);
    List<MarcacionDto> toDto(List<Marcacion> entities);

}
