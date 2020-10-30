package org.una.ExamenDanielGurreck.services;

import org.una.ExamenDanielGurreck.dto.TipoServicioDTO;
import java.util.List;
import java.util.Optional;

public interface ITipoServicioService {

    public Optional<List<TipoServicioDTO>> findAll();

    public Optional<TipoServicioDTO> findById(Long id);

    public Optional<TipoServicioDTO> findByNombre(String nombre);

    public TipoServicioDTO create(TipoServicioDTO tipoServicio);

    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicio, Long id);
}
