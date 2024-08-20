package org.capacitacion.mappers;
import org.capacitacion.dto.ClienteDto;
import org.capacitacion.entidad.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ClienteMapper {
    ClienteDto toDto(Cliente entity);
    Cliente toEntity(ClienteDto dto);
    List<ClienteDto> toDto(List<Cliente> entities);
}
