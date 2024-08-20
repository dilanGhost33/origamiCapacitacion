package org.capacitacion.dto;
import java.util.List;
public class preguntaConRespuestasDto {
    private PreguntaDto pregunta;
    private List<PreguntaRespuestaDto> respuestas;

    public preguntaConRespuestasDto(PreguntaDto pregunta, List<PreguntaRespuestaDto> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    // Constructor, getters y setters
    public PreguntaDto getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaDto pregunta) {
        this.pregunta = pregunta;
    }

    public List<PreguntaRespuestaDto> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<PreguntaRespuestaDto> respuestas) {
        this.respuestas = respuestas;
    }
}
