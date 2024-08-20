package org.capacitacion.mappers;

import org.capacitacion.dto.ProductoDto;
import org.capacitacion.entidad.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDto toDto(Producto entity);
    Producto toEntity(ProductoDto dto);
    List<ProductoDto> toDto(List<Producto> entities);
}
