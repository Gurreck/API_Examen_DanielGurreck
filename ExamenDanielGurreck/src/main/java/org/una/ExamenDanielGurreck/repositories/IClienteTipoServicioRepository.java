package org.una.ExamenDanielGurreck.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ExamenDanielGurreck.entities.ClienteTipoServicio;


public interface IClienteTipoServicioRepository extends JpaRepository<ClienteTipoServicio, Long> {
}
