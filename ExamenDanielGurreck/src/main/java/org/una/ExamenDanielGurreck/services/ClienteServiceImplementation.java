package org.una.ExamenDanielGurreck.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ExamenDanielGurreck.dto.ClienteDTO;
import org.una.ExamenDanielGurreck.entities.Cliente;
import org.una.ExamenDanielGurreck.repositories.IClienteRepository;
import org.una.ExamenDanielGurreck.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplementation implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    private Optional<List<ClienteDTO>> findList(List<Cliente> list) {
        if (list != null) {
            List<ClienteDTO> clientesDTO = MapperUtils.DtoListFromEntityList(list, ClienteDTO.class);
            return Optional.ofNullable(clientesDTO);
        } else {
            return null;
        }
    }
    private Optional<List<ClienteDTO>> findList(Optional<List<Cliente>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<ClienteDTO> oneToDto(Optional<Cliente> one) {
        if (one.isPresent()) {
            ClienteDTO clienteDTO = MapperUtils.DtoFromEntity(one.get(), ClienteDTO.class);
            return Optional.ofNullable(clienteDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {

        return findList(clienteRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return oneToDto(clienteRepository.findById(id));
    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = MapperUtils.EntityFromDto(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return MapperUtils.DtoFromEntity(cliente, ClienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> update(ClienteDTO clienteDTO, Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            Cliente cliente = MapperUtils.EntityFromDto(clienteDTO, Cliente.class);
            cliente = clienteRepository.save(cliente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cliente, ClienteDTO.class));
        } else {
            return null;
        }
    }
}
