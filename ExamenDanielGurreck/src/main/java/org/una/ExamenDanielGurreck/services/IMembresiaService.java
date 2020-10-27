package org.una.ExamenDanielGurreck.services;

import org.una.ExamenDanielGurreck.dto.MembresiaDTO;
import java.util.List;
import java.util.Optional;

public interface IMembresiaService {

    public Optional<List<MembresiaDTO>> findAll();

    public Optional<MembresiaDTO> findById(Long id);

    public MembresiaDTO create(MembresiaDTO  membresiaDTO);

    public Optional<MembresiaDTO> update(MembresiaDTO  membresiaDTO, Long id);

}
