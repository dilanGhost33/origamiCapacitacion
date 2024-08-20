package org.capacitacion.respository;

import org.capacitacion.entidad.Marcacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacionRepository extends JpaRepository<Marcacion, Long> {
}
