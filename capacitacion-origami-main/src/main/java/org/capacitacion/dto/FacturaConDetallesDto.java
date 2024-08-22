package org.capacitacion.dto;


import org.capacitacion.entidad.DetalleFactura;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FacturaConDetallesDto implements Serializable {
    private Long idFactura;
    private Long idCliente;
    private Date fecha;
    private double total;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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


}
