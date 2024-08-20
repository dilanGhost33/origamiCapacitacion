/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.model;

import java.io.Serializable;
import java.util.Date;


public class Pregunta implements Serializable{

    private Long id;
    private String pregunta;
    private String estado;
    private String tipo;
    private Boolean requerida;
    private String usuarioRegistro;
    private String usuarioModifica;
    private Date fechaModifica;
    private Date fechaRegistro;

    public Pregunta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getRequerida() {
        return requerida;
    }

    public void setRequerida(Boolean requerida) {
        this.requerida = requerida;
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
        return "Pregunta{" + "id=" + id + ", pregunta=" + pregunta + ", estado=" + estado + ", tipo=" + tipo + ", requerida=" + requerida + ", usuarioRegistro=" + usuarioRegistro + ", usuarioModifica=" + usuarioModifica + ", fechaModifica=" + fechaModifica + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
}
