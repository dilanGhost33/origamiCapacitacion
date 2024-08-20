package org.capacitacion.mappers;

import org.capacitacion.dto.DetalleFacturaDto;
import org.capacitacion.entidad.DetalleFactura;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleFacturaMapper {
    DetalleFacturaDto toDto(DetalleFactura entity);
    DetalleFactura toEntity(DetalleFacturaDto dto);
    List<DetalleFacturaDto> toDto(List<DetalleFactura> entities);
}
