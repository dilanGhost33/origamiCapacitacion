package org.capacitacion.services;

import org.capacitacion.dto.ProductoDto;
import org.capacitacion.entidad.Producto;
import org.capacitacion.mappers.ProductoMapper;
import org.capacitacion.respository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public List<ProductoDto> getProducts() {
        List<ProductoDto> result= productoMapper.toDto(productoRepository.findAll());
        return result;
    }

    public ProductoDto guardar(ProductoDto productoDto){
        Producto producto = productoMapper.toEntity(productoDto);
        productoRepository.save(producto);
        return productoMapper.toDto(producto);
    }
    public String delete(Long id){
        productoRepository.deleteById(id);
        return "El producto se eliminó";
    }

}
