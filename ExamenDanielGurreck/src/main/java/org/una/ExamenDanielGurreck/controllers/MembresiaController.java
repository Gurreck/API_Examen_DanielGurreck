package org.una.ExamenDanielGurreck.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.ExamenDanielGurreck.dto.MembresiaDTO;
import org.una.ExamenDanielGurreck.services.ICobroPendienteService;
import org.una.ExamenDanielGurreck.services.IMembresiaService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/membresias")
@Api(tags = {"Membresias"})
public class MembresiaController {
    @Autowired
    private IMembresiaService membresiaService;

    @Autowired
    private ICobroPendienteService cobroPendienteService;

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/findAll")
    @ApiOperation(value = "Obtiene una lista de todas las membresias", response = MembresiaDTO.class, responseContainer = "List", tags = "Membresias")
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(membresiaService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Obtiene la membresia por medio del Id", response = MembresiaDTO.class, tags = "Membresias")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(membresiaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findMembresiasByClienteId/{id}")
    @ApiOperation(value = "Obtiene una lista de las membrecias por el id del cliente", response = MembresiaDTO.class, responseContainer = "List", tags = "Membresias")
    ResponseEntity<?> findMembresiasByClienteId(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(membresiaService.findMembresiasByClienteId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Permite crear una Membresia", response = MembresiaDTO.class, tags = "Membresias")
    public ResponseEntity<?> create(@Valid @RequestBody MembresiaDTO membresiaDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {

                return new ResponseEntity(membresiaService.create(membresiaDTO), HttpStatus.CREATED);

            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Permite modificar una membresia a partir de su Id", response = MembresiaDTO.class, tags = "Membresias")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody MembresiaDTO membresiaDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<MembresiaDTO> membresiaUpdated = membresiaService.update(membresiaDTO, id);
                if (membresiaUpdated.isPresent()) {
                    return new ResponseEntity(membresiaUpdated, HttpStatus.OK);
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

}
