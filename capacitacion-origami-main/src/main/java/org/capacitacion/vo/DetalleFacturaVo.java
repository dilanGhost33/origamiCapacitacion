package org.capacitacion.vo;

import lombok.Data;
import org.capacitacion.dto.ProductoDto;

import java.io.Serializable;

@Data
public class DetalleFacturaVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
