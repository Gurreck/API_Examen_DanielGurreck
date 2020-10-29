package org.una.ExamenDanielGurreck.services;

import org.una.ExamenDanielGurreck.dto.ClienteTipoServicioDTO;
import org.una.ExamenDanielGurreck.entities.ClienteTipoServicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IClienteTipoServicioService {

    public Optional<List<ClienteTipoServicioDTO>> findAll();

    public Optional<ClienteTipoServicioDTO> findById(Long id);

    public ClienteTipoServicioDTO create(ClienteTipoServicioDTO clienteTipoServicioDTO);

    public Optional<ClienteTipoServicioDTO> update(ClienteTipoServicioDTO clienteTipoServicioDTO, Long id);
}
