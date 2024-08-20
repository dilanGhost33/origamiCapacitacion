package org.capacitacion.dto;

import java.util.Date;
import java.util.List;

public class FacturaDto {
    private Long idFactura;
    private ClienteDto Cliente;
    private Date fecha;
    private double total;

    private List<DetalleFacturaDto> detalles;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public ClienteDto getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteDto cliente) {
        Cliente = cliente;
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

    public List<DetalleFacturaDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaDto> detalles) {
        this.detalles = detalles;
    }
}
