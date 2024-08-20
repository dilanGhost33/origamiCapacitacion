package org.capacitacion.resource;

import org.capacitacion.dto.MarcacionDto;
import org.capacitacion.services.MarcacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcacionResource {
    @Autowired
    private MarcacionService marcacionService;

    @PostMapping("/registrarMarcacion")
    public ResponseEntity<?> registrarMarcacion(@RequestBody MarcacionDto marcacionDto) {
        return ResponseEntity.ok(marcacionService.registrarMarcacion(marcacionDto));
    }

}
