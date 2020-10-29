package org.una.ExamenDanielGurreck.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ExamenDanielGurreck.dto.CobroPendienteDTO;
import org.una.ExamenDanielGurreck.entities.CobroPendiente;
import org.una.ExamenDanielGurreck.repositories.ICobroPendienteRepository;
import org.una.ExamenDanielGurreck.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService{

    @Autowired
    private ICobroPendienteRepository cobroPendienteRepository;

    private Optional<List<CobroPendienteDTO>> findList(List<CobroPendiente> list) {
        if (list != null) {
            List<CobroPendienteDTO> cobroPendienteDTO = MapperUtils.DtoListFromEntityList(list, CobroPendienteDTO.class);
            return Optional.ofNullable(cobroPendienteDTO);
        } else {
            return null;
        }
    }
    private Optional<List<CobroPendienteDTO>> findList(Optional<List<CobroPendiente>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }
    private Optional<CobroPendienteDTO> oneToDto(Optional<CobroPendiente> one) {
        if (one.isPresent()) {
            CobroPendienteDTO cobroPendienteDTO = MapperUtils.DtoFromEntity(one.get(), CobroPendienteDTO.class);
            return Optional.ofNullable(cobroPendienteDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findAll() {

        return findList(cobroPendienteRepository.findAll());

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroPendienteDTO> findById(Long id) {

        return oneToDto(cobroPendienteRepository.findById(id));

    }

    @Override
    @Transactional
    public CobroPendienteDTO create(CobroPendienteDTO cobroPendienteDTO) {
        CobroPendiente cobroPendiente = MapperUtils.EntityFromDto(cobroPendienteDTO, CobroPendiente.class);
        cobroPendiente = cobroPendienteRepository.save(cobroPendiente);
        return MapperUtils.DtoFromEntity(cobroPendiente, CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendienteDTO, Long id) {
        if (cobroPendienteRepository.findById(id).isPresent()) {
            CobroPendiente cobroPendiente = MapperUtils.EntityFromDto(cobroPendienteDTO, CobroPendiente.class);
            cobroPendiente = cobroPendienteRepository.save(cobroPendiente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobroPendiente, CobroPendienteDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        cobroPendienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {

        cobroPendienteRepository.deleteAll();

    }

}
