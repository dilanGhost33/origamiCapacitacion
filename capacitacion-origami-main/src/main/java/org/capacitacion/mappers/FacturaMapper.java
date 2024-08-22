package org.capacitacion.mappers;

import org.capacitacion.dto.FacturaConDetallesDto;
import org.capacitacion.dto.FacturaDto;
import org.capacitacion.entidad.Factura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
    @Mapping(source = "detalleFacturas", target = "detalles")
    FacturaDto toDto(Factura entity);
    Factura toEntity(FacturaDto dto);
    List<FacturaDto> toDto(List<Factura> entities);



}
