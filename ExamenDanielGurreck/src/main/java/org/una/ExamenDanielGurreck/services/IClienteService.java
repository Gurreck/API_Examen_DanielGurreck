package org.una.ExamenDanielGurreck.services;

import org.una.ExamenDanielGurreck.dto.ClienteDTO;
import java.util.List;
import java.util.Optional;

public interface IClienteService {

    public Optional<List<ClienteDTO>> findAll();

    public Optional<ClienteDTO> findById(Long id);

    public ClienteDTO create(ClienteDTO clienteDTO);

    public Optional<ClienteDTO> update(ClienteDTO clienteDTO, Long id);

}
