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
import org.proyecto.model.Area;
import org.proyecto.model.Proceso;
import org.proyecto.model.Proyecto;
import org.proyecto.services.intefaces.AppServices;

/**
 *
 * @author ORIGAMI
 */
@ViewScoped
@Named
public class ProyectoMB implements Serializable {

    private Logger LOG = Logger.getLogger(ProyectoMB.class.getName());

    @Inject
    private AppServices appServices;

    private List<Area> areas;
    private List<Proceso> procesos;

    private Proyecto proyecto;

    @PostConstruct
    public void init() {
        proyecto = new Proyecto();
        areas = appServices.methodListGET(Constantes.appUrl + "consultarArea", Area[].class);
        procesos = appServices.methodListGET(
                Constantes.appUrl + "consultarProcesos", Proceso[].class);
    }

    public void guardarProyecto() {
        try {
            LOG.info("guardarProyecto");
            Proyecto p = (Proyecto) appServices.methodPOST(proyecto, Constantes.appUrl + "guardarProyecto", Proyecto.class);
            if (p != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
