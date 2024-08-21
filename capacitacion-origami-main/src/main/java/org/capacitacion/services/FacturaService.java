package org.capacitacion.services;

import org.capacitacion.dto.DetalleFacturaDto;
import org.capacitacion.dto.FacturaDto;
import org.capacitacion.dto.ProductoDto;
import org.capacitacion.entidad.Cliente;
import org.capacitacion.entidad.DetalleFactura;
import org.capacitacion.entidad.Factura;
import org.capacitacion.entidad.Producto;
import org.capacitacion.mappers.ClienteMapper;
import org.capacitacion.mappers.FacturaMapper;
import org.capacitacion.respository.ClienteRepository;
import org.capacitacion.respository.DetalleFacturaRepository;
import org.capacitacion.respository.FacturaRepository;
import org.capacitacion.respository.ProductoRepository;
import org.capacitacion.vo.DetalleFacturaVo;
import org.capacitacion.vo.FacturaVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private FacturaMapper facturaMapper;
    @Autowired
    private ClienteMapper clienteMapper;
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }
    public List<FacturaDto> findAllFacturas() {
        List<FacturaDto> result = facturaMapper.toDto(facturaRepository.findAll());
        return result;
    }
    public String delete(Long id){
        facturaRepository.deleteById(id);
        return "La factura se eliminó";
    }
    public FacturaDto findFacturaById(Long id) {
        Factura factura = facturaRepository.findByIdWithDetailsAndProducts(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con id: " + id));
        return mapEntitytoDetailDto(factura);
    }

    public FacturaDto mapEntitytoDetailDto(Factura entity){
        FacturaDto result = new FacturaDto();
        result.setCliente(clienteMapper.toDto(entity.getCliente()));

        BeanUtils.copyProperties(entity, result);
         List<DetalleFacturaDto> resultList = new ArrayList<>();
        for (DetalleFactura fac: entity.getDetalleFacturas() ) {
            DetalleFacturaDto deatil= mapToDeatil(fac);
            resultList.add(deatil);
        }
        result.setDetalles(resultList);
        return result;
    }

    private DetalleFacturaDto mapToDeatil(DetalleFactura fac) {
        DetalleFacturaDto detail= new DetalleFacturaDto();

        BeanUtils.copyProperties(fac,detail);

        detail.setProducto(mapProduct(fac.getProducto()));

        return detail;
    }
     private ProductoDto mapProduct(Producto original) {
         ProductoDto result= new ProductoDto();
         BeanUtils.copyProperties(original,result);
         return result;
     }
//
    public Object guardarFactura(FacturaVo facturaVo){
        Factura factura = new Factura();
        BeanUtils.copyProperties(facturaVo,factura);

        if (facturaVo.getIdCliente() > 0) {
            Cliente cliente = clienteRepository.findById(facturaVo.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: "  ));
            factura.setCliente(cliente);
        }
        if (factura.getFecha() == null) {
            factura.setFecha(new Date());
        }
        facturaRepository.save(factura);
        if (facturaVo.getDetalles() != null && !facturaVo.getDetalles().isEmpty()) {
           createFacturaDeatils(factura, facturaVo.getDetalles());
       }
        return mapEntitytoDetailDto(factura);
   }

    private void createFacturaDeatils(Factura factura, List<DetalleFacturaVo> deatils) {
        for (DetalleFacturaVo detail: deatils) {
            try {
                DetalleFactura entity = new DetalleFactura();
                entity.setFactura(factura);
                Producto producto = productoRepository.findById(detail.getIdProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + detail.getIdProducto()));

                entity.setCantidad(detail.getCantidad());
                entity.setProducto(producto);
                entity.setPrecioUnitario(producto.getPrecio());
                entity.setSubtotal(detail.getCantidad() * producto.getPrecio());
                detalleFacturaRepository.save(entity);
            }catch (Exception e){
                System.err.println("Error creating workday detail: " + e.getMessage());
                e.printStackTrace();

            }
        }
    }


}
