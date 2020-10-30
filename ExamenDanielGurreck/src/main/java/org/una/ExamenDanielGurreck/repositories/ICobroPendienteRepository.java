package org.una.ExamenDanielGurreck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.ExamenDanielGurreck.entities.CobroPendiente;

import java.util.List;

public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente, Long> {

    public List<CobroPendiente> findByMembresiaId(Long id);

    @Query(value = "SELECT (SELECT mem.monto FROM Membresia mem WHERE mem.id IN (SELECT cob.membresia FROM CobroPendiente cob WHERE cob.id = ?1))"
            + " / (SELECT mem.periodicidad FROM Membresia mem WHERE mem.id IN (SELECT cob.membresia FROM CobroPendiente cob WHERE cob.id = ?1)),mem.id FROM  Membresia mem WHERE mem.id IN (SELECT cob.membresia FROM CobroPendiente cob WHERE cob.id = ?1)")
    public Double cobroPendienteMonto(Long idCobroPendiente);

}
