/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.model;

/**
 *
 * @author PC
 */

import java.io.Serializable;
import java.util.Date;

public class PreguntaRespuesta implements Serializable{

    private Long id;
    private Long preguntaId;
//    private Long persona;
    private String respuesta;
    private Boolean realizada;
    private Integer calificacion;

    private String usuarioRegistro;
    private String usuarioModifica;
    private Date fechaModifica;
    private Date fechaRegistro;

    public PreguntaRespuesta() {
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
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
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

    @Override
    public String toString() {
        return "PreguntaRespuesta{" + "id=" + id + ", preguntaId=" + preguntaId + ", respuesta=" + respuesta + ", realizada=" + realizada + ", calificacion=" + calificacion + ", usuarioRegistro=" + usuarioRegistro + ", usuarioModifica=" + usuarioModifica + ", fechaModifica=" + fechaModifica + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}
