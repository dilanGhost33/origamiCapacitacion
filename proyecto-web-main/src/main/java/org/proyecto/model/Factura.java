/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.proyecto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class Factura implements Serializable{
    
    private Long idFactura;
    private Cliente cliente;
    private Date fecha;
    private double total;
    private List<DetalleFactura> detalles;

    public Factura() {
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", detalles=" + detalles + '}';
    }
    
    
    
}
