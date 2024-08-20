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
import org.proyecto.model.Proceso;
import org.proyecto.services.intefaces.AppServices;

/**
 *
 * @author ORIGAMI
 */
@ViewScoped
@Named
public class ProcesoMB implements Serializable {

    @Inject
    private AppServices appServices;

    private List<Proceso> procesos;

    @PostConstruct
    public void init() {
        procesos = appServices.methodListGET(
                Constantes.appUrl + "consultarProcesos", Proceso[].class);
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

}
