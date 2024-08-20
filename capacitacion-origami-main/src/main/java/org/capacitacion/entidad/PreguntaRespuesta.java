package org.capacitacion.entidad;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "pregunta_respuesta", schema = "aplicacion")
public class PreguntaRespuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // private Long persona;
    private String respuesta;
    private Boolean realizada;
    private Integer calificacion;

    private String usuarioRegistra;
    private String usuarioModifica;
    private Date fechaModdftca;
    private Date fechaRegistro;

    @JoinColumn(name = "pregunta")
    @ManyToOne
    private Pregunta pregunta;

    public PreguntaRespuesta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public Long getPersona() {
        return persona;
    }

    public void setPersona(Long persona) {
        this.persona = persona;
    }*/

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistra = usuarioRegistro;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaModifica() {
        return fechaModdftca;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModdftca = fechaModifica;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
