package org.capacitacion.resource;

import org.capacitacion.dto.ClienteDto;
import org.capacitacion.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<?> getCliente(){
        return ResponseEntity.ok(clienteService.getProducts());
    }

    @PostMapping("/guardarcliente")
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDto Dto) {
        return ResponseEntity.ok(clienteService.guardar(Dto));
    }
    @DeleteMapping("/borrarcliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.delete(id));
    }
}
