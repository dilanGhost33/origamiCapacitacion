package org.capacitacion.vo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.capacitacion.dto.ClienteDto;
import org.capacitacion.dto.DetalleFacturaDto;
import org.capacitacion.entidad.DetalleFactura;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Data
public class FacturaVo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private long idCliente;
    private Date fecha;
    private double total;
    private List<DetalleFacturaVo> detalles;
}
