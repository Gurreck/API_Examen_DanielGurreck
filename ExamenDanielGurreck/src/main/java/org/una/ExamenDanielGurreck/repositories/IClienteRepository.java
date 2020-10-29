package org.una.ExamenDanielGurreck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ExamenDanielGurreck.entities.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
