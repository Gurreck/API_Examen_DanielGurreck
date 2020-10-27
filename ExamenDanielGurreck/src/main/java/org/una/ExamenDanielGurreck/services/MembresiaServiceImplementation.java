package org.una.ExamenDanielGurreck.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ExamenDanielGurreck.dto.MembresiaDTO;
import org.una.ExamenDanielGurreck.entities.Membresia;
import org.una.ExamenDanielGurreck.repositories.IMembresiaRepository;
import org.una.ExamenDanielGurreck.utils.MapperUtils;

@Service
public class MembresiaServiceImplementation  implements IMembresiaService {

    @Autowired
    private IMembresiaRepository membresiaRepository;

    private Optional<List<MembresiaDTO>> findList(List<Membresia> list) {
        if (list != null) {
            List<MembresiaDTO> membresiaDTO = MapperUtils.DtoListFromEntityList(list, MembresiaDTO.class);
            return Optional.ofNullable(membresiaDTO);
        } else {
            return null;
        }
    }

    private Optional<List<MembresiaDTO>> findList(Optional<List<Membresia>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional<MembresiaDTO> oneToDto(Optional<Membresia> one) {
        if (one.isPresent()) {
            MembresiaDTO MembresiaDTO = MapperUtils.DtoFromEntity(one.get(), MembresiaDTO.class);
            return Optional.ofNullable(MembresiaDTO);
        } else {
            return null;
        }
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
        return findList(membresiaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
        return oneToDto(membresiaRepository.findById(id));
    }

    @Override
    @Transactional
    public MembresiaDTO create(MembresiaDTO membresiaDTO) {
        Membresia membresia = MapperUtils.EntityFromDto(membresiaDTO, Membresia.class);
        membresia = membresiaRepository.save(membresia);
        return MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class);
    }

    @Override
    @Transactional
    public Optional<MembresiaDTO> update(MembresiaDTO membresiaDTO, Long id) {
        if (membresiaRepository.findById(id).isPresent()) {
            Membresia membresia = MapperUtils.EntityFromDto(membresiaDTO, Membresia.class);
            membresia = membresiaRepository.save(membresia);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class));
        } else {
            return null;
        }
    }
}
