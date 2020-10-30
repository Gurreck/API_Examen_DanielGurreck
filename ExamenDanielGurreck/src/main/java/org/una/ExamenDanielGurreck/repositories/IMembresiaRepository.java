package org.una.ExamenDanielGurreck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.ExamenDanielGurreck.entities.Membresia;

import java.util.List;

public interface IMembresiaRepository  extends JpaRepository<Membresia, Long> {

    @Query(value = "SELECT t FROM Membresia t JOIN t.clienteTipoServicio po JOIN po.cliente u where u.id=:id")
    public List<Membresia> findMembresiasByClienteId(Long id);

}
