package org.una.ExamenDanielGurreck.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.ExamenDanielGurreck.dto.CobroPendienteDTO;
import org.una.ExamenDanielGurreck.services.ICobroPendienteService;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cobrosPendientes")
@Api(tags = {"Cobros Pendientes"})
public class CobroPendienteController{

    @Autowired
    private ICobroPendienteService cobroPendienteService;

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/findAll")
    @ApiOperation(value = "Obtiene una lista de todos los cobros pendientes", response = CobroPendienteDTO.class, responseContainer = "List", tags = "Cobros Pendientes")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(cobroPendienteService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Obtiene un cobro pendiente por su Id", response = CobroPendienteDTO.class, tags = "Cobros Pendientes")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(cobroPendienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Permite crear un cobro pendiente", response = CobroPendienteDTO.class, tags = "Cobros Pendientes")
    public ResponseEntity<?> create(@Valid @RequestBody CobroPendienteDTO cobroPendienteDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(cobroPendienteService.create(cobroPendienteDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Permite modificar un cobro pendiente a partir de su Id", response = CobroPendienteDTO.class, tags = "Cobros Pendientes")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody CobroPendienteDTO cobroPendienteDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<CobroPendienteDTO> cobroPendienteUpdated = cobroPendienteService.update(cobroPendienteDTO, id);
                if (cobroPendienteUpdated.isPresent()) {
                    return new ResponseEntity(cobroPendienteUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Permite eliminar un cobro pendiente a partir de su Id", response = CobroPendienteDTO.class, tags = "Cobros Pendientes")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            cobroPendienteService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
