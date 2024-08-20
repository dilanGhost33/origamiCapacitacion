package org.capacitacion.services;

import jakarta.persistence.EntityNotFoundException;
import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.dto.preguntaConRespuestasDto;
import org.capacitacion.entidad.Pregunta;
import org.capacitacion.entidad.PreguntaRespuesta;
import org.capacitacion.mappers.PreguntaMapper;
import org.capacitacion.respository.PreguntaRepository;
import org.capacitacion.respository.PreguntaRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private PreguntaRespuestaRepository preguntaRespuestaRepository;
    @Autowired
    private PreguntaMapper preguntaMapper;

    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    public List<PreguntaDto> findAll() {
        List<PreguntaDto> result = preguntaMapper.toDto(preguntaRepository.findAllByOrderByIdDesc());
        return  result;
    }
    public PreguntaDto guardar(PreguntaDto preguntaDto){
        Pregunta pregunta = preguntaMapper.toEntity(preguntaDto);
        if (pregunta.getFechaRegistro() == null){
            pregunta.setFechaRegistro(new Date());
        }
        preguntaRepository.save(pregunta);
        return preguntaMapper.toDto(pregunta);
    }
    public PreguntaRespuestaDto guardarRespuesta(long preguntaId, PreguntaRespuestaDto preguntaRespuestaDto) {
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con id: " + preguntaId));
        PreguntaRespuesta respuesta = preguntaMapper.respuestaToEntity(preguntaRespuestaDto);
        respuesta.setPregunta(pregunta);
        // Asumiendo que la respuesta real está en preguntaRespuestaDto.getRespuesta()
        respuesta.setRespuesta(preguntaRespuestaDto.getRespuesta());
        PreguntaRespuesta respuestaGuardada = preguntaRespuestaRepository.save(respuesta);
        return preguntaMapper.respuestaToDto(respuestaGuardada);
    }
    public List<preguntaConRespuestasDto> findAllWithResponses() {
        List<PreguntaDto> preguntas = findAll();
        return preguntas.stream()
                .map(pregunta -> {
                    List<PreguntaRespuestaDto> respuestas = preguntaRespuestaRepository
                            .findAllByPregunta_Id(pregunta.getId())
                            .stream()
                            .map(preguntaMapper::respuestaToDto)
                            .collect(Collectors.toList());
                    return new preguntaConRespuestasDto(pregunta, respuestas);
                })
                .collect(Collectors.toList());
    }

    public List<PreguntaRespuestaDto> obtenerRespuestasPorPreguntaId(long preguntaId) {
        // Primero, verificamos si la pregunta existe
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con id: " + preguntaId));

        // Obtenemos todas las respuestas asociadas a esta pregunta
        List<PreguntaRespuesta> respuestas = preguntaRespuestaRepository.findAllByPregunta_Id(pregunta.getId());

        // Mapeamos las entidades a DTOs
        return respuestas.stream()
                .map(preguntaMapper::respuestaToDto)
                .collect(Collectors.toList());
    }

    public String crearEncuesta(){
        List<PreguntaDto> preguntas= findAll();
        for (PreguntaDto p:preguntas) {
            PreguntaRespuesta r = new PreguntaRespuesta();
            r.setPregunta(new Pregunta(p.getId()));
            r.setCalificacion(0);
            r.setRealizada(false);
            r.setFechaRegistro(new Date());
            r.setUsuarioRegistro("admin");
            preguntaRespuestaRepository.save(r);
        }
        return "ok";
    }




}
