/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.proyecto.config.Constantes;
import org.proyecto.model.Pregunta;
import org.proyecto.model.PreguntaRespuesta;
import org.proyecto.services.intefaces.AppServices;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class PreguntaMB implements Serializable{
    
    @Inject 
    private AppServices appServices;
    
    private List<Pregunta> preguntas;
    
    private List<PreguntaRespuesta> respuestas;

    private PreguntaRespuesta respuesta;
    private Pregunta pregunta;
    
    @PostConstruct
    public void init(){
        System.out.println("init");
        cargarDatos();
    }
    private void cargarDatos(){
        pregunta = new Pregunta();
        preguntas = appServices.methodListGET(Constantes.appUrl+"preguntas", Pregunta[].class);
    }
    public void editarPregunta(Pregunta p){
        pregunta = p;
    }
    
    public void guardarPregunta(){
        pregunta.setUsuarioRegistro("admin");
        Pregunta p = (Pregunta) appServices.methodPOST(pregunta,Constantes.appUrl+"guardarpregunta", Pregunta.class);
        System.out.println("pregunta guardada"+ p.toString());
        cargarDatos();
    }
    
    
    public void cargarRespuestas(Pregunta p){
        pregunta = p;
        respuesta = new PreguntaRespuesta();
        respuestas = appServices.methodListGET(Constantes.appUrl+"respuestas/"+pregunta.getId(), PreguntaRespuesta[].class);
        System.out.println(""+respuestas.size());
        

    }
    public void guardarRespuesta(){
        if (respuesta == null) {
            respuesta = new PreguntaRespuesta();
        }
        respuesta.setPreguntaId(pregunta.getId());
        PreguntaRespuesta r = (PreguntaRespuesta) appServices.methodPOST(respuesta, 
                                                  Constantes.appUrl+"guardarrespuesta/"+pregunta.getId(), PreguntaRespuesta.class);
        System.out.println("Respuesta guardada: " + r.toString());
        cargarRespuestas(pregunta);
    }
    public void crearEncuesta(){
        
        String respuesta= (String) appServices.methodPOST(Constantes.appUrl+"crearencuesta", String.class);
        System.out.println("Respuesta guardada: " );
    }

     

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<PreguntaRespuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<PreguntaRespuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public PreguntaRespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(PreguntaRespuesta respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
    
    
    
}
