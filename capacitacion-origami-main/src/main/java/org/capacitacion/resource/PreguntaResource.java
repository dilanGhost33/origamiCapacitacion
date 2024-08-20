package org.capacitacion.resource;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.dto.preguntaConRespuestasDto;
import org.capacitacion.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreguntaResource {

    @Autowired
    private PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<?> getPregunta(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/guardarpregunta")
    public ResponseEntity<?> guardarPregunta(@RequestBody PreguntaDto preguntaDto) {
        return ResponseEntity.ok(service.guardar(preguntaDto));
    }

    @GetMapping("/conrespuestas")
    public ResponseEntity<List<preguntaConRespuestasDto>> getPreguntasConRespuestas() {
        return ResponseEntity.ok(service.findAllWithResponses());
    }
    @GetMapping("/respuestas/{id}")
    public ResponseEntity<?> getRespuestas(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.obtenerRespuestasPorPreguntaId(id));
    }
    @PostMapping("/guardarrespuesta/{id}")
    public ResponseEntity<?> guardarRespuesta(@PathVariable("id") Long id ,
                                              @RequestBody PreguntaRespuestaDto preguntaRespuestaDto) {
        return ResponseEntity.ok(service.guardarRespuesta(id,preguntaRespuestaDto));
    }

    @PostMapping("/crearencuesta")
    public ResponseEntity<?> crearEncuesta() {
        return ResponseEntity.ok(service.crearEncuesta());
    }


}
