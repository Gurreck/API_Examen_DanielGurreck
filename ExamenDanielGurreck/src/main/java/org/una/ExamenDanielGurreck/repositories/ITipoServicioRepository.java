package org.una.ExamenDanielGurreck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ExamenDanielGurreck.entities.TipoServicio;

public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Long> {

    public TipoServicio findByNombre(String nombre);
}
