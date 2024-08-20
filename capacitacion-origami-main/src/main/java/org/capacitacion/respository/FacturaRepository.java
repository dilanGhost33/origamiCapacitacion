package org.capacitacion.respository;

import org.capacitacion.entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
    @Query("SELECT DISTINCT f FROM Factura f " +
            "LEFT JOIN FETCH f.detalleFacturas df " +
            "LEFT JOIN FETCH df.producto " +
            "WHERE f.id = :id")
    Optional<Factura> findByIdWithDetailsAndProducts(@Param("id") long id);

}
