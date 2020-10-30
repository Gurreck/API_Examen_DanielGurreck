package org.una.ExamenDanielGurreck.services;

import org.una.ExamenDanielGurreck.dto.CobroPendienteDTO;

import java.util.List;
import java.util.Optional;

public interface ICobroPendienteService {

    public Optional<List<CobroPendienteDTO>> findAll();

    public Optional<CobroPendienteDTO> findById(Long id);

    public Optional<List<CobroPendienteDTO>> findByMembresiaId(Long id);

    public Double cobroPendienteMonto(Long idCobroPendiente);

    public CobroPendienteDTO create(CobroPendienteDTO cobroPendiente);

    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendiente, Long id);

    public void delete(Long id);

}
