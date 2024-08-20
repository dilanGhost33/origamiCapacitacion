/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.proyecto.config.Constantes;
import org.proyecto.model.Persona;
import org.proyecto.services.intefaces.AppServices;

/**
 *
 * @author ORIGAMI
 */
@ViewScoped
@Named
public class PersonaMB implements Serializable {

    private static final Logger LOG = Logger.getLogger(PersonaMB.class.getName());

    @Inject
    private AppServices appServices;

    private List<Persona> personas;

    @PostConstruct
    public void init() {
        try {
            LOG.info("init");
            personas = appServices.methodListGET(
                    Constantes.appUrl + "consultarPersonas", Persona[].class);
            LOG.info("personas: " + personas.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

}
