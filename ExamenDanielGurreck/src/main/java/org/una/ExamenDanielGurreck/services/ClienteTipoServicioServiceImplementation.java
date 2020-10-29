package org.una.ExamenDanielGurreck.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ExamenDanielGurreck.dto.ClienteTipoServicioDTO;
import org.una.ExamenDanielGurreck.entities.ClienteTipoServicio;
import org.una.ExamenDanielGurreck.repositories.IClienteTipoServicioRepository;
import org.una.ExamenDanielGurreck.utils.MapperUtils;


@Service
public class ClienteTipoServicioServiceImplementation implements IClienteTipoServicioService {

    @Autowired
    private IClienteTipoServicioRepository clienteTipoServicioRepository;

    private Optional<List<ClienteTipoServicioDTO>> findList(List<ClienteTipoServicio> list) {
        if (list != null) {
            List<ClienteTipoServicioDTO> clienteTipoServicioDTO = MapperUtils.DtoListFromEntityList(list, ClienteTipoServicioDTO.class);
            return Optional.ofNullable(clienteTipoServicioDTO);
        } else {
            return null;
        }
    }

    private Optional<List<ClienteTipoServicioDTO>> findList(Optional<List<ClienteTipoServicio>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<ClienteTipoServicioDTO> oneToDto(Optional<ClienteTipoServicio> one) {
        if (one.isPresent()) {
            ClienteTipoServicioDTO clienteTipoServicioDTO = MapperUtils.DtoFromEntity(one.get(), ClienteTipoServicioDTO.class);
            return Optional.ofNullable(clienteTipoServicioDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteTipoServicioDTO>> findAll() {
        return findList(clienteTipoServicioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteTipoServicioDTO> findById(Long id) {
        return oneToDto(clienteTipoServicioRepository.findById(id));
    }

    @Override
    @Transactional
    public ClienteTipoServicioDTO create(ClienteTipoServicioDTO clienteTipoServicioDTO) {
        ClienteTipoServicio clienteTipoServicio = MapperUtils.EntityFromDto(clienteTipoServicioDTO,ClienteTipoServicio.class);
        clienteTipoServicio = clienteTipoServicioRepository.save(clienteTipoServicio);
        return MapperUtils.DtoFromEntity(clienteTipoServicio, ClienteTipoServicioDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteTipoServicioDTO> update(ClienteTipoServicioDTO clienteTipoServicioDTO, Long id) {
        if (clienteTipoServicioRepository.findById(id).isPresent()) {
            ClienteTipoServicio clienteTipoServicio = MapperUtils.EntityFromDto(clienteTipoServicioDTO, ClienteTipoServicio.class);
            clienteTipoServicio = clienteTipoServicioRepository.save(clienteTipoServicio);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(clienteTipoServicio, ClienteTipoServicioDTO.class));
        } else {
            return null;
        }
    }
}
