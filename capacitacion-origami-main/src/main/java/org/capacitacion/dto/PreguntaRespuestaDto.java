package org.capacitacion.dto;

import java.util.Date;

public class PreguntaRespuestaDto {

    private Long id;
    private Long preguntaId;
//    private Long persona;
    private String respuesta;
    private Boolean realizada;
    private Integer calificacion;

    private String usuarioRegistra;
    private String usuarioModifica;
    private Date fechaModifica;
    private Date fechaRegistro;

    public PreguntaRespuestaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

//    public Long getPersona() {
//        return persona;
//    }
//
//    public void setPersona(Long persona) {
//        this.persona = persona;
//    }

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
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
