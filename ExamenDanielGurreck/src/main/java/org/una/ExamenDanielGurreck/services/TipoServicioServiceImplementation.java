package org.una.ExamenDanielGurreck.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ExamenDanielGurreck.dto.TipoServicioDTO;
import org.una.ExamenDanielGurreck.entities.TipoServicio;
import org.una.ExamenDanielGurreck.repositories.ITipoServicioRepository;
import org.una.ExamenDanielGurreck.utils.MapperUtils;

@Service
public class TipoServicioServiceImplementation implements ITipoServicioService{
    @Autowired
    private ITipoServicioRepository tipoServicioRepository;

    private Optional<List<TipoServicioDTO>> findList(List<TipoServicio> list) {
        if (list != null) {
            List<TipoServicioDTO> tipoServicioDTO = MapperUtils.DtoListFromEntityList(list, TipoServicioDTO.class);
            return Optional.ofNullable(tipoServicioDTO);
        } else {
            return null;
        }
    }

    private Optional<List<TipoServicioDTO>> findList(Optional<List<TipoServicio>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<TipoServicioDTO> oneToDto(Optional<TipoServicio> one) {
        if (one.isPresent()) {
            TipoServicioDTO tipoServicioDTO = MapperUtils.DtoFromEntity(one.get(), TipoServicioDTO.class);
            return Optional.ofNullable(tipoServicioDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoServicioDTO>> findAll() {
        return findList(tipoServicioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoServicioDTO> findById(Long id) {
        return oneToDto(tipoServicioRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoServicioDTO> findByNombre(String nombre) {
        return oneToDto(Optional.ofNullable(tipoServicioRepository.findByNombre(nombre)));
    }

    @Override
    @Transactional
    public TipoServicioDTO create(TipoServicioDTO tipoServicioDTO) {
        TipoServicio tipoServicio = MapperUtils.EntityFromDto(tipoServicioDTO, TipoServicio.class);
        tipoServicio = tipoServicioRepository.save(tipoServicio);
        return MapperUtils.DtoFromEntity(tipoServicio, TipoServicioDTO.class);
    }

    @Override
    @Transactional
    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicioDTO, Long id) {
        if (tipoServicioRepository.findById(id).isPresent()) {
            TipoServicio tipoServicio = MapperUtils.EntityFromDto(tipoServicioDTO, TipoServicio.class);
            tipoServicio = tipoServicioRepository.save(tipoServicio);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tipoServicio, TipoServicioDTO.class));
        } else {
            return null;
        }
    }
}
