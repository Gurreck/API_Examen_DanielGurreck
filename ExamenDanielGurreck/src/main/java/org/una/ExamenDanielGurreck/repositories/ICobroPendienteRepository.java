package org.una.ExamenDanielGurreck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ExamenDanielGurreck.entities.CobroPendiente;

import java.util.List;

public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente, Long> {

    public List<CobroPendiente> findByMembresiaId(Long id);

}
