package org.capacitacion.resource;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.dto.ProductoDto;
import org.capacitacion.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoResource {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<?> getProducto(){
        return ResponseEntity.ok(productoService.getProducts());
    }

    @PostMapping("/guardarproducto")
    public ResponseEntity<?> guardarProducto(@RequestBody ProductoDto Dto) {
        return ResponseEntity.ok(productoService.guardar(Dto));
    }
    @DeleteMapping("/borrarproducto/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.delete(id));
    }
    
}
