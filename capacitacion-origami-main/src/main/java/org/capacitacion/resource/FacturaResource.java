package org.capacitacion.resource;

import org.capacitacion.dto.FacturaConDetallesDto;
import org.capacitacion.dto.FacturaDto;
import org.capacitacion.services.FacturaService;
import org.capacitacion.vo.FacturaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FacturaResource {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas")
    public ResponseEntity<?> getFacturas(){
        return ResponseEntity.ok(facturaService.findAllFacturas());
    }

    @PostMapping("/guardarfactura")
    public ResponseEntity<?> guardarFactura(@RequestBody FacturaVo dto){
        return ResponseEntity.ok(facturaService.guardarFactura(dto));
    }
   @GetMapping("/facturas/{id}")
    public ResponseEntity<?> getFactura(@PathVariable Long id) {
        FacturaDto factura = facturaService.findFacturaById(id);
        return ResponseEntity.ok(factura);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.delete(id));
    }



}
